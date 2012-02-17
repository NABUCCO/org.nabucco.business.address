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
package org.nabucco.business.address.impl.service.maintain;

import org.nabucco.business.address.facade.datatype.PhoneAddress;
import org.nabucco.business.address.facade.message.PhoneAddressMsg;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.MaintainException;

/**
 * MaintainPhoneAddressServiceHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class MaintainPhoneAddressServiceHandlerImpl extends MaintainPhoneAddressServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected PhoneAddressMsg maintainPhoneAddress(PhoneAddressMsg msg) throws MaintainException {

        PhoneAddress address = msg.getPhoneAddress();

        try {
            address = super.getPersistenceManager().persist(address);
        } catch (PersistenceException pe) {
            throw new MaintainException("Error maintaining phone address with id '" + address.getId() + "'.");
        }

        PhoneAddressMsg response = new PhoneAddressMsg();
        response.setPhoneAddress(address);
        return response;
    }

}
