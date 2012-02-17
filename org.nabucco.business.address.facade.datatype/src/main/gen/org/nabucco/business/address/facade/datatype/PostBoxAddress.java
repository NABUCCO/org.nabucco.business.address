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
import org.nabucco.framework.base.facade.datatype.business.address.City;
import org.nabucco.framework.base.facade.datatype.business.address.PostBox;
import org.nabucco.framework.base.facade.datatype.business.address.ZipCode;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * PostBoxAddress<p/>A post box address.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2012-01-12
 */
public class PostBoxAddress extends Address implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final AddressType TYPE_DEFAULT = AddressType.POST_BOX;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,255;u0,n;m1,1;", "l0,128;u0,n;m1,1;",
            "l0,10;u0,n;m1,1;", "m0,1;" };

    public static final String POSTBOX = "postBox";

    public static final String CITY = "city";

    public static final String ZIPCODE = "zipCode";

    public static final String COUNTRY = "country";

    /** The post box number. */
    private PostBox postBox;

    /** The city of the post box. */
    private City city;

    /** The ZIP code of the post box. */
    private ZipCode zipCode;

    /** The country of the post box. */
    private Code country;

    private Long countryRefId;

    protected static final String COUNTRY_CODEPATH = "nabucco.framework.country";

    private Long functionalTypeRefId;

    /** Constructs a new PostBoxAddress instance. */
    public PostBoxAddress() {
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
     * @param clone the PostBoxAddress.
     */
    protected void cloneObject(PostBoxAddress clone) {
        super.cloneObject(clone);
        clone.setType(this.getType());
        if ((this.getPostBox() != null)) {
            clone.setPostBox(this.getPostBox().cloneObject());
        }
        if ((this.getCity() != null)) {
            clone.setCity(this.getCity().cloneObject());
        }
        if ((this.getZipCode() != null)) {
            clone.setZipCode(this.getZipCode().cloneObject());
        }
        if ((this.getCountry() != null)) {
            clone.setCountry(this.getCountry().cloneObject());
        }
        if ((this.getCountryRefId() != null)) {
            clone.setCountryRefId(this.getCountryRefId());
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
        propertyMap.put(POSTBOX,
                PropertyDescriptorSupport.createBasetype(POSTBOX, PostBox.class, 10, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(CITY,
                PropertyDescriptorSupport.createBasetype(CITY, City.class, 11, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(ZIPCODE,
                PropertyDescriptorSupport.createBasetype(ZIPCODE, ZipCode.class, 12, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(COUNTRY, PropertyDescriptorSupport.createDatatype(COUNTRY, Code.class, 13,
                PROPERTY_CONSTRAINTS[3], false, PropertyAssociationType.COMPONENT, COUNTRY_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(PostBoxAddress.getPropertyDescriptor(POSTBOX), this.postBox, null));
        properties.add(super.createProperty(PostBoxAddress.getPropertyDescriptor(CITY), this.city, null));
        properties.add(super.createProperty(PostBoxAddress.getPropertyDescriptor(ZIPCODE), this.zipCode, null));
        properties.add(super.createProperty(PostBoxAddress.getPropertyDescriptor(COUNTRY), this.getCountry(),
                this.countryRefId));
        properties.add(super.createProperty(PostBoxAddress.getPropertyDescriptor(FUNCTIONALTYPE),
                this.getFunctionalType(), this.functionalTypeRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(POSTBOX) && (property.getType() == PostBox.class))) {
            this.setPostBox(((PostBox) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CITY) && (property.getType() == City.class))) {
            this.setCity(((City) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ZIPCODE) && (property.getType() == ZipCode.class))) {
            this.setZipCode(((ZipCode) property.getInstance()));
            return true;
        } else if ((property.getName().equals(COUNTRY) && (property.getType() == Code.class))) {
            this.setCountry(((Code) property.getInstance()));
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
        final PostBoxAddress other = ((PostBoxAddress) obj);
        if ((this.postBox == null)) {
            if ((other.postBox != null))
                return false;
        } else if ((!this.postBox.equals(other.postBox)))
            return false;
        if ((this.city == null)) {
            if ((other.city != null))
                return false;
        } else if ((!this.city.equals(other.city)))
            return false;
        if ((this.zipCode == null)) {
            if ((other.zipCode != null))
                return false;
        } else if ((!this.zipCode.equals(other.zipCode)))
            return false;
        if ((this.country == null)) {
            if ((other.country != null))
                return false;
        } else if ((!this.country.equals(other.country)))
            return false;
        if ((this.countryRefId == null)) {
            if ((other.countryRefId != null))
                return false;
        } else if ((!this.countryRefId.equals(other.countryRefId)))
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
        result = ((PRIME * result) + ((this.postBox == null) ? 0 : this.postBox.hashCode()));
        result = ((PRIME * result) + ((this.city == null) ? 0 : this.city.hashCode()));
        result = ((PRIME * result) + ((this.zipCode == null) ? 0 : this.zipCode.hashCode()));
        result = ((PRIME * result) + ((this.country == null) ? 0 : this.country.hashCode()));
        result = ((PRIME * result) + ((this.countryRefId == null) ? 0 : this.countryRefId.hashCode()));
        result = ((PRIME * result) + ((this.functionalTypeRefId == null) ? 0 : this.functionalTypeRefId.hashCode()));
        return result;
    }

    @Override
    public PostBoxAddress cloneObject() {
        PostBoxAddress clone = new PostBoxAddress();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * The post box number.
     *
     * @return the PostBox.
     */
    public PostBox getPostBox() {
        return this.postBox;
    }

    /**
     * The post box number.
     *
     * @param postBox the PostBox.
     */
    public void setPostBox(PostBox postBox) {
        this.postBox = postBox;
    }

    /**
     * The post box number.
     *
     * @param postBox the String.
     */
    public void setPostBox(String postBox) {
        if ((this.postBox == null)) {
            if ((postBox == null)) {
                return;
            }
            this.postBox = new PostBox();
        }
        this.postBox.setValue(postBox);
    }

    /**
     * The city of the post box.
     *
     * @return the City.
     */
    public City getCity() {
        return this.city;
    }

    /**
     * The city of the post box.
     *
     * @param city the City.
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * The city of the post box.
     *
     * @param city the String.
     */
    public void setCity(String city) {
        if ((this.city == null)) {
            if ((city == null)) {
                return;
            }
            this.city = new City();
        }
        this.city.setValue(city);
    }

    /**
     * The ZIP code of the post box.
     *
     * @return the ZipCode.
     */
    public ZipCode getZipCode() {
        return this.zipCode;
    }

    /**
     * The ZIP code of the post box.
     *
     * @param zipCode the ZipCode.
     */
    public void setZipCode(ZipCode zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * The ZIP code of the post box.
     *
     * @param zipCode the String.
     */
    public void setZipCode(String zipCode) {
        if ((this.zipCode == null)) {
            if ((zipCode == null)) {
                return;
            }
            this.zipCode = new ZipCode();
        }
        this.zipCode.setValue(zipCode);
    }

    /**
     * The country of the post box.
     *
     * @param country the Code.
     */
    public void setCountry(Code country) {
        this.country = country;
        if ((country != null)) {
            this.setCountryRefId(country.getId());
        } else {
            this.setCountryRefId(null);
        }
    }

    /**
     * The country of the post box.
     *
     * @return the Code.
     */
    public Code getCountry() {
        return this.country;
    }

    /**
     * Getter for the CountryRefId.
     *
     * @return the Long.
     */
    public Long getCountryRefId() {
        return this.countryRefId;
    }

    /**
     * Setter for the CountryRefId.
     *
     * @param countryRefId the Long.
     */
    public void setCountryRefId(Long countryRefId) {
        this.countryRefId = countryRefId;
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
        return PropertyCache.getInstance().retrieve(PostBoxAddress.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(PostBoxAddress.class).getAllProperties();
    }

    /**
     * Getter for the CountryCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getCountryCodePath() {
        return new CodePath(COUNTRY_CODEPATH);
    }
}
