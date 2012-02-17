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
package org.nabucco.business.address.impl.service.maintain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.business.address.facade.message.EmailAddressListMsg;
import org.nabucco.business.address.facade.message.EmailAddressMsg;
import org.nabucco.business.address.facade.message.PhoneAddressListMsg;
import org.nabucco.business.address.facade.message.PhoneAddressMsg;
import org.nabucco.business.address.facade.message.PostBoxAddressListMsg;
import org.nabucco.business.address.facade.message.PostBoxAddressMsg;
import org.nabucco.business.address.facade.message.PostalAddressListMsg;
import org.nabucco.business.address.facade.message.PostalAddressMsg;
import org.nabucco.business.address.facade.message.WebAddressListMsg;
import org.nabucco.business.address.facade.message.WebAddressMsg;
import org.nabucco.business.address.facade.service.maintain.MaintainAddress;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * MaintainAddressImpl<p/>Maintain Service for Address Datatypes.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2012-01-12
 */
public class MaintainAddressImpl extends ServiceSupport implements MaintainAddress {

    private static final long serialVersionUID = 1L;

    private static final String ID = "MaintainAddress";

    private static Map<String, String[]> ASPECTS;

    private MaintainEmailAddressServiceHandler maintainEmailAddressServiceHandler;

    private MaintainEmailAddressListServiceHandler maintainEmailAddressListServiceHandler;

    private MaintainPostalAddressServiceHandler maintainPostalAddressServiceHandler;

    private MaintainPostalAddressListServiceHandler maintainPostalAddressListServiceHandler;

    private MaintainPostBoxAddressServiceHandler maintainPostBoxAddressServiceHandler;

    private MaintainPostBoxAddressListServiceHandler maintainPostBoxAddressListServiceHandler;

    private MaintainPhoneAddressServiceHandler maintainPhoneAddressServiceHandler;

    private MaintainPhoneAddressListServiceHandler maintainPhoneAddressListServiceHandler;

    private MaintainWebAddressServiceHandler maintainWebAddressServiceHandler;

    private MaintainWebAddressListServiceHandler maintainWebAddressListServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new MaintainAddressImpl instance. */
    public MaintainAddressImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.maintainEmailAddressServiceHandler = injector.inject(MaintainEmailAddressServiceHandler.getId());
        if ((this.maintainEmailAddressServiceHandler != null)) {
            this.maintainEmailAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainEmailAddressServiceHandler.setLogger(super.getLogger());
        }
        this.maintainEmailAddressListServiceHandler = injector.inject(MaintainEmailAddressListServiceHandler.getId());
        if ((this.maintainEmailAddressListServiceHandler != null)) {
            this.maintainEmailAddressListServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainEmailAddressListServiceHandler.setLogger(super.getLogger());
        }
        this.maintainPostalAddressServiceHandler = injector.inject(MaintainPostalAddressServiceHandler.getId());
        if ((this.maintainPostalAddressServiceHandler != null)) {
            this.maintainPostalAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainPostalAddressServiceHandler.setLogger(super.getLogger());
        }
        this.maintainPostalAddressListServiceHandler = injector.inject(MaintainPostalAddressListServiceHandler.getId());
        if ((this.maintainPostalAddressListServiceHandler != null)) {
            this.maintainPostalAddressListServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainPostalAddressListServiceHandler.setLogger(super.getLogger());
        }
        this.maintainPostBoxAddressServiceHandler = injector.inject(MaintainPostBoxAddressServiceHandler.getId());
        if ((this.maintainPostBoxAddressServiceHandler != null)) {
            this.maintainPostBoxAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainPostBoxAddressServiceHandler.setLogger(super.getLogger());
        }
        this.maintainPostBoxAddressListServiceHandler = injector.inject(MaintainPostBoxAddressListServiceHandler
                .getId());
        if ((this.maintainPostBoxAddressListServiceHandler != null)) {
            this.maintainPostBoxAddressListServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainPostBoxAddressListServiceHandler.setLogger(super.getLogger());
        }
        this.maintainPhoneAddressServiceHandler = injector.inject(MaintainPhoneAddressServiceHandler.getId());
        if ((this.maintainPhoneAddressServiceHandler != null)) {
            this.maintainPhoneAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainPhoneAddressServiceHandler.setLogger(super.getLogger());
        }
        this.maintainPhoneAddressListServiceHandler = injector.inject(MaintainPhoneAddressListServiceHandler.getId());
        if ((this.maintainPhoneAddressListServiceHandler != null)) {
            this.maintainPhoneAddressListServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainPhoneAddressListServiceHandler.setLogger(super.getLogger());
        }
        this.maintainWebAddressServiceHandler = injector.inject(MaintainWebAddressServiceHandler.getId());
        if ((this.maintainWebAddressServiceHandler != null)) {
            this.maintainWebAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainWebAddressServiceHandler.setLogger(super.getLogger());
        }
        this.maintainWebAddressListServiceHandler = injector.inject(MaintainWebAddressListServiceHandler.getId());
        if ((this.maintainWebAddressListServiceHandler != null)) {
            this.maintainWebAddressListServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainWebAddressListServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("maintainEmailAddress", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.journaling" });
            ASPECTS.put("maintainEmailAddressList", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.journaling" });
            ASPECTS.put("maintainPostalAddress", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.journaling" });
            ASPECTS.put("maintainPostalAddressList", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.journaling" });
            ASPECTS.put("maintainPostBoxAddress", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.journaling" });
            ASPECTS.put("maintainPostBoxAddressList", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.journaling" });
            ASPECTS.put("maintainPhoneAddress", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.journaling" });
            ASPECTS.put("maintainPhoneAddressList", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.journaling" });
            ASPECTS.put("maintainWebAddress", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.journaling" });
            ASPECTS.put("maintainWebAddressList", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving",
                    "org.nabucco.aspect.journaling" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<EmailAddressMsg> maintainEmailAddress(ServiceRequest<EmailAddressMsg> rq)
            throws MaintainException {
        if ((this.maintainEmailAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainEmailAddress().");
            throw new InjectionException("No service implementation configured for maintainEmailAddress().");
        }
        ServiceResponse<EmailAddressMsg> rs;
        this.maintainEmailAddressServiceHandler.init();
        rs = this.maintainEmailAddressServiceHandler.invoke(rq);
        this.maintainEmailAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<EmailAddressListMsg> maintainEmailAddressList(ServiceRequest<EmailAddressListMsg> rq)
            throws MaintainException {
        if ((this.maintainEmailAddressListServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainEmailAddressList().");
            throw new InjectionException("No service implementation configured for maintainEmailAddressList().");
        }
        ServiceResponse<EmailAddressListMsg> rs;
        this.maintainEmailAddressListServiceHandler.init();
        rs = this.maintainEmailAddressListServiceHandler.invoke(rq);
        this.maintainEmailAddressListServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PostalAddressMsg> maintainPostalAddress(ServiceRequest<PostalAddressMsg> rq)
            throws MaintainException {
        if ((this.maintainPostalAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainPostalAddress().");
            throw new InjectionException("No service implementation configured for maintainPostalAddress().");
        }
        ServiceResponse<PostalAddressMsg> rs;
        this.maintainPostalAddressServiceHandler.init();
        rs = this.maintainPostalAddressServiceHandler.invoke(rq);
        this.maintainPostalAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PostalAddressListMsg> maintainPostalAddressList(ServiceRequest<PostalAddressListMsg> rq)
            throws MaintainException {
        if ((this.maintainPostalAddressListServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainPostalAddressList().");
            throw new InjectionException("No service implementation configured for maintainPostalAddressList().");
        }
        ServiceResponse<PostalAddressListMsg> rs;
        this.maintainPostalAddressListServiceHandler.init();
        rs = this.maintainPostalAddressListServiceHandler.invoke(rq);
        this.maintainPostalAddressListServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PostBoxAddressMsg> maintainPostBoxAddress(ServiceRequest<PostBoxAddressMsg> rq)
            throws MaintainException {
        if ((this.maintainPostBoxAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainPostBoxAddress().");
            throw new InjectionException("No service implementation configured for maintainPostBoxAddress().");
        }
        ServiceResponse<PostBoxAddressMsg> rs;
        this.maintainPostBoxAddressServiceHandler.init();
        rs = this.maintainPostBoxAddressServiceHandler.invoke(rq);
        this.maintainPostBoxAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PostBoxAddressListMsg> maintainPostBoxAddressList(ServiceRequest<PostBoxAddressListMsg> rq)
            throws MaintainException {
        if ((this.maintainPostBoxAddressListServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainPostBoxAddressList().");
            throw new InjectionException("No service implementation configured for maintainPostBoxAddressList().");
        }
        ServiceResponse<PostBoxAddressListMsg> rs;
        this.maintainPostBoxAddressListServiceHandler.init();
        rs = this.maintainPostBoxAddressListServiceHandler.invoke(rq);
        this.maintainPostBoxAddressListServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PhoneAddressMsg> maintainPhoneAddress(ServiceRequest<PhoneAddressMsg> rq)
            throws MaintainException {
        if ((this.maintainPhoneAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainPhoneAddress().");
            throw new InjectionException("No service implementation configured for maintainPhoneAddress().");
        }
        ServiceResponse<PhoneAddressMsg> rs;
        this.maintainPhoneAddressServiceHandler.init();
        rs = this.maintainPhoneAddressServiceHandler.invoke(rq);
        this.maintainPhoneAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PhoneAddressListMsg> maintainPhoneAddressList(ServiceRequest<PhoneAddressListMsg> rq)
            throws MaintainException {
        if ((this.maintainPhoneAddressListServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainPhoneAddressList().");
            throw new InjectionException("No service implementation configured for maintainPhoneAddressList().");
        }
        ServiceResponse<PhoneAddressListMsg> rs;
        this.maintainPhoneAddressListServiceHandler.init();
        rs = this.maintainPhoneAddressListServiceHandler.invoke(rq);
        this.maintainPhoneAddressListServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<WebAddressMsg> maintainWebAddress(ServiceRequest<WebAddressMsg> rq) throws MaintainException {
        if ((this.maintainWebAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainWebAddress().");
            throw new InjectionException("No service implementation configured for maintainWebAddress().");
        }
        ServiceResponse<WebAddressMsg> rs;
        this.maintainWebAddressServiceHandler.init();
        rs = this.maintainWebAddressServiceHandler.invoke(rq);
        this.maintainWebAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<WebAddressListMsg> maintainWebAddressList(ServiceRequest<WebAddressListMsg> rq)
            throws MaintainException {
        if ((this.maintainWebAddressListServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainWebAddressList().");
            throw new InjectionException("No service implementation configured for maintainWebAddressList().");
        }
        ServiceResponse<WebAddressListMsg> rs;
        this.maintainWebAddressListServiceHandler.init();
        rs = this.maintainWebAddressListServiceHandler.invoke(rq);
        this.maintainWebAddressListServiceHandler.finish();
        return rs;
    }
}
