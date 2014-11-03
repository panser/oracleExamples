package ua.org.gostroy.oracleExamples.hr.model.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Panov Sergey on 10/31/2014.
 */
@Entity(name = "LOCATIONS")
public class Location {
    @Id
    @Column(name = "LOCATION_ID", precision = 4)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOC_SEQ")
    @SequenceGenerator(name="LOC_SEQ", sequenceName="LOCATIONS_SEQ")
    private Integer id;
    @Column(name = "STREET_ADDRESS", length = 40)
    private String streetAddress;
    @Column(name = "POSTAL_CODE", length = 12)
    private String postalCode;
    @Column(name = "CITY", length = 30, nullable = false)
    private String city;
    @Column(name = "STATE_PROVINCE", length = 25)
    private String stateProvince;
    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade={})
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    private Country country;
    @ElementCollection(fetch= FetchType.LAZY)
    @OneToMany(cascade={}, mappedBy = "location")
    private Set<Department> departments;

    public Location() {
    }

    public Location(String city) {
        this.city = city;
    }

    @PreRemove
    private void preRemove() {
        for (Department d : departments) {
            d.setLocation(null);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
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
