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

import org.nabucco.business.address.facade.datatype.PostBoxAddress;
import org.nabucco.business.address.facade.message.PostBoxAddressListMsg;
import org.nabucco.business.address.facade.message.search.PostBoxAddressSearchRq;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * 
 * SearchPostBoxAddressServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class SearchPostBoxAddressServiceHandlerImpl extends SearchPostBoxAddressServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected PostBoxAddressListMsg searchPostBoxAddress(PostBoxAddressSearchRq msg) throws SearchException {

        StringBuilder queryString = new StringBuilder();
        queryString.append("select a from PostBoxAddress a");

        List<PostBoxAddress> resultList;
        try {
            NabuccoQuery<PostBoxAddress> query = super.getPersistenceManager().createQuery(queryString.toString());
            resultList = query.getResultList();
        } catch (Exception e) {
            throw new SearchException(e);
        }

        PostBoxAddressListMsg response = new PostBoxAddressListMsg();
        response.getPostBoxAddressList().addAll(resultList);
        return response;
    }

}
