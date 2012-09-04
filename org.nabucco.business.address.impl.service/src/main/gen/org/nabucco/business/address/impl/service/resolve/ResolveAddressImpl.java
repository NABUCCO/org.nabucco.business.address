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
package org.nabucco.business.address.impl.service.resolve;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.business.address.facade.message.EmailAddressMsg;
import org.nabucco.business.address.facade.message.PhoneAddressMsg;
import org.nabucco.business.address.facade.message.PostBoxAddressMsg;
import org.nabucco.business.address.facade.message.PostalAddressMsg;
import org.nabucco.business.address.facade.message.WebAddressMsg;
import org.nabucco.business.address.facade.message.resolve.ResolveDatatypeListRq;
import org.nabucco.business.address.facade.message.resolve.ResolveDatatypeListRs;
import org.nabucco.business.address.facade.message.resolve.ResolveDefaultPostalAddressRq;
import org.nabucco.business.address.facade.service.resolve.ResolveAddress;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * ResolveAddressImpl<p/>Resolve Service for Address Datatypes.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2012-01-12
 */
public class ResolveAddressImpl extends ServiceSupport implements ResolveAddress {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ResolveAddress";

    private static Map<String, String[]> ASPECTS;

    private ResolveEmailAddressServiceHandler resolveEmailAddressServiceHandler;

    private ResolvePostalAddressServiceHandler resolvePostalAddressServiceHandler;

    private ResolvePostBoxAddressServiceHandler resolvePostBoxAddressServiceHandler;

    private ResolvePhoneAddressServiceHandler resolvePhoneAddressServiceHandler;

    private ResolveWebAddressServiceHandler resolveWebAddressServiceHandler;

    private ResolveDatatypeListServiceHandler resolveDatatypeListServiceHandler;

    private ResolveDefaultPostalAddressServiceHandler resolveDefaultPostalAddressServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ResolveAddressImpl instance. */
    public ResolveAddressImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.resolveEmailAddressServiceHandler = injector.inject(ResolveEmailAddressServiceHandler.getId());
        if ((this.resolveEmailAddressServiceHandler != null)) {
            this.resolveEmailAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveEmailAddressServiceHandler.setLogger(super.getLogger());
        }
        this.resolvePostalAddressServiceHandler = injector.inject(ResolvePostalAddressServiceHandler.getId());
        if ((this.resolvePostalAddressServiceHandler != null)) {
            this.resolvePostalAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.resolvePostalAddressServiceHandler.setLogger(super.getLogger());
        }
        this.resolvePostBoxAddressServiceHandler = injector.inject(ResolvePostBoxAddressServiceHandler.getId());
        if ((this.resolvePostBoxAddressServiceHandler != null)) {
            this.resolvePostBoxAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.resolvePostBoxAddressServiceHandler.setLogger(super.getLogger());
        }
        this.resolvePhoneAddressServiceHandler = injector.inject(ResolvePhoneAddressServiceHandler.getId());
        if ((this.resolvePhoneAddressServiceHandler != null)) {
            this.resolvePhoneAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.resolvePhoneAddressServiceHandler.setLogger(super.getLogger());
        }
        this.resolveWebAddressServiceHandler = injector.inject(ResolveWebAddressServiceHandler.getId());
        if ((this.resolveWebAddressServiceHandler != null)) {
            this.resolveWebAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveWebAddressServiceHandler.setLogger(super.getLogger());
        }
        this.resolveDatatypeListServiceHandler = injector.inject(ResolveDatatypeListServiceHandler.getId());
        if ((this.resolveDatatypeListServiceHandler != null)) {
            this.resolveDatatypeListServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveDatatypeListServiceHandler.setLogger(super.getLogger());
        }
        this.resolveDefaultPostalAddressServiceHandler = injector.inject(ResolveDefaultPostalAddressServiceHandler
                .getId());
        if ((this.resolveDefaultPostalAddressServiceHandler != null)) {
            this.resolveDefaultPostalAddressServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveDefaultPostalAddressServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("resolveEmailAddress",
                    new String[] { "org.nabucco.aspect.permissioning", "org.nabucco.aspect.validating",
                            "org.nabucco.aspect.constraining", "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolvePostalAddress",
                    new String[] { "org.nabucco.aspect.permissioning", "org.nabucco.aspect.validating",
                            "org.nabucco.aspect.constraining", "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolvePostBoxAddress",
                    new String[] { "org.nabucco.aspect.permissioning", "org.nabucco.aspect.validating",
                            "org.nabucco.aspect.constraining", "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolvePhoneAddress",
                    new String[] { "org.nabucco.aspect.permissioning", "org.nabucco.aspect.validating",
                            "org.nabucco.aspect.constraining", "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveWebAddress",
                    new String[] { "org.nabucco.aspect.permissioning", "org.nabucco.aspect.validating",
                            "org.nabucco.aspect.constraining", "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveDatatypeList",
                    new String[] { "org.nabucco.aspect.permissioning", "org.nabucco.aspect.validating",
                            "org.nabucco.aspect.constraining", "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveDefaultPostalAddress",
                    new String[] { "org.nabucco.aspect.permissioning", "org.nabucco.aspect.validating",
                            "org.nabucco.aspect.constraining", "org.nabucco.aspect.resolving" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<EmailAddressMsg> resolveEmailAddress(ServiceRequest<EmailAddressMsg> rq)
            throws ResolveException {
        if ((this.resolveEmailAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveEmailAddress().");
            throw new InjectionException("No service implementation configured for resolveEmailAddress().");
        }
        ServiceResponse<EmailAddressMsg> rs;
        this.resolveEmailAddressServiceHandler.init();
        rs = this.resolveEmailAddressServiceHandler.invoke(rq);
        this.resolveEmailAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PostalAddressMsg> resolvePostalAddress(ServiceRequest<PostalAddressMsg> rq)
            throws ResolveException {
        if ((this.resolvePostalAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolvePostalAddress().");
            throw new InjectionException("No service implementation configured for resolvePostalAddress().");
        }
        ServiceResponse<PostalAddressMsg> rs;
        this.resolvePostalAddressServiceHandler.init();
        rs = this.resolvePostalAddressServiceHandler.invoke(rq);
        this.resolvePostalAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PostBoxAddressMsg> resolvePostBoxAddress(ServiceRequest<PostBoxAddressMsg> rq)
            throws ResolveException {
        if ((this.resolvePostBoxAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolvePostBoxAddress().");
            throw new InjectionException("No service implementation configured for resolvePostBoxAddress().");
        }
        ServiceResponse<PostBoxAddressMsg> rs;
        this.resolvePostBoxAddressServiceHandler.init();
        rs = this.resolvePostBoxAddressServiceHandler.invoke(rq);
        this.resolvePostBoxAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PhoneAddressMsg> resolvePhoneAddress(ServiceRequest<PhoneAddressMsg> rq)
            throws ResolveException {
        if ((this.resolvePhoneAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolvePhoneAddress().");
            throw new InjectionException("No service implementation configured for resolvePhoneAddress().");
        }
        ServiceResponse<PhoneAddressMsg> rs;
        this.resolvePhoneAddressServiceHandler.init();
        rs = this.resolvePhoneAddressServiceHandler.invoke(rq);
        this.resolvePhoneAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<WebAddressMsg> resolveWebAddress(ServiceRequest<WebAddressMsg> rq) throws ResolveException {
        if ((this.resolveWebAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveWebAddress().");
            throw new InjectionException("No service implementation configured for resolveWebAddress().");
        }
        ServiceResponse<WebAddressMsg> rs;
        this.resolveWebAddressServiceHandler.init();
        rs = this.resolveWebAddressServiceHandler.invoke(rq);
        this.resolveWebAddressServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ResolveDatatypeListRs> resolveDatatypeList(ServiceRequest<ResolveDatatypeListRq> rq)
            throws ResolveException {
        if ((this.resolveDatatypeListServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveDatatypeList().");
            throw new InjectionException("No service implementation configured for resolveDatatypeList().");
        }
        ServiceResponse<ResolveDatatypeListRs> rs;
        this.resolveDatatypeListServiceHandler.init();
        rs = this.resolveDatatypeListServiceHandler.invoke(rq);
        this.resolveDatatypeListServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PostalAddressMsg> resolveDefaultPostalAddress(
            ServiceRequest<ResolveDefaultPostalAddressRq> rq) throws ResolveException {
        if ((this.resolveDefaultPostalAddressServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveDefaultPostalAddress().");
            throw new InjectionException("No service implementation configured for resolveDefaultPostalAddress().");
        }
        ServiceResponse<PostalAddressMsg> rs;
        this.resolveDefaultPostalAddressServiceHandler.init();
        rs = this.resolveDefaultPostalAddressServiceHandler.invoke(rq);
        this.resolveDefaultPostalAddressServiceHandler.finish();
        return rs;
    }
}
