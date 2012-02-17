/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.business.address.impl.service.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.business.address.facade.message.AddressListMsg;
import org.nabucco.business.address.facade.message.EmailAddressListMsg;
import org.nabucco.business.address.facade.message.PhoneAddressListMsg;
import org.nabucco.business.address.facade.message.PostBoxAddressListMsg;
import org.nabucco.business.address.facade.message.PostalAddressListMsg;
import org.nabucco.business.address.facade.message.WebAddressListMsg;
import org.nabucco.business.address.facade.message.search.AddressSearchRq;
import org.nabucco.business.address.facade.message.search.EmailAddressSearchRq;
import org.nabucco.business.address.facade.message.search.PhoneAddressSearchRq;
import org.nabucco.business.address.facade.message.search.PostBoxAddressSearchRq;
import org.nabucco.business.address.facade.message.search.PostalAddressSearchRq;
import org.nabucco.business.address.facade.message.search.WebAddressSearchRq;
import org.nabucco.business.address.facade.service.search.SearchAddress;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * SearchAddressImpl<p/>Search Service for Address Datatypes.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2012-01-12
 */
public class SearchAddressImpl extends ServiceSupport implements SearchAddress {

    private static final long serialVersionUID = 1L;

    private static final String ID = "SearchAddress";

    private static Map<String, String[]> ASPECTS;

    private SearchEmailAddressServiceHandler searchEmailAddressServiceHandler;

    private SearchPostalAddressServiceHandler searchPostalAddressServiceHandler;

    private SearchPostBoxAddressServiceHandler searchPostBoxAddressServiceHandler;

    private SearchPhoneAddressServiceHandler searchPhoneAddressServiceHandler;

    private SearchWebAddressServiceHandler searchWebAddressServiceHandler;

    private SearchAddressesServiceHandler searchAddressesServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new SearchAddressImpl instance. */
    public SearchAddressImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.searchEmailAddressServiceHandler = injector.inject(SearchEmailAddressServiceHandler.getId());
        if ((this.searchEmailAddressServiceHandler != null)) {
            this.searchEmailAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.searchEmailAddressServiceHandler.setLogger(super.getLogger());
        }
        this.searchPostalAddressServiceHandler = injector.inject(SearchPostalAddressServiceHandler.getId());
        if ((this.searchPostalAddressServiceHandler != null)) {
            this.searchPostalAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.searchPostalAddressServiceHandler.setLogger(super.getLogger());
        }
        this.searchPostBoxAddressServiceHandler = injector.inject(SearchPostBoxAddressServiceHandler.getId());
        if ((this.searchPostBoxAddressServiceHandler != null)) {
            this.searchPostBoxAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.searchPostBoxAddressServiceHandler.setLogger(super.getLogger());
        }
        this.searchPhoneAddressServiceHandler = injector.inject(SearchPhoneAddressServiceHandler.getId());
        if ((this.searchPhoneAddressServiceHandler != null)) {
            this.searchPhoneAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.searchPhoneAddressServiceHandler.setLogger(super.getLogger());
        }
        this.searchWebAddressServiceHandler = injector.inject(SearchWebAddressServiceHandler.getId());
        if ((this.searchWebAddressServiceHandler != null)) {
            this.searchWebAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.searchWebAddressServiceHandler.setLogger(super.getLogger());
        }
        this.searchAddressesServiceHandler = injector.inject(SearchAddressesServiceHandler.getId());
        if ((this.searchAddressesServiceHandler != null)) {
            this.searchAddressesServiceHandler.setPersistenceManager(persistenceManager);
            this.searchAddressesServiceHandler.setLogger(super.getLogger());
        }
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
    }

    @Override
    public String[] getAspects(String operationName) {
        if ((ASPECTS == null)) {
            ASPECTS = new HashMap<String, String[]>();
            ASPECTS.put("searchEmailAddress", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchPostalAddress", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchPostBoxAddress", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchPhoneAddress", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchWebAddress", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchAddresses", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.resolving" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<EmailAddressListMsg> searchEmailAddress(ServiceRequest<EmailAddressSearchRq> rq)
            throws SearchException {
        if ((this.searchEmailAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchEmailAddress().");
            throw new InjectionException("No service implementation configured for searchEmailAddress().");
        }
        ServiceResponse<EmailAddressListMsg> rs;
        this.searchEmailAddressServiceHandler.init();
        rs = this.searchEmailAddressServiceHandler.invoke(rq);
        this.searchEmailAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PostalAddressListMsg> searchPostalAddress(ServiceRequest<PostalAddressSearchRq> rq)
            throws SearchException {
        if ((this.searchPostalAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchPostalAddress().");
            throw new InjectionException("No service implementation configured for searchPostalAddress().");
        }
        ServiceResponse<PostalAddressListMsg> rs;
        this.searchPostalAddressServiceHandler.init();
        rs = this.searchPostalAddressServiceHandler.invoke(rq);
        this.searchPostalAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PostBoxAddressListMsg> searchPostBoxAddress(ServiceRequest<PostBoxAddressSearchRq> rq)
            throws SearchException {
        if ((this.searchPostBoxAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchPostBoxAddress().");
            throw new InjectionException("No service implementation configured for searchPostBoxAddress().");
        }
        ServiceResponse<PostBoxAddressListMsg> rs;
        this.searchPostBoxAddressServiceHandler.init();
        rs = this.searchPostBoxAddressServiceHandler.invoke(rq);
        this.searchPostBoxAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PhoneAddressListMsg> searchPhoneAddress(ServiceRequest<PhoneAddressSearchRq> rq)
            throws SearchException {
        if ((this.searchPhoneAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchPhoneAddress().");
            throw new InjectionException("No service implementation configured for searchPhoneAddress().");
        }
        ServiceResponse<PhoneAddressListMsg> rs;
        this.searchPhoneAddressServiceHandler.init();
        rs = this.searchPhoneAddressServiceHandler.invoke(rq);
        this.searchPhoneAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<WebAddressListMsg> searchWebAddress(ServiceRequest<WebAddressSearchRq> rq)
            throws SearchException {
        if ((this.searchWebAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchWebAddress().");
            throw new InjectionException("No service implementation configured for searchWebAddress().");
        }
        ServiceResponse<WebAddressListMsg> rs;
        this.searchWebAddressServiceHandler.init();
        rs = this.searchWebAddressServiceHandler.invoke(rq);
        this.searchWebAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<AddressListMsg> searchAddresses(ServiceRequest<AddressSearchRq> rq) throws SearchException {
        if ((this.searchAddressesServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchAddresses().");
            throw new InjectionException("No service implementation configured for searchAddresses().");
        }
        ServiceResponse<AddressListMsg> rs;
        this.searchAddressesServiceHandler.init();
        rs = this.searchAddressesServiceHandler.invoke(rq);
        this.searchAddressesServiceHandler.finish();
        return rs;
    }
}
