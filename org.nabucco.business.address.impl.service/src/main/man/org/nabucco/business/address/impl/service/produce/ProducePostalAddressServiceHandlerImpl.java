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
package org.nabucco.business.address.impl.service.produce;

import org.nabucco.business.address.facade.datatype.PostalAddress;
import org.nabucco.business.address.facade.message.PostalAddressListMsg;
import org.nabucco.business.address.facade.message.produce.PostalAddressProduceRq;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.StatusType;
import org.nabucco.framework.base.facade.datatype.Tenant;
import org.nabucco.framework.base.facade.exception.service.ProduceException;

/**
 * ProducePostalAddressServiceHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class ProducePostalAddressServiceHandlerImpl extends ProducePostalAddressServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected PostalAddressListMsg producePostalAddress(PostalAddressProduceRq msg) throws ProduceException {

        PostalAddressListMsg response = new PostalAddressListMsg();

        for (int i = 0; i < msg.getAmount().getValue(); i++) {
            PostalAddress address = new PostalAddress();
            address.setTenant(new Tenant());
            address.setDatatypeState(DatatypeState.INITIALIZED);
            address.setStatusType(StatusType.ACTIVE);
            address.setOwner(super.getContext().getOwner());

            response.getPostalAddressList().add(address);
        }

        return response;
    }

}
