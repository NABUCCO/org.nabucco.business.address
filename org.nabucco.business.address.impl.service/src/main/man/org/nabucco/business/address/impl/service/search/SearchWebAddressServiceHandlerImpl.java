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
package org.nabucco.business.address.impl.service.search;

import java.util.List;

import org.nabucco.business.address.facade.datatype.WebAddress;
import org.nabucco.business.address.facade.message.WebAddressListMsg;
import org.nabucco.business.address.facade.message.search.WebAddressSearchRq;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * SearchWebAddressServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class SearchWebAddressServiceHandlerImpl extends SearchWebAddressServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected WebAddressListMsg searchWebAddress(WebAddressSearchRq msg) throws SearchException {

        StringBuilder queryString = new StringBuilder();
        queryString.append("select a from WebAddress a");

        List<WebAddress> resultList;
        try {
            NabuccoQuery<WebAddress> query = super.getPersistenceManager().createQuery(queryString.toString());
            resultList = query.getResultList();
        } catch (Exception e) {
            throw new SearchException(e);
        }

        WebAddressListMsg response = new WebAddressListMsg();
        response.getWebAddressList().addAll(resultList);
        return response;
    }

}
