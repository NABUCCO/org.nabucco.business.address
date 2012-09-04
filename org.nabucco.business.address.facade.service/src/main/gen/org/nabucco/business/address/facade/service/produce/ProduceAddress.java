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
package org.nabucco.business.address.facade.service.produce;

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
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * ProduceAddress<p/>Produce Service for Address Datatypes.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2012-01-12
 */
public interface ProduceAddress extends Service {

    /**
     * Creates new email address instances.
     *
     * @param rq the ServiceRequest<EmailAddressProduceRq>.
     * @return the ServiceResponse<EmailAddressListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<EmailAddressListMsg> produceEmailAddress(ServiceRequest<EmailAddressProduceRq> rq)
            throws ProduceException;

    /**
     * Creates new postal address instances.
     *
     * @param rq the ServiceRequest<PostalAddressProduceRq>.
     * @return the ServiceResponse<PostalAddressListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<PostalAddressListMsg> producePostalAddress(ServiceRequest<PostalAddressProduceRq> rq)
            throws ProduceException;

    /**
     * Creates new post box address instances.
     *
     * @param rq the ServiceRequest<PostBoxAddressProduceRq>.
     * @return the ServiceResponse<PostBoxAddressListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<PostBoxAddressListMsg> producePostBoxAddress(ServiceRequest<PostBoxAddressProduceRq> rq)
            throws ProduceException;

    /**
     * Creates new phone address instances.
     *
     * @param rq the ServiceRequest<PhoneAddressProduceRq>.
     * @return the ServiceResponse<PhoneAddressListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<PhoneAddressListMsg> producePhoneAddress(ServiceRequest<PhoneAddressProduceRq> rq)
            throws ProduceException;

    /**
     * Creates new web address instances.
     *
     * @param rq the ServiceRequest<WebAddressProduceRq>.
     * @return the ServiceResponse<WebAddressListMsg>.
     * @throws ProduceException
     */
    ServiceResponse<WebAddressListMsg> produceWebAddress(ServiceRequest<WebAddressProduceRq> rq)
            throws ProduceException;
}
