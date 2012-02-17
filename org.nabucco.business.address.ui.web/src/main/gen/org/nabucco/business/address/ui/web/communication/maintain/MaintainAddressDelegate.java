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
package org.nabucco.business.address.ui.web.communication.maintain;

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
import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;

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
     * @param session the NabuccoSession.
     * @param message the EmailAddressMsg.
     * @return the EmailAddressMsg.
     * @throws MaintainException
     */
    public EmailAddressMsg maintainEmailAddress(EmailAddressMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<EmailAddressMsg> request = new ServiceRequest<EmailAddressMsg>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmailAddressMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainAddress.maintainEmailAddress");
    }

    /**
     * MaintainEmailAddressList.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the EmailAddressListMsg.
     * @return the EmailAddressListMsg.
     * @throws MaintainException
     */
    public EmailAddressListMsg maintainEmailAddressList(EmailAddressListMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<EmailAddressListMsg> request = new ServiceRequest<EmailAddressListMsg>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmailAddressListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainAddress.maintainEmailAddressList");
    }

    /**
     * MaintainPostalAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the PostalAddressMsg.
     * @return the PostalAddressMsg.
     * @throws MaintainException
     */
    public PostalAddressMsg maintainPostalAddress(PostalAddressMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<PostalAddressMsg> request = new ServiceRequest<PostalAddressMsg>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PostalAddressMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainAddress.maintainPostalAddress");
    }

    /**
     * MaintainPostalAddressList.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the PostalAddressListMsg.
     * @return the PostalAddressListMsg.
     * @throws MaintainException
     */
    public PostalAddressListMsg maintainPostalAddressList(PostalAddressListMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<PostalAddressListMsg> request = new ServiceRequest<PostalAddressListMsg>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PostalAddressListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainAddress.maintainPostalAddressList");
    }

    /**
     * MaintainPostBoxAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the PostBoxAddressMsg.
     * @return the PostBoxAddressMsg.
     * @throws MaintainException
     */
    public PostBoxAddressMsg maintainPostBoxAddress(PostBoxAddressMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<PostBoxAddressMsg> request = new ServiceRequest<PostBoxAddressMsg>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PostBoxAddressMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainAddress.maintainPostBoxAddress");
    }

    /**
     * MaintainPostBoxAddressList.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the PostBoxAddressListMsg.
     * @return the PostBoxAddressListMsg.
     * @throws MaintainException
     */
    public PostBoxAddressListMsg maintainPostBoxAddressList(PostBoxAddressListMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<PostBoxAddressListMsg> request = new ServiceRequest<PostBoxAddressListMsg>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PostBoxAddressListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainAddress.maintainPostBoxAddressList");
    }

    /**
     * MaintainPhoneAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the PhoneAddressMsg.
     * @return the PhoneAddressMsg.
     * @throws MaintainException
     */
    public PhoneAddressMsg maintainPhoneAddress(PhoneAddressMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<PhoneAddressMsg> request = new ServiceRequest<PhoneAddressMsg>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PhoneAddressMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainAddress.maintainPhoneAddress");
    }

    /**
     * MaintainPhoneAddressList.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the PhoneAddressListMsg.
     * @return the PhoneAddressListMsg.
     * @throws MaintainException
     */
    public PhoneAddressListMsg maintainPhoneAddressList(PhoneAddressListMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<PhoneAddressListMsg> request = new ServiceRequest<PhoneAddressListMsg>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PhoneAddressListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainAddress.maintainPhoneAddressList");
    }

    /**
     * MaintainWebAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the WebAddressMsg.
     * @return the WebAddressMsg.
     * @throws MaintainException
     */
    public WebAddressMsg maintainWebAddress(WebAddressMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<WebAddressMsg> request = new ServiceRequest<WebAddressMsg>(super.createServiceContext(session,
                subContexts));
        request.setRequestMessage(message);
        ServiceResponse<WebAddressMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainAddress.maintainWebAddress");
    }

    /**
     * MaintainWebAddressList.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the WebAddressListMsg.
     * @return the WebAddressListMsg.
     * @throws MaintainException
     */
    public WebAddressListMsg maintainWebAddressList(WebAddressListMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws MaintainException {
        ServiceRequest<WebAddressListMsg> request = new ServiceRequest<WebAddressListMsg>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<WebAddressListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
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
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new MaintainException("Cannot execute service operation: MaintainAddress.maintainWebAddressList");
    }
}
