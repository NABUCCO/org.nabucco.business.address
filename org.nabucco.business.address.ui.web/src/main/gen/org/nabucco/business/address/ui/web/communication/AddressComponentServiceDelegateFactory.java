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
package org.nabucco.business.address.ui.web.communication;

import org.nabucco.business.address.facade.component.AddressComponent;
import org.nabucco.business.address.facade.component.AddressComponentLocator;
import org.nabucco.business.address.ui.web.communication.maintain.MaintainAddressDelegate;
import org.nabucco.business.address.ui.web.communication.produce.ProduceAddressDelegate;
import org.nabucco.business.address.ui.web.communication.resolve.ResolveAddressDelegate;
import org.nabucco.business.address.ui.web.communication.search.SearchAddressDelegate;
import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateFactorySupport;

/**
 * ServiceDelegateFactoryTemplate<p/>Component for Address and Contact Management.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-12-07
 */
public class AddressComponentServiceDelegateFactory extends ServiceDelegateFactorySupport<AddressComponent> {

    private static AddressComponentServiceDelegateFactory instance = new AddressComponentServiceDelegateFactory();

    private MaintainAddressDelegate maintainAddressDelegate;

    private ProduceAddressDelegate produceAddressDelegate;

    private ResolveAddressDelegate resolveAddressDelegate;

    private SearchAddressDelegate searchAddressDelegate;

    /** Constructs a new AddressComponentServiceDelegateFactory instance. */
    private AddressComponentServiceDelegateFactory() {
        super(AddressComponentLocator.getInstance());
    }

    /**
     * Getter for the MaintainAddress.
     *
     * @return the MaintainAddressDelegate.
     * @throws ClientException
     */
    public MaintainAddressDelegate getMaintainAddress() throws ClientException {
        try {
            if ((this.maintainAddressDelegate == null)) {
                this.maintainAddressDelegate = new MaintainAddressDelegate(this.getComponent().getMaintainAddress());
            }
            return this.maintainAddressDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: MaintainAddress", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the ProduceAddress.
     *
     * @return the ProduceAddressDelegate.
     * @throws ClientException
     */
    public ProduceAddressDelegate getProduceAddress() throws ClientException {
        try {
            if ((this.produceAddressDelegate == null)) {
                this.produceAddressDelegate = new ProduceAddressDelegate(this.getComponent().getProduceAddress());
            }
            return this.produceAddressDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: ProduceAddress", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the ResolveAddress.
     *
     * @return the ResolveAddressDelegate.
     * @throws ClientException
     */
    public ResolveAddressDelegate getResolveAddress() throws ClientException {
        try {
            if ((this.resolveAddressDelegate == null)) {
                this.resolveAddressDelegate = new ResolveAddressDelegate(this.getComponent().getResolveAddress());
            }
            return this.resolveAddressDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: ResolveAddress", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the SearchAddress.
     *
     * @return the SearchAddressDelegate.
     * @throws ClientException
     */
    public SearchAddressDelegate getSearchAddress() throws ClientException {
        try {
            if ((this.searchAddressDelegate == null)) {
                this.searchAddressDelegate = new SearchAddressDelegate(this.getComponent().getSearchAddress());
            }
            return this.searchAddressDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: SearchAddress", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the Instance.
     *
     * @return the AddressComponentServiceDelegateFactory.
     */
    public static AddressComponentServiceDelegateFactory getInstance() {
        return instance;
    }
}
