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
package org.nabucco.business.address.facade.service.resolve;

import org.nabucco.business.address.facade.message.EmailAddressMsg;
import org.nabucco.business.address.facade.message.PhoneAddressMsg;
import org.nabucco.business.address.facade.message.PostBoxAddressMsg;
import org.nabucco.business.address.facade.message.PostalAddressMsg;
import org.nabucco.business.address.facade.message.WebAddressMsg;
import org.nabucco.business.address.facade.message.resolve.ResolveDatatypeListRq;
import org.nabucco.business.address.facade.message.resolve.ResolveDatatypeListRs;
import org.nabucco.business.address.facade.message.resolve.ResolveDefaultPostalAddressRq;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * ResolveAddress<p/>Resolve Service for Address Datatypes.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2012-01-12
 */
public interface ResolveAddress extends Service {

    /**
     * Resolves a single email address.
     *
     * @param rq the ServiceRequest<EmailAddressMsg>.
     * @return the ServiceResponse<EmailAddressMsg>.
     * @throws ResolveException
     */
    ServiceResponse<EmailAddressMsg> resolveEmailAddress(ServiceRequest<EmailAddressMsg> rq) throws ResolveException;

    /**
     * Resolves a single postal address.
     *
     * @param rq the ServiceRequest<PostalAddressMsg>.
     * @return the ServiceResponse<PostalAddressMsg>.
     * @throws ResolveException
     */
    ServiceResponse<PostalAddressMsg> resolvePostalAddress(ServiceRequest<PostalAddressMsg> rq) throws ResolveException;

    /**
     * Resolves a single post box address.
     *
     * @param rq the ServiceRequest<PostBoxAddressMsg>.
     * @return the ServiceResponse<PostBoxAddressMsg>.
     * @throws ResolveException
     */
    ServiceResponse<PostBoxAddressMsg> resolvePostBoxAddress(ServiceRequest<PostBoxAddressMsg> rq)
            throws ResolveException;

    /**
     * Resolves a single phone address.
     *
     * @param rq the ServiceRequest<PhoneAddressMsg>.
     * @return the ServiceResponse<PhoneAddressMsg>.
     * @throws ResolveException
     */
    ServiceResponse<PhoneAddressMsg> resolvePhoneAddress(ServiceRequest<PhoneAddressMsg> rq) throws ResolveException;

    /**
     * Resolves a single web address.
     *
     * @param rq the ServiceRequest<WebAddressMsg>.
     * @return the ServiceResponse<WebAddressMsg>.
     * @throws ResolveException
     */
    ServiceResponse<WebAddressMsg> resolveWebAddress(ServiceRequest<WebAddressMsg> rq) throws ResolveException;

    /**
     * Resolves a list of address datatypes.
     *
     * @param rq the ServiceRequest<ResolveDatatypeListRq>.
     * @return the ServiceResponse<ResolveDatatypeListRs>.
     * @throws ResolveException
     */
    ServiceResponse<ResolveDatatypeListRs> resolveDatatypeList(ServiceRequest<ResolveDatatypeListRq> rq)
            throws ResolveException;

    /**
     * Resolves the default postal address.
     *
     * @param rq the ServiceRequest<ResolveDefaultPostalAddressRq>.
     * @return the ServiceResponse<PostalAddressMsg>.
     * @throws ResolveException
     */
    ServiceResponse<PostalAddressMsg> resolveDefaultPostalAddress(ServiceRequest<ResolveDefaultPostalAddressRq> rq)
            throws ResolveException;
}
