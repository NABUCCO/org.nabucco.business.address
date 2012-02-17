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
package org.nabucco.business.address.ui.rcp.communication.search;

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
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * SearchAddressDelegate<p/>Search Service for Address Datatypes.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2012-01-12
 */
public class SearchAddressDelegate extends ServiceDelegateSupport {

    private SearchAddress service;

    /**
     * Constructs a new SearchAddressDelegate instance.
     *
     * @param service the SearchAddress.
     */
    public SearchAddressDelegate(SearchAddress service) {
        super();
        this.service = service;
    }

    /**
     * SearchEmailAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmailAddressSearchRq.
     * @return the EmailAddressListMsg.
     * @throws ClientException
     */
    public EmailAddressListMsg searchEmailAddress(EmailAddressSearchRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EmailAddressSearchRq> request = new ServiceRequest<EmailAddressSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmailAddressListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchEmailAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchAddress.class, "searchEmailAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchAddress.searchEmailAddress");
    }

    /**
     * SearchPostalAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PostalAddressSearchRq.
     * @return the PostalAddressListMsg.
     * @throws ClientException
     */
    public PostalAddressListMsg searchPostalAddress(PostalAddressSearchRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<PostalAddressSearchRq> request = new ServiceRequest<PostalAddressSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PostalAddressListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchPostalAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchAddress.class, "searchPostalAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchAddress.searchPostalAddress");
    }

    /**
     * SearchPostBoxAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PostBoxAddressSearchRq.
     * @return the PostBoxAddressListMsg.
     * @throws ClientException
     */
    public PostBoxAddressListMsg searchPostBoxAddress(PostBoxAddressSearchRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<PostBoxAddressSearchRq> request = new ServiceRequest<PostBoxAddressSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PostBoxAddressListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchPostBoxAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchAddress.class, "searchPostBoxAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchAddress.searchPostBoxAddress");
    }

    /**
     * SearchPhoneAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PhoneAddressSearchRq.
     * @return the PhoneAddressListMsg.
     * @throws ClientException
     */
    public PhoneAddressListMsg searchPhoneAddress(PhoneAddressSearchRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<PhoneAddressSearchRq> request = new ServiceRequest<PhoneAddressSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PhoneAddressListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchPhoneAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchAddress.class, "searchPhoneAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchAddress.searchPhoneAddress");
    }

    /**
     * SearchWebAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the WebAddressSearchRq.
     * @return the WebAddressListMsg.
     * @throws ClientException
     */
    public WebAddressListMsg searchWebAddress(WebAddressSearchRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<WebAddressSearchRq> request = new ServiceRequest<WebAddressSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<WebAddressListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchWebAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchAddress.class, "searchWebAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchAddress.searchWebAddress");
    }

    /**
     * SearchAddresses.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the AddressSearchRq.
     * @return the AddressListMsg.
     * @throws ClientException
     */
    public AddressListMsg searchAddresses(AddressSearchRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<AddressSearchRq> request = new ServiceRequest<AddressSearchRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<AddressListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchAddresses(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchAddress.class, "searchAddresses", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchAddress.searchAddresses");
    }
}
