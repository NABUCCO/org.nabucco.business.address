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
package org.nabucco.business.address.facade.datatype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.business.address.Address;
import org.nabucco.framework.base.facade.datatype.business.address.AddressType;
import org.nabucco.framework.base.facade.datatype.business.address.PhoneNumber;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * PhoneAddress<p/>A phone, fax or mobile number.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2012-01-12
 */
public class PhoneAddress extends Address implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final AddressType TYPE_DEFAULT = AddressType.PHONE;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,255;u0,n;m1,1;", "m0,1;" };

    public static final String PHONENUMBER = "phoneNumber";

    public static final String PHONETYPE = "phoneType";

    /** The phone number. */
    private PhoneNumber phoneNumber;

    /** Type of the phone number. */
    private Code phoneType;

    private Long phoneTypeRefId;

    protected static final String PHONETYPE_CODEPATH = "nabucco.business.address.phonetype";

    private Long functionalTypeRefId;

    /** Constructs a new PhoneAddress instance. */
    public PhoneAddress() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        type = TYPE_DEFAULT;
    }

    /**
     * CloneObject.
     *
     * @param clone the PhoneAddress.
     */
    protected void cloneObject(PhoneAddress clone) {
        super.cloneObject(clone);
        clone.setType(this.getType());
        if ((this.getPhoneNumber() != null)) {
            clone.setPhoneNumber(this.getPhoneNumber().cloneObject());
        }
        if ((this.getPhoneType() != null)) {
            clone.setPhoneType(this.getPhoneType().cloneObject());
        }
        if ((this.getPhoneTypeRefId() != null)) {
            clone.setPhoneTypeRefId(this.getPhoneTypeRefId());
        }
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(Address.class).getPropertyMap());
        propertyMap.put(PHONENUMBER, PropertyDescriptorSupport.createBasetype(PHONENUMBER, PhoneNumber.class, 10,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(PHONETYPE, PropertyDescriptorSupport.createDatatype(PHONETYPE, Code.class, 11,
                PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPONENT, PHONETYPE_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(PhoneAddress.getPropertyDescriptor(PHONENUMBER), this.phoneNumber, null));
        properties.add(super.createProperty(PhoneAddress.getPropertyDescriptor(PHONETYPE), this.getPhoneType(),
                this.phoneTypeRefId));
        properties.add(super.createProperty(PhoneAddress.getPropertyDescriptor(FUNCTIONALTYPE),
                this.getFunctionalType(), this.functionalTypeRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(PHONENUMBER) && (property.getType() == PhoneNumber.class))) {
            this.setPhoneNumber(((PhoneNumber) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PHONETYPE) && (property.getType() == Code.class))) {
            this.setPhoneType(((Code) property.getInstance()));
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
        final PhoneAddress other = ((PhoneAddress) obj);
        if ((this.phoneNumber == null)) {
            if ((other.phoneNumber != null))
                return false;
        } else if ((!this.phoneNumber.equals(other.phoneNumber)))
            return false;
        if ((this.phoneType == null)) {
            if ((other.phoneType != null))
                return false;
        } else if ((!this.phoneType.equals(other.phoneType)))
            return false;
        if ((this.phoneTypeRefId == null)) {
            if ((other.phoneTypeRefId != null))
                return false;
        } else if ((!this.phoneTypeRefId.equals(other.phoneTypeRefId)))
            return false;
        if ((this.functionalTypeRefId == null)) {
            if ((other.functionalTypeRefId != null))
                return false;
        } else if ((!this.functionalTypeRefId.equals(other.functionalTypeRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.phoneNumber == null) ? 0 : this.phoneNumber.hashCode()));
        result = ((PRIME * result) + ((this.phoneType == null) ? 0 : this.phoneType.hashCode()));
        result = ((PRIME * result) + ((this.phoneTypeRefId == null) ? 0 : this.phoneTypeRefId.hashCode()));
        result = ((PRIME * result) + ((this.functionalTypeRefId == null) ? 0 : this.functionalTypeRefId.hashCode()));
        return result;
    }

    @Override
    public PhoneAddress cloneObject() {
        PhoneAddress clone = new PhoneAddress();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * The phone number.
     *
     * @return the PhoneNumber.
     */
    public PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * The phone number.
     *
     * @param phoneNumber the PhoneNumber.
     */
    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * The phone number.
     *
     * @param phoneNumber the String.
     */
    public void setPhoneNumber(String phoneNumber) {
        if ((this.phoneNumber == null)) {
            if ((phoneNumber == null)) {
                return;
            }
            this.phoneNumber = new PhoneNumber();
        }
        this.phoneNumber.setValue(phoneNumber);
    }

    /**
     * Type of the phone number.
     *
     * @param phoneType the Code.
     */
    public void setPhoneType(Code phoneType) {
        this.phoneType = phoneType;
        if ((phoneType != null)) {
            this.setPhoneTypeRefId(phoneType.getId());
        } else {
            this.setPhoneTypeRefId(null);
        }
    }

    /**
     * Type of the phone number.
     *
     * @return the Code.
     */
    public Code getPhoneType() {
        return this.phoneType;
    }

    /**
     * Getter for the PhoneTypeRefId.
     *
     * @return the Long.
     */
    public Long getPhoneTypeRefId() {
        return this.phoneTypeRefId;
    }

    /**
     * Setter for the PhoneTypeRefId.
     *
     * @param phoneTypeRefId the Long.
     */
    public void setPhoneTypeRefId(Long phoneTypeRefId) {
        this.phoneTypeRefId = phoneTypeRefId;
    }

    /**
     * Getter for the FunctionalTypeRefId.
     *
     * @return the Long.
     */
    public Long getFunctionalTypeRefId() {
        return this.functionalTypeRefId;
    }

    /**
     * Setter for the FunctionalTypeRefId.
     *
     * @param functionalTypeRefId the Long.
     */
    public void setFunctionalTypeRefId(Long functionalTypeRefId) {
        this.functionalTypeRefId = functionalTypeRefId;
    }

    /**
     * Setter for the FunctionalType.
     *
     * @param functionalType the Code.
     */
    public void setFunctionalType(Code functionalType) {
        super.setFunctionalType(functionalType);
        if ((functionalType != null)) {
            this.setFunctionalTypeRefId(functionalType.getId());
        } else {
            this.setFunctionalTypeRefId(null);
        }
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(PhoneAddress.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(PhoneAddress.class).getAllProperties();
    }

    /**
     * Getter for the PhoneTypeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getPhoneTypeCodePath() {
        return new CodePath(PHONETYPE_CODEPATH);
    }
}
