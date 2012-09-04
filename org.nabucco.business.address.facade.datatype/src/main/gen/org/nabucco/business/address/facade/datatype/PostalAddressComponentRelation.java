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
package org.nabucco.business.address.facade.datatype;

import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelation;
import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelationType;

/**
 * PostalAddressComponentRelation<p/>A postal address.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2012-01-12
 */
public class PostalAddressComponentRelation extends ComponentRelation<PostalAddress> {

    private static final long serialVersionUID = 1L;

    /** Constructs a new PostalAddressComponentRelation instance. */
    protected PostalAddressComponentRelation() {
        super();
    }

    /**
     * Constructs a new PostalAddressComponentRelation instance.
     *
     * @param relationType the ComponentRelationType.
     */
    public PostalAddressComponentRelation(ComponentRelationType relationType) {
        super(relationType);
    }

    /**
     * Getter for the Tarthe .
     *
     * @return the PostalAddress.
     */
    public PostalAddress getTarget() {
        return super.getTarget();
    }

    /**
     * Setter for the Target.
     *
     * @param target the PostalAddress.
     */
    public void setTarget(PostalAddress target) {
        super.setTarget(target);
    }

    @Override
    public PostalAddressComponentRelation cloneObject() {
        PostalAddressComponentRelation clone = new PostalAddressComponentRelation();
        super.cloneObject(clone);
        return clone;
    }
}
