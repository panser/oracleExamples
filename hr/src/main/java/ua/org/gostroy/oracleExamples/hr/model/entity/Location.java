package ua.org.gostroy.oracleExamples.hr.model.entity;

import javax.persistence.*;

/**
 * Created by Panov Sergey on 10/31/2014.
 */
@Entity(name = "LOCATIONS")
public class Location {
    @Id
    @Column(name = "LOCATION_ID", length = 4)
    private Long id;
    @Column(name = "STREET_ADDRESS", length = 40)
    private String streetAddress;
    @Column(name = "POSTAL_CODE", length = 12)
    private String postalCode;
    @Column(name = "CITY", length = 30, nullable = false)
    private String city;
    @Column(name = "STATE_PROVINCE", length = 25)
    private String stateProvince;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    private Country country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", streetAddress='" + streetAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                '}';
    }
}
