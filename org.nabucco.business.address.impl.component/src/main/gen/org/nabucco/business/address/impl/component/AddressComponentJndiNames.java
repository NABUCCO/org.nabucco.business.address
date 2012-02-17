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
package org.nabucco.business.address.impl.component;

/**
 * AddressComponentJndiNames<p/>Component for Address and Contact Management.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-12-07
 */
public interface AddressComponentJndiNames {

    final String COMPONENT_RELATION_SERVICE_LOCAL = "nabucco/org.nabucco.business.address/org.nabucco.business.address.facade.component.ComponentRelationService/local";

    final String COMPONENT_RELATION_SERVICE_REMOTE = "nabucco/org.nabucco.business.address/org.nabucco.business.address.facade.component.ComponentRelationService/remote";

    final String QUERY_FILTER_SERVICE_LOCAL = "nabucco/org.nabucco.business.address/org.nabucco.business.address.facade.component.QueryFilterService/local";

    final String QUERY_FILTER_SERVICE_REMOTE = "nabucco/org.nabucco.business.address/org.nabucco.business.address.facade.component.QueryFilterService/remote";

    final String MAINTAIN_ADDRESS_LOCAL = "nabucco/org.nabucco.business.address/org.nabucco.business.address.facade.service.maintain.MaintainAddress/local";

    final String MAINTAIN_ADDRESS_REMOTE = "nabucco/org.nabucco.business.address/org.nabucco.business.address.facade.service.maintain.MaintainAddress/remote";

    final String PRODUCE_ADDRESS_LOCAL = "nabucco/org.nabucco.business.address/org.nabucco.business.address.facade.service.produce.ProduceAddress/local";

    final String PRODUCE_ADDRESS_REMOTE = "nabucco/org.nabucco.business.address/org.nabucco.business.address.facade.service.produce.ProduceAddress/remote";

    final String RESOLVE_ADDRESS_LOCAL = "nabucco/org.nabucco.business.address/org.nabucco.business.address.facade.service.resolve.ResolveAddress/local";

    final String RESOLVE_ADDRESS_REMOTE = "nabucco/org.nabucco.business.address/org.nabucco.business.address.facade.service.resolve.ResolveAddress/remote";

    final String SEARCH_ADDRESS_LOCAL = "nabucco/org.nabucco.business.address/org.nabucco.business.address.facade.service.search.SearchAddress/local";

    final String SEARCH_ADDRESS_REMOTE = "nabucco/org.nabucco.business.address/org.nabucco.business.address.facade.service.search.SearchAddress/remote";
}
