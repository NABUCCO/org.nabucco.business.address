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
package org.nabucco.business.address.facade.service.search;

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
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * SearchAddress<p/>Search Service for Address Datatypes.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2012-01-12
 */
public interface SearchAddress extends Service {

    /**
     * Searches for a list of email addresses.
     *
     * @param rq the ServiceRequest<EmailAddressSearchRq>.
     * @return the ServiceResponse<EmailAddressListMsg>.
     * @throws SearchException
     */
    ServiceResponse<EmailAddressListMsg> searchEmailAddress(ServiceRequest<EmailAddressSearchRq> rq)
            throws SearchException;

    /**
     * Searches for a list of postal addresses.
     *
     * @param rq the ServiceRequest<PostalAddressSearchRq>.
     * @return the ServiceResponse<PostalAddressListMsg>.
     * @throws SearchException
     */
    ServiceResponse<PostalAddressListMsg> searchPostalAddress(ServiceRequest<PostalAddressSearchRq> rq)
            throws SearchException;

    /**
     * Searches for a list of post box addresses.
     *
     * @param rq the ServiceRequest<PostBoxAddressSearchRq>.
     * @return the ServiceResponse<PostBoxAddressListMsg>.
     * @throws SearchException
     */
    ServiceResponse<PostBoxAddressListMsg> searchPostBoxAddress(ServiceRequest<PostBoxAddressSearchRq> rq)
            throws SearchException;

    /**
     * Searches for a list of phone addresses.
     *
     * @param rq the ServiceRequest<PhoneAddressSearchRq>.
     * @return the ServiceResponse<PhoneAddressListMsg>.
     * @throws SearchException
     */
    ServiceResponse<PhoneAddressListMsg> searchPhoneAddress(ServiceRequest<PhoneAddressSearchRq> rq)
            throws SearchException;

    /**
     * Searches for a list of web addresses.
     *
     * @param rq the ServiceRequest<WebAddressSearchRq>.
     * @return the ServiceResponse<WebAddressListMsg>.
     * @throws SearchException
     */
    ServiceResponse<WebAddressListMsg> searchWebAddress(ServiceRequest<WebAddressSearchRq> rq) throws SearchException;

    /**
     * Searches for a list of addresses.
     *
     * @param rq the ServiceRequest<AddressSearchRq>.
     * @return the ServiceResponse<AddressListMsg>.
     * @throws SearchException
     */
    ServiceResponse<AddressListMsg> searchAddresses(ServiceRequest<AddressSearchRq> rq) throws SearchException;
}
