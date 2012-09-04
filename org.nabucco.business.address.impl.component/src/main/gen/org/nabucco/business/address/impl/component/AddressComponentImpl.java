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
package org.nabucco.business.address.impl.component;

import org.nabucco.business.address.facade.component.AddressComponentLocal;
import org.nabucco.business.address.facade.component.AddressComponentRemote;
import org.nabucco.business.address.facade.service.maintain.MaintainAddress;
import org.nabucco.business.address.facade.service.produce.ProduceAddress;
import org.nabucco.business.address.facade.service.resolve.ResolveAddress;
import org.nabucco.business.address.facade.service.search.SearchAddress;
import org.nabucco.framework.base.facade.component.handler.PostConstructHandler;
import org.nabucco.framework.base.facade.component.handler.PreDestroyHandler;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;
import org.nabucco.framework.base.impl.component.ComponentSupport;

/**
 * AddressComponentImpl<p/>Component for Address and Contact Management.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-12-07
 */
public class AddressComponentImpl extends ComponentSupport implements AddressComponentLocal, AddressComponentRemote {

    private static final long serialVersionUID = 1L;

    private static final String ID = "AddressComponent";

    /** Constructs a new AddressComponentImpl instance. */
    public AddressComponentImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PostConstructHandler handler = injector.inject(PostConstructHandler.getId());
        if ((handler == null)) {
            if (super.getLogger().isDebugEnabled()) {
                super.getLogger().debug("No post construct handler configured for \'", ID, "\'.");
            }
            return;
        }
        handler.setLocatable(this);
        handler.setLogger(super.getLogger());
        handler.invoke();
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PreDestroyHandler handler = injector.inject(PreDestroyHandler.getId());
        if ((handler == null)) {
            if (super.getLogger().isDebugEnabled()) {
                super.getLogger().debug("No pre destroy handler configured for \'", ID, "\'.");
            }
            return;
        }
        handler.setLocatable(this);
        handler.setLogger(super.getLogger());
        handler.invoke();
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getName() {
        return COMPONENT_NAME;
    }

    @Override
    public String getJndiName() {
        return JNDI_NAME;
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return super
                .lookup(AddressComponentJndiNames.COMPONENT_RELATION_SERVICE_REMOTE, ComponentRelationService.class);
    }

    @Override
    public ComponentRelationService getComponentRelationServiceLocal() throws ServiceException {
        return super.lookup(AddressComponentJndiNames.COMPONENT_RELATION_SERVICE_LOCAL, ComponentRelationService.class);
    }

    @Override
    public QueryFilterService getQueryFilterService() throws ServiceException {
        return super.lookup(AddressComponentJndiNames.QUERY_FILTER_SERVICE_REMOTE, QueryFilterService.class);
    }

    @Override
    public QueryFilterService getQueryFilterServiceLocal() throws ServiceException {
        return super.lookup(AddressComponentJndiNames.QUERY_FILTER_SERVICE_LOCAL, QueryFilterService.class);
    }

    @Override
    public MaintainAddress getMaintainAddressLocal() throws ServiceException {
        return super.lookup(AddressComponentJndiNames.MAINTAIN_ADDRESS_LOCAL, MaintainAddress.class);
    }

    @Override
    public MaintainAddress getMaintainAddress() throws ServiceException {
        return super.lookup(AddressComponentJndiNames.MAINTAIN_ADDRESS_REMOTE, MaintainAddress.class);
    }

    @Override
    public ProduceAddress getProduceAddressLocal() throws ServiceException {
        return super.lookup(AddressComponentJndiNames.PRODUCE_ADDRESS_LOCAL, ProduceAddress.class);
    }

    @Override
    public ProduceAddress getProduceAddress() throws ServiceException {
        return super.lookup(AddressComponentJndiNames.PRODUCE_ADDRESS_REMOTE, ProduceAddress.class);
    }

    @Override
    public ResolveAddress getResolveAddressLocal() throws ServiceException {
        return super.lookup(AddressComponentJndiNames.RESOLVE_ADDRESS_LOCAL, ResolveAddress.class);
    }

    @Override
    public ResolveAddress getResolveAddress() throws ServiceException {
        return super.lookup(AddressComponentJndiNames.RESOLVE_ADDRESS_REMOTE, ResolveAddress.class);
    }

    @Override
    public SearchAddress getSearchAddressLocal() throws ServiceException {
        return super.lookup(AddressComponentJndiNames.SEARCH_ADDRESS_LOCAL, SearchAddress.class);
    }

    @Override
    public SearchAddress getSearchAddress() throws ServiceException {
        return super.lookup(AddressComponentJndiNames.SEARCH_ADDRESS_REMOTE, SearchAddress.class);
    }
}
