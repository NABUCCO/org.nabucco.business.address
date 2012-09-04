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
 * PostBoxAddressComponentRelation<p/>A post box address.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2012-01-12
 */
public class PostBoxAddressComponentRelation extends ComponentRelation<PostBoxAddress> {

    private static final long serialVersionUID = 1L;

    /** Constructs a new PostBoxAddressComponentRelation instance. */
    protected PostBoxAddressComponentRelation() {
        super();
    }

    /**
     * Constructs a new PostBoxAddressComponentRelation instance.
     *
     * @param relationType the ComponentRelationType.
     */
    public PostBoxAddressComponentRelation(ComponentRelationType relationType) {
        super(relationType);
    }

    /**
     * Getter for the Tarthe .
     *
     * @return the PostBoxAddress.
     */
    public PostBoxAddress getTarget() {
        return super.getTarget();
    }

    /**
     * Setter for the Target.
     *
     * @param target the PostBoxAddress.
     */
    public void setTarget(PostBoxAddress target) {
        super.setTarget(target);
    }

    @Override
    public PostBoxAddressComponentRelation cloneObject() {
        PostBoxAddressComponentRelation clone = new PostBoxAddressComponentRelation();
        super.cloneObject(clone);
        return clone;
    }
}
