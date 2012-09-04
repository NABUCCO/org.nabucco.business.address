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
package org.nabucco.business.address.facade.component;

import org.nabucco.business.address.facade.service.maintain.MaintainAddress;
import org.nabucco.business.address.facade.service.produce.ProduceAddress;
import org.nabucco.business.address.facade.service.resolve.ResolveAddress;
import org.nabucco.business.address.facade.service.search.SearchAddress;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;

/**
 * AddressComponentLocal<p/>Component for Address and Contact Management.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-12-07
 */
public interface AddressComponentLocal extends AddressComponent {

    /**
     * Getter for the ComponentRelationServiceLocal.
     *
     * @return the ComponentRelationService.
     * @throws ServiceException
     */
    ComponentRelationService getComponentRelationServiceLocal() throws ServiceException;

    /**
     * Getter for the QueryFilterServiceLocal.
     *
     * @return the QueryFilterService.
     * @throws ServiceException
     */
    QueryFilterService getQueryFilterServiceLocal() throws ServiceException;

    /**
     * Getter for the MaintainAddressLocal.
     *
     * @return the MaintainAddress.
     * @throws ServiceException
     */
    MaintainAddress getMaintainAddressLocal() throws ServiceException;

    /**
     * Getter for the ProduceAddressLocal.
     *
     * @return the ProduceAddress.
     * @throws ServiceException
     */
    ProduceAddress getProduceAddressLocal() throws ServiceException;

    /**
     * Getter for the ResolveAddressLocal.
     *
     * @return the ResolveAddress.
     * @throws ServiceException
     */
    ResolveAddress getResolveAddressLocal() throws ServiceException;

    /**
     * Getter for the SearchAddressLocal.
     *
     * @return the SearchAddress.
     * @throws ServiceException
     */
    SearchAddress getSearchAddressLocal() throws ServiceException;
}
