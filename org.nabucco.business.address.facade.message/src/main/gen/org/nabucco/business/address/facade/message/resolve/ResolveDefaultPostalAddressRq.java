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
package org.nabucco.business.address.facade.message.resolve;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * ResolveDefaultPostalAddressRq<p/>Message for resolving the default PostalAddress datatype<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2011-05-12
 */
public class ResolveDefaultPostalAddressRq extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m1,1;", "l0,255;u0,n;m0,1;" };

    public static final String SOURCEID = "sourceId";

    public static final String TYPE = "type";

    private Identifier sourceId;

    private Name type;

    /** Constructs a new ResolveDefaultPostalAddressRq instance. */
    public ResolveDefaultPostalAddressRq() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap
                .put(SOURCEID, PropertyDescriptorSupport.createBasetype(SOURCEID, Identifier.class, 0,
                        PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(TYPE,
                PropertyDescriptorSupport.createBasetype(TYPE, Name.class, 1, PROPERTY_CONSTRAINTS[1], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ResolveDefaultPostalAddressRq.getPropertyDescriptor(SOURCEID),
                this.sourceId));
        properties.add(super.createProperty(ResolveDefaultPostalAddressRq.getPropertyDescriptor(TYPE), this.type));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(SOURCEID) && (property.getType() == Identifier.class))) {
            this.setSourceId(((Identifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TYPE) && (property.getType() == Name.class))) {
            this.setType(((Name) property.getInstance()));
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if ((this == obj)) {
            return true;
        }
        if ((obj == null)) {
            return false;
        }
        if ((this.getClass() != obj.getClass())) {
            return false;
        }
        if ((!super.equals(obj))) {
            return false;
        }
        final ResolveDefaultPostalAddressRq other = ((ResolveDefaultPostalAddressRq) obj);
        if ((this.sourceId == null)) {
            if ((other.sourceId != null))
                return false;
        } else if ((!this.sourceId.equals(other.sourceId)))
            return false;
        if ((this.type == null)) {
            if ((other.type != null))
                return false;
        } else if ((!this.type.equals(other.type)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.sourceId == null) ? 0 : this.sourceId.hashCode()));
        result = ((PRIME * result) + ((this.type == null) ? 0 : this.type.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getSourceId.
     *
     * @return the Identifier.
     */
    public Identifier getSourceId() {
        return this.sourceId;
    }

    /**
     * Missing description at method setSourceId.
     *
     * @param sourceId the Identifier.
     */
    public void setSourceId(Identifier sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * Missing description at method getType.
     *
     * @return the Name.
     */
    public Name getType() {
        return this.type;
    }

    /**
     * Missing description at method setType.
     *
     * @param type the Name.
     */
    public void setType(Name type) {
        this.type = type;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ResolveDefaultPostalAddressRq.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ResolveDefaultPostalAddressRq.class).getAllProperties();
    }
}
