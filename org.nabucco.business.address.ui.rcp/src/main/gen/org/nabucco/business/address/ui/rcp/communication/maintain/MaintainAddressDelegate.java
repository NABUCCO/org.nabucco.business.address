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
package org.nabucco.business.address.ui.rcp.communication.maintain;

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
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * MaintainAddressDelegate<p/>Maintain Service for Address Datatypes.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2012-01-12
 */
public class MaintainAddressDelegate extends ServiceDelegateSupport {

    private MaintainAddress service;

    /**
     * Constructs a new MaintainAddressDelegate instance.
     *
     * @param service the MaintainAddress.
     */
    public MaintainAddressDelegate(MaintainAddress service) {
        super();
        this.service = service;
    }

    /**
     * MaintainEmailAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmailAddressMsg.
     * @return the EmailAddressMsg.
     * @throws ClientException
     */
    public EmailAddressMsg maintainEmailAddress(EmailAddressMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EmailAddressMsg> request = new ServiceRequest<EmailAddressMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmailAddressMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainEmailAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainAddress.class, "maintainEmailAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainAddress.maintainEmailAddress");
    }

    /**
     * MaintainEmailAddressList.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmailAddressListMsg.
     * @return the EmailAddressListMsg.
     * @throws ClientException
     */
    public EmailAddressListMsg maintainEmailAddressList(EmailAddressListMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EmailAddressListMsg> request = new ServiceRequest<EmailAddressListMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmailAddressListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainEmailAddressList(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainAddress.class, "maintainEmailAddressList", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainAddress.maintainEmailAddressList");
    }

    /**
     * MaintainPostalAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PostalAddressMsg.
     * @return the PostalAddressMsg.
     * @throws ClientException
     */
    public PostalAddressMsg maintainPostalAddress(PostalAddressMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<PostalAddressMsg> request = new ServiceRequest<PostalAddressMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PostalAddressMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainPostalAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainAddress.class, "maintainPostalAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainAddress.maintainPostalAddress");
    }

    /**
     * MaintainPostalAddressList.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PostalAddressListMsg.
     * @return the PostalAddressListMsg.
     * @throws ClientException
     */
    public PostalAddressListMsg maintainPostalAddressList(PostalAddressListMsg message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<PostalAddressListMsg> request = new ServiceRequest<PostalAddressListMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PostalAddressListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainPostalAddressList(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainAddress.class, "maintainPostalAddressList", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainAddress.maintainPostalAddressList");
    }

    /**
     * MaintainPostBoxAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PostBoxAddressMsg.
     * @return the PostBoxAddressMsg.
     * @throws ClientException
     */
    public PostBoxAddressMsg maintainPostBoxAddress(PostBoxAddressMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<PostBoxAddressMsg> request = new ServiceRequest<PostBoxAddressMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PostBoxAddressMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainPostBoxAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainAddress.class, "maintainPostBoxAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainAddress.maintainPostBoxAddress");
    }

    /**
     * MaintainPostBoxAddressList.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PostBoxAddressListMsg.
     * @return the PostBoxAddressListMsg.
     * @throws ClientException
     */
    public PostBoxAddressListMsg maintainPostBoxAddressList(PostBoxAddressListMsg message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<PostBoxAddressListMsg> request = new ServiceRequest<PostBoxAddressListMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PostBoxAddressListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainPostBoxAddressList(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainAddress.class, "maintainPostBoxAddressList", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainAddress.maintainPostBoxAddressList");
    }

    /**
     * MaintainPhoneAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PhoneAddressMsg.
     * @return the PhoneAddressMsg.
     * @throws ClientException
     */
    public PhoneAddressMsg maintainPhoneAddress(PhoneAddressMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<PhoneAddressMsg> request = new ServiceRequest<PhoneAddressMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PhoneAddressMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainPhoneAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainAddress.class, "maintainPhoneAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainAddress.maintainPhoneAddress");
    }

    /**
     * MaintainPhoneAddressList.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PhoneAddressListMsg.
     * @return the PhoneAddressListMsg.
     * @throws ClientException
     */
    public PhoneAddressListMsg maintainPhoneAddressList(PhoneAddressListMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<PhoneAddressListMsg> request = new ServiceRequest<PhoneAddressListMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PhoneAddressListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainPhoneAddressList(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainAddress.class, "maintainPhoneAddressList", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainAddress.maintainPhoneAddressList");
    }

    /**
     * MaintainWebAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the WebAddressMsg.
     * @return the WebAddressMsg.
     * @throws ClientException
     */
    public WebAddressMsg maintainWebAddress(WebAddressMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<WebAddressMsg> request = new ServiceRequest<WebAddressMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<WebAddressMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainWebAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainAddress.class, "maintainWebAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainAddress.maintainWebAddress");
    }

    /**
     * MaintainWebAddressList.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the WebAddressListMsg.
     * @return the WebAddressListMsg.
     * @throws ClientException
     */
    public WebAddressListMsg maintainWebAddressList(WebAddressListMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<WebAddressListMsg> request = new ServiceRequest<WebAddressListMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<WebAddressListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainWebAddressList(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainAddress.class, "maintainWebAddressList", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainAddress.maintainWebAddressList");
    }
}
