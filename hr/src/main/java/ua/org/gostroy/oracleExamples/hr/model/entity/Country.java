package ua.org.gostroy.oracleExamples.hr.model.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Panov Sergey on 10/31/2014.
 */
@NamedQueries({
        @NamedQuery(name = "Country.findAll", query = "select o from COUNTRIES o")
//        @NamedQuery(name = "Country.findAll", query = "select o from Country o")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "Country.findAll2", query = "select * from COUNTRIES")
})
@Entity(name = "COUNTRIES")
public class Country {
    @Id
    @Column(name = "COUNTRY_ID", columnDefinition = "char", length = 2)
    private String id;
    @Column(name = "COUNTRY_NAME", length = 40)
    private String name;
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID", referencedColumnName = "REGION_ID")
    private Region region;
    @ElementCollection(fetch= FetchType.LAZY)
    @OneToMany(mappedBy = "country", orphanRemoval = true)
    private Set<Location> locations;

    public Country() {
    }

    public Country(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

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
