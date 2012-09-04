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
package org.nabucco.business.address.facade.service.maintain;

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
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * MaintainAddress<p/>Maintain Service for Address Datatypes.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2012-01-12
 */
public interface MaintainAddress extends Service {

    /**
     * Maintains a single email address.
     *
     * @param rq the ServiceRequest<EmailAddressMsg>.
     * @return the ServiceResponse<EmailAddressMsg>.
     * @throws MaintainException
     */
    ServiceResponse<EmailAddressMsg> maintainEmailAddress(ServiceRequest<EmailAddressMsg> rq) throws MaintainException;

    /**
     * Maintains a list of email addresses.
     *
     * @param rq the ServiceRequest<EmailAddressListMsg>.
     * @return the ServiceResponse<EmailAddressListMsg>.
     * @throws MaintainException
     */
    ServiceResponse<EmailAddressListMsg> maintainEmailAddressList(ServiceRequest<EmailAddressListMsg> rq)
            throws MaintainException;

    /**
     * Maintains a single postal address.
     *
     * @param rq the ServiceRequest<PostalAddressMsg>.
     * @return the ServiceResponse<PostalAddressMsg>.
     * @throws MaintainException
     */
    ServiceResponse<PostalAddressMsg> maintainPostalAddress(ServiceRequest<PostalAddressMsg> rq)
            throws MaintainException;

    /**
     * Maintains a list of postal addresses.
     *
     * @param rq the ServiceRequest<PostalAddressListMsg>.
     * @return the ServiceResponse<PostalAddressListMsg>.
     * @throws MaintainException
     */
    ServiceResponse<PostalAddressListMsg> maintainPostalAddressList(ServiceRequest<PostalAddressListMsg> rq)
            throws MaintainException;

    /**
     * Maintains a single post box address.
     *
     * @param rq the ServiceRequest<PostBoxAddressMsg>.
     * @return the ServiceResponse<PostBoxAddressMsg>.
     * @throws MaintainException
     */
    ServiceResponse<PostBoxAddressMsg> maintainPostBoxAddress(ServiceRequest<PostBoxAddressMsg> rq)
            throws MaintainException;

    /**
     * Maintains a list of post box addresses.
     *
     * @param rq the ServiceRequest<PostBoxAddressListMsg>.
     * @return the ServiceResponse<PostBoxAddressListMsg>.
     * @throws MaintainException
     */
    ServiceResponse<PostBoxAddressListMsg> maintainPostBoxAddressList(ServiceRequest<PostBoxAddressListMsg> rq)
            throws MaintainException;

    /**
     * Maintains a single phone address.
     *
     * @param rq the ServiceRequest<PhoneAddressMsg>.
     * @return the ServiceResponse<PhoneAddressMsg>.
     * @throws MaintainException
     */
    ServiceResponse<PhoneAddressMsg> maintainPhoneAddress(ServiceRequest<PhoneAddressMsg> rq) throws MaintainException;

    /**
     * Maintains a list of phone addresses.
     *
     * @param rq the ServiceRequest<PhoneAddressListMsg>.
     * @return the ServiceResponse<PhoneAddressListMsg>.
     * @throws MaintainException
     */
    ServiceResponse<PhoneAddressListMsg> maintainPhoneAddressList(ServiceRequest<PhoneAddressListMsg> rq)
            throws MaintainException;

    /**
     * Maintains a single web address.
     *
     * @param rq the ServiceRequest<WebAddressMsg>.
     * @return the ServiceResponse<WebAddressMsg>.
     * @throws MaintainException
     */
    ServiceResponse<WebAddressMsg> maintainWebAddress(ServiceRequest<WebAddressMsg> rq) throws MaintainException;

    /**
     * Maintains a list of web addresses.
     *
     * @param rq the ServiceRequest<WebAddressListMsg>.
     * @return the ServiceResponse<WebAddressListMsg>.
     * @throws MaintainException
     */
    ServiceResponse<WebAddressListMsg> maintainWebAddressList(ServiceRequest<WebAddressListMsg> rq)
            throws MaintainException;
}
