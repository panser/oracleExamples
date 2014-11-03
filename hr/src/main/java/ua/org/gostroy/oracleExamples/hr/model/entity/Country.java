package ua.org.gostroy.oracleExamples.hr.model.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Panov Sergey on 10/31/2014.
 */
@NamedQueries({
        @NamedQuery(name = "Country.findAll", query = "select o from Country o"),
        @NamedQuery(name = "Country.findByName", query = "SELECT o FROM Country o WHERE o.name = :name"),
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "Country.findAll2", query = "select * from COUNTRIES")
})
@Entity
@Table(name = "COUNTRIES")
public class Country{
    private String id;
    private String name;
    private Region region;
    private Set<Location> locations;

    public Country() {
    }

    public Country(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "COUNTRY_ID", columnDefinition = "char", length = 2)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "COUNTRY_NAME", length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID", referencedColumnName = "REGION_ID")
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @ElementCollection(fetch= FetchType.LAZY)
    @OneToMany(mappedBy = "country", orphanRemoval = true)
    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
