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
package org.nabucco.business.address.ui.rcp.communication.resolve;

import org.nabucco.business.address.facade.message.EmailAddressMsg;
import org.nabucco.business.address.facade.message.PhoneAddressMsg;
import org.nabucco.business.address.facade.message.PostBoxAddressMsg;
import org.nabucco.business.address.facade.message.PostalAddressMsg;
import org.nabucco.business.address.facade.message.WebAddressMsg;
import org.nabucco.business.address.facade.message.resolve.ResolveDatatypeListRq;
import org.nabucco.business.address.facade.message.resolve.ResolveDatatypeListRs;
import org.nabucco.business.address.facade.message.resolve.ResolveDefaultPostalAddressRq;
import org.nabucco.business.address.facade.service.resolve.ResolveAddress;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * ResolveAddressDelegate<p/>Resolve Service for Address Datatypes.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2012-01-12
 */
public class ResolveAddressDelegate extends ServiceDelegateSupport {

    private ResolveAddress service;

    /**
     * Constructs a new ResolveAddressDelegate instance.
     *
     * @param service the ResolveAddress.
     */
    public ResolveAddressDelegate(ResolveAddress service) {
        super();
        this.service = service;
    }

    /**
     * ResolveEmailAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmailAddressMsg.
     * @return the EmailAddressMsg.
     * @throws ClientException
     */
    public EmailAddressMsg resolveEmailAddress(EmailAddressMsg message, ServiceSubContext... subContexts)
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
                response = service.resolveEmailAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveAddress.class, "resolveEmailAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveAddress.resolveEmailAddress");
    }

    /**
     * ResolvePostalAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PostalAddressMsg.
     * @return the PostalAddressMsg.
     * @throws ClientException
     */
    public PostalAddressMsg resolvePostalAddress(PostalAddressMsg message, ServiceSubContext... subContexts)
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
                response = service.resolvePostalAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveAddress.class, "resolvePostalAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveAddress.resolvePostalAddress");
    }

    /**
     * ResolvePostBoxAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PostBoxAddressMsg.
     * @return the PostBoxAddressMsg.
     * @throws ClientException
     */
    public PostBoxAddressMsg resolvePostBoxAddress(PostBoxAddressMsg message, ServiceSubContext... subContexts)
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
                response = service.resolvePostBoxAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveAddress.class, "resolvePostBoxAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveAddress.resolvePostBoxAddress");
    }

    /**
     * ResolvePhoneAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PhoneAddressMsg.
     * @return the PhoneAddressMsg.
     * @throws ClientException
     */
    public PhoneAddressMsg resolvePhoneAddress(PhoneAddressMsg message, ServiceSubContext... subContexts)
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
                response = service.resolvePhoneAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveAddress.class, "resolvePhoneAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveAddress.resolvePhoneAddress");
    }

    /**
     * ResolveWebAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the WebAddressMsg.
     * @return the WebAddressMsg.
     * @throws ClientException
     */
    public WebAddressMsg resolveWebAddress(WebAddressMsg message, ServiceSubContext... subContexts)
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
                response = service.resolveWebAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveAddress.class, "resolveWebAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveAddress.resolveWebAddress");
    }

    /**
     * ResolveDatatypeList.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ResolveDatatypeListRq.
     * @return the ResolveDatatypeListRs.
     * @throws ClientException
     */
    public ResolveDatatypeListRs resolveDatatypeList(ResolveDatatypeListRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ResolveDatatypeListRq> request = new ServiceRequest<ResolveDatatypeListRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ResolveDatatypeListRs> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveDatatypeList(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveAddress.class, "resolveDatatypeList", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveAddress.resolveDatatypeList");
    }

    /**
     * ResolveDefaultPostalAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ResolveDefaultPostalAddressRq.
     * @return the PostalAddressMsg.
     * @throws ClientException
     */
    public PostalAddressMsg resolveDefaultPostalAddress(ResolveDefaultPostalAddressRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<ResolveDefaultPostalAddressRq> request = new ServiceRequest<ResolveDefaultPostalAddressRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PostalAddressMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveDefaultPostalAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveAddress.class, "resolveDefaultPostalAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ResolveAddress.resolveDefaultPostalAddress");
    }
}
