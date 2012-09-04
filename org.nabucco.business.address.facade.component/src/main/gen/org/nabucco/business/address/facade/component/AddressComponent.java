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
import org.nabucco.framework.base.facade.component.Component;
import org.nabucco.framework.base.facade.exception.service.ServiceException;

/**
 * AddressComponent<p/>Component for Address and Contact Management.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-12-07
 */
public interface AddressComponent extends Component {

    final String COMPONENT_NAME = "org.nabucco.business.address";

    final String COMPONENT_PREFIX = "addr";

    final String JNDI_NAME = ((((JNDI_PREFIX + "/") + COMPONENT_NAME) + "/") + "org.nabucco.business.address.facade.component.AddressComponent");

    /**
     * Getter for the MaintainAddress.
     *
     * @return the MaintainAddress.
     * @throws ServiceException
     */
    MaintainAddress getMaintainAddress() throws ServiceException;

    /**
     * Getter for the ProduceAddress.
     *
     * @return the ProduceAddress.
     * @throws ServiceException
     */
    ProduceAddress getProduceAddress() throws ServiceException;

    /**
     * Getter for the ResolveAddress.
     *
     * @return the ResolveAddress.
     * @throws ServiceException
     */
    ResolveAddress getResolveAddress() throws ServiceException;

    /**
     * Getter for the SearchAddress.
     *
     * @return the SearchAddress.
     * @throws ServiceException
     */
    SearchAddress getSearchAddress() throws ServiceException;
}
