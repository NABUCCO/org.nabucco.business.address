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
package org.nabucco.business.address.impl.service.resolve;

import java.util.List;

import org.nabucco.business.address.facade.datatype.PostalAddress;
import org.nabucco.business.address.facade.message.PostalAddressMsg;
import org.nabucco.business.address.facade.message.resolve.ResolveDefaultPostalAddressRq;
import org.nabucco.framework.base.facade.datatype.FunctionalIdentifier;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodeFacade;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * ResolveDefaultPostalAddressServiceHandlerImpl
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class ResolveDefaultPostalAddressServiceHandlerImpl extends ResolveDefaultPostalAddressServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected PostalAddressMsg resolveDefaultPostalAddress(ResolveDefaultPostalAddressRq msg) throws ResolveException {
        Code code = CodeFacade.getInstance().getCode(PostalAddress.getFunctionalTypeCodePath(),
                new FunctionalIdentifier("001"));

        StringBuilder queryString = new StringBuilder();
        queryString
                .append("SELECT postalAddress FROM PostalAddress postalAddress, PostalAddressComponentRelation relation "
                        + "WHERE (postalAddress.id = relation.target.id AND relation.type='");
        queryString.append(msg.getType().getValue());
        queryString.append("' AND relation.sourceId ='");
        queryString.append(msg.getSourceId().getValue());
        queryString.append("' AND postalAddress.functionalTypeRefId='");
        queryString.append(code.getId());
        queryString.append("')");

        PostalAddress address = null;
        try {
            NabuccoQuery<PostalAddress> query = super.getPersistenceManager().createQuery(queryString.toString());

            List<PostalAddress> resultList = query.getResultList();
            if (resultList != null && resultList.size() > 0) {
                address = resultList.get(0);
            }
        } catch (Exception e) {
            throw new ResolveException(e);
        }
        PostalAddressMsg response = new PostalAddressMsg();
        response.setPostalAddress(address);
        return response;
    }

}
