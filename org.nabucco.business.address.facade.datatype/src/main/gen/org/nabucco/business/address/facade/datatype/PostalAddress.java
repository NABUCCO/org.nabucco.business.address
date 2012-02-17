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
import org.nabucco.framework.base.facade.datatype.business.address.State;
import org.nabucco.framework.base.facade.datatype.business.address.Street;
import org.nabucco.framework.base.facade.datatype.business.address.StreetNumber;
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
 * PostalAddress<p/>A postal address.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2012-01-12
 */
public class PostalAddress extends Address implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final AddressType TYPE_DEFAULT = AddressType.POSTAL;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,255;u0,n;m0,1;", "l0,5;u0,n;m0,1;", "l0,128;u0,n;m1,1;",
            "l0,10;u0,n;m1,1;", "l0,128;u0,n;m0,1;", "m0,1;" };

    public static final String STREET = "street";

    public static final String STREETNUMBER = "streetNumber";

    public static final String CITY = "city";

    public static final String ZIPCODE = "zipCode";

    public static final String STATE = "state";

    public static final String COUNTRY = "country";

    /** Street of the postal address. */
    private Street street;

    /** Street Number of the postal address. */
    private StreetNumber streetNumber;

    /** City of the postal address. */
    private City city;

    /** ZIP Code of the postal address. */
    private ZipCode zipCode;

    /** State of the postal address. */
    private State state;

    /** Country of the postal address. */
    private Code country;

    private Long countryRefId;

    protected static final String COUNTRY_CODEPATH = "nabucco.framework.country";

    private Long functionalTypeRefId;

    /** Constructs a new PostalAddress instance. */
    public PostalAddress() {
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
     * @param clone the PostalAddress.
     */
    protected void cloneObject(PostalAddress clone) {
        super.cloneObject(clone);
        clone.setType(this.getType());
        if ((this.getStreet() != null)) {
            clone.setStreet(this.getStreet().cloneObject());
        }
        if ((this.getStreetNumber() != null)) {
            clone.setStreetNumber(this.getStreetNumber().cloneObject());
        }
        if ((this.getCity() != null)) {
            clone.setCity(this.getCity().cloneObject());
        }
        if ((this.getZipCode() != null)) {
            clone.setZipCode(this.getZipCode().cloneObject());
        }
        if ((this.getState() != null)) {
            clone.setState(this.getState().cloneObject());
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
        propertyMap.put(STREET,
                PropertyDescriptorSupport.createBasetype(STREET, Street.class, 10, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(STREETNUMBER, PropertyDescriptorSupport.createBasetype(STREETNUMBER, StreetNumber.class, 11,
                PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(CITY,
                PropertyDescriptorSupport.createBasetype(CITY, City.class, 12, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(ZIPCODE,
                PropertyDescriptorSupport.createBasetype(ZIPCODE, ZipCode.class, 13, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(STATE,
                PropertyDescriptorSupport.createBasetype(STATE, State.class, 14, PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(COUNTRY, PropertyDescriptorSupport.createDatatype(COUNTRY, Code.class, 15,
                PROPERTY_CONSTRAINTS[5], false, PropertyAssociationType.COMPONENT, COUNTRY_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(PostalAddress.getPropertyDescriptor(STREET), this.street, null));
        properties
                .add(super.createProperty(PostalAddress.getPropertyDescriptor(STREETNUMBER), this.streetNumber, null));
        properties.add(super.createProperty(PostalAddress.getPropertyDescriptor(CITY), this.city, null));
        properties.add(super.createProperty(PostalAddress.getPropertyDescriptor(ZIPCODE), this.zipCode, null));
        properties.add(super.createProperty(PostalAddress.getPropertyDescriptor(STATE), this.state, null));
        properties.add(super.createProperty(PostalAddress.getPropertyDescriptor(COUNTRY), this.getCountry(),
                this.countryRefId));
        properties.add(super.createProperty(PostalAddress.getPropertyDescriptor(FUNCTIONALTYPE),
                this.getFunctionalType(), this.functionalTypeRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(STREET) && (property.getType() == Street.class))) {
            this.setStreet(((Street) property.getInstance()));
            return true;
        } else if ((property.getName().equals(STREETNUMBER) && (property.getType() == StreetNumber.class))) {
            this.setStreetNumber(((StreetNumber) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CITY) && (property.getType() == City.class))) {
            this.setCity(((City) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ZIPCODE) && (property.getType() == ZipCode.class))) {
            this.setZipCode(((ZipCode) property.getInstance()));
            return true;
        } else if ((property.getName().equals(STATE) && (property.getType() == State.class))) {
            this.setState(((State) property.getInstance()));
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
        final PostalAddress other = ((PostalAddress) obj);
        if ((this.street == null)) {
            if ((other.street != null))
                return false;
        } else if ((!this.street.equals(other.street)))
            return false;
        if ((this.streetNumber == null)) {
            if ((other.streetNumber != null))
                return false;
        } else if ((!this.streetNumber.equals(other.streetNumber)))
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
        if ((this.state == null)) {
            if ((other.state != null))
                return false;
        } else if ((!this.state.equals(other.state)))
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
        result = ((PRIME * result) + ((this.street == null) ? 0 : this.street.hashCode()));
        result = ((PRIME * result) + ((this.streetNumber == null) ? 0 : this.streetNumber.hashCode()));
        result = ((PRIME * result) + ((this.city == null) ? 0 : this.city.hashCode()));
        result = ((PRIME * result) + ((this.zipCode == null) ? 0 : this.zipCode.hashCode()));
        result = ((PRIME * result) + ((this.state == null) ? 0 : this.state.hashCode()));
        result = ((PRIME * result) + ((this.country == null) ? 0 : this.country.hashCode()));
        result = ((PRIME * result) + ((this.countryRefId == null) ? 0 : this.countryRefId.hashCode()));
        result = ((PRIME * result) + ((this.functionalTypeRefId == null) ? 0 : this.functionalTypeRefId.hashCode()));
        return result;
    }

    @Override
    public PostalAddress cloneObject() {
        PostalAddress clone = new PostalAddress();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Street of the postal address.
     *
     * @return the Street.
     */
    public Street getStreet() {
        return this.street;
    }

    /**
     * Street of the postal address.
     *
     * @param street the Street.
     */
    public void setStreet(Street street) {
        this.street = street;
    }

    /**
     * Street of the postal address.
     *
     * @param street the String.
     */
    public void setStreet(String street) {
        if ((this.street == null)) {
            if ((street == null)) {
                return;
            }
            this.street = new Street();
        }
        this.street.setValue(street);
    }

    /**
     * Street Number of the postal address.
     *
     * @return the StreetNumber.
     */
    public StreetNumber getStreetNumber() {
        return this.streetNumber;
    }

    /**
     * Street Number of the postal address.
     *
     * @param streetNumber the StreetNumber.
     */
    public void setStreetNumber(StreetNumber streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * Street Number of the postal address.
     *
     * @param streetNumber the String.
     */
    public void setStreetNumber(String streetNumber) {
        if ((this.streetNumber == null)) {
            if ((streetNumber == null)) {
                return;
            }
            this.streetNumber = new StreetNumber();
        }
        this.streetNumber.setValue(streetNumber);
    }

    /**
     * City of the postal address.
     *
     * @return the City.
     */
    public City getCity() {
        return this.city;
    }

    /**
     * City of the postal address.
     *
     * @param city the City.
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * City of the postal address.
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
     * ZIP Code of the postal address.
     *
     * @return the ZipCode.
     */
    public ZipCode getZipCode() {
        return this.zipCode;
    }

    /**
     * ZIP Code of the postal address.
     *
     * @param zipCode the ZipCode.
     */
    public void setZipCode(ZipCode zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * ZIP Code of the postal address.
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
     * State of the postal address.
     *
     * @return the State.
     */
    public State getState() {
        return this.state;
    }

    /**
     * State of the postal address.
     *
     * @param state the State.
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * State of the postal address.
     *
     * @param state the String.
     */
    public void setState(String state) {
        if ((this.state == null)) {
            if ((state == null)) {
                return;
            }
            this.state = new State();
        }
        this.state.setValue(state);
    }

    /**
     * Country of the postal address.
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
     * Country of the postal address.
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
        return PropertyCache.getInstance().retrieve(PostalAddress.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(PostalAddress.class).getAllProperties();
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
