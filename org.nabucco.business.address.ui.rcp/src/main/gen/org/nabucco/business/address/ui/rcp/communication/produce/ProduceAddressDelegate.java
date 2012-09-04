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
package org.nabucco.business.address.ui.rcp.communication.produce;

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
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * ProduceAddressDelegate<p/>Produce Service for Address Datatypes.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2012-01-12
 */
public class ProduceAddressDelegate extends ServiceDelegateSupport {

    private ProduceAddress service;

    /**
     * Constructs a new ProduceAddressDelegate instance.
     *
     * @param service the ProduceAddress.
     */
    public ProduceAddressDelegate(ProduceAddress service) {
        super();
        this.service = service;
    }

    /**
     * ProduceEmailAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmailAddressProduceRq.
     * @return the EmailAddressListMsg.
     * @throws ClientException
     */
    public EmailAddressListMsg produceEmailAddress(EmailAddressProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EmailAddressProduceRq> request = new ServiceRequest<EmailAddressProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<EmailAddressListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceEmailAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceAddress.class, "produceEmailAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceAddress.produceEmailAddress");
    }

    /**
     * ProducePostalAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PostalAddressProduceRq.
     * @return the PostalAddressListMsg.
     * @throws ClientException
     */
    public PostalAddressListMsg producePostalAddress(PostalAddressProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<PostalAddressProduceRq> request = new ServiceRequest<PostalAddressProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PostalAddressListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.producePostalAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceAddress.class, "producePostalAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceAddress.producePostalAddress");
    }

    /**
     * ProducePostBoxAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PostBoxAddressProduceRq.
     * @return the PostBoxAddressListMsg.
     * @throws ClientException
     */
    public PostBoxAddressListMsg producePostBoxAddress(PostBoxAddressProduceRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<PostBoxAddressProduceRq> request = new ServiceRequest<PostBoxAddressProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PostBoxAddressListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.producePostBoxAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceAddress.class, "producePostBoxAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceAddress.producePostBoxAddress");
    }

    /**
     * ProducePhoneAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the PhoneAddressProduceRq.
     * @return the PhoneAddressListMsg.
     * @throws ClientException
     */
    public PhoneAddressListMsg producePhoneAddress(PhoneAddressProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<PhoneAddressProduceRq> request = new ServiceRequest<PhoneAddressProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PhoneAddressListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.producePhoneAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceAddress.class, "producePhoneAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceAddress.producePhoneAddress");
    }

    /**
     * ProduceWebAddress.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the WebAddressProduceRq.
     * @return the WebAddressListMsg.
     * @throws ClientException
     */
    public WebAddressListMsg produceWebAddress(WebAddressProduceRq message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<WebAddressProduceRq> request = new ServiceRequest<WebAddressProduceRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<WebAddressListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceWebAddress(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceAddress.class, "produceWebAddress", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceAddress.produceWebAddress");
    }
}
