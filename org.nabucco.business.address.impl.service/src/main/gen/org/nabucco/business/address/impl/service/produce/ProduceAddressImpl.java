/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.business.address.impl.service.produce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.business.address.facade.message.EmailAddressListMsg;
import org.nabucco.business.address.facade.message.PhoneAddressListMsg;
import org.nabucco.business.address.facade.message.PostBoxAddressListMsg;
import org.nabucco.business.address.facade.message.PostalAddressListMsg;
import org.nabucco.business.address.facade.message.WebAddressListMsg;
import org.nabucco.business.address.facade.message.produce.EmailAddressProduceRq;
import org.nabucco.business.address.facade.message.produce.PhoneAddressProduceRq;
import org.nabucco.business.address.facade.message.produce.PostBoxAddressProduceRq;
import org.nabucco.business.address.facade.message.produce.PostalAddressProduceRq;
import org.nabucco.business.address.facade.message.produce.WebAddressProduceRq;
import org.nabucco.business.address.facade.service.produce.ProduceAddress;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * ProduceAddressImpl<p/>Produce Service for Address Datatypes.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2012-01-12
 */
public class ProduceAddressImpl extends ServiceSupport implements ProduceAddress {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ProduceAddress";

    private static Map<String, String[]> ASPECTS;

    private ProduceEmailAddressServiceHandler produceEmailAddressServiceHandler;

    private ProducePostalAddressServiceHandler producePostalAddressServiceHandler;

    private ProducePostBoxAddressServiceHandler producePostBoxAddressServiceHandler;

    private ProducePhoneAddressServiceHandler producePhoneAddressServiceHandler;

    private ProduceWebAddressServiceHandler produceWebAddressServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ProduceAddressImpl instance. */
    public ProduceAddressImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.produceEmailAddressServiceHandler = injector.inject(ProduceEmailAddressServiceHandler.getId());
        if ((this.produceEmailAddressServiceHandler != null)) {
            this.produceEmailAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.produceEmailAddressServiceHandler.setLogger(super.getLogger());
        }
        this.producePostalAddressServiceHandler = injector.inject(ProducePostalAddressServiceHandler.getId());
        if ((this.producePostalAddressServiceHandler != null)) {
            this.producePostalAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.producePostalAddressServiceHandler.setLogger(super.getLogger());
        }
        this.producePostBoxAddressServiceHandler = injector.inject(ProducePostBoxAddressServiceHandler.getId());
        if ((this.producePostBoxAddressServiceHandler != null)) {
            this.producePostBoxAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.producePostBoxAddressServiceHandler.setLogger(super.getLogger());
        }
        this.producePhoneAddressServiceHandler = injector.inject(ProducePhoneAddressServiceHandler.getId());
        if ((this.producePhoneAddressServiceHandler != null)) {
            this.producePhoneAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.producePhoneAddressServiceHandler.setLogger(super.getLogger());
        }
        this.produceWebAddressServiceHandler = injector.inject(ProduceWebAddressServiceHandler.getId());
        if ((this.produceWebAddressServiceHandler != null)) {
            this.produceWebAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.produceWebAddressServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("produceEmailAddress", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("producePostalAddress", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("producePostBoxAddress", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("producePhoneAddress", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceWebAddress", new String[] { "org.nabucco.aspect.initializing" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<EmailAddressListMsg> produceEmailAddress(ServiceRequest<EmailAddressProduceRq> rq)
            throws ProduceException {
        if ((this.produceEmailAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceEmailAddress().");
            throw new InjectionException("No service implementation configured for produceEmailAddress().");
        }
        ServiceResponse<EmailAddressListMsg> rs;
        this.produceEmailAddressServiceHandler.init();
        rs = this.produceEmailAddressServiceHandler.invoke(rq);
        this.produceEmailAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PostalAddressListMsg> producePostalAddress(ServiceRequest<PostalAddressProduceRq> rq)
            throws ProduceException {
        if ((this.producePostalAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for producePostalAddress().");
            throw new InjectionException("No service implementation configured for producePostalAddress().");
        }
        ServiceResponse<PostalAddressListMsg> rs;
        this.producePostalAddressServiceHandler.init();
        rs = this.producePostalAddressServiceHandler.invoke(rq);
        this.producePostalAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PostBoxAddressListMsg> producePostBoxAddress(ServiceRequest<PostBoxAddressProduceRq> rq)
            throws ProduceException {
        if ((this.producePostBoxAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for producePostBoxAddress().");
            throw new InjectionException("No service implementation configured for producePostBoxAddress().");
        }
        ServiceResponse<PostBoxAddressListMsg> rs;
        this.producePostBoxAddressServiceHandler.init();
        rs = this.producePostBoxAddressServiceHandler.invoke(rq);
        this.producePostBoxAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PhoneAddressListMsg> producePhoneAddress(ServiceRequest<PhoneAddressProduceRq> rq)
            throws ProduceException {
        if ((this.producePhoneAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for producePhoneAddress().");
            throw new InjectionException("No service implementation configured for producePhoneAddress().");
        }
        ServiceResponse<PhoneAddressListMsg> rs;
        this.producePhoneAddressServiceHandler.init();
        rs = this.producePhoneAddressServiceHandler.invoke(rq);
        this.producePhoneAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<WebAddressListMsg> produceWebAddress(ServiceRequest<WebAddressProduceRq> rq)
            throws ProduceException {
        if ((this.produceWebAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceWebAddress().");
            throw new InjectionException("No service implementation configured for produceWebAddress().");
        }
        ServiceResponse<WebAddressListMsg> rs;
        this.produceWebAddressServiceHandler.init();
        rs = this.produceWebAddressServiceHandler.invoke(rq);
        this.produceWebAddressServiceHandler.finish();
        return rs;
    }
}
