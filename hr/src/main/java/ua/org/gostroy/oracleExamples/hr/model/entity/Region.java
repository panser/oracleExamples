package ua.org.gostroy.oracleExamples.hr.model.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Panov Sergey on 10/31/2014.
 */
@NamedQueries({
        @NamedQuery(name = "Region.findAll", query = "select o from Region o")
})
@Entity
@Table(name = "REGIONS")
public class Region {
    private Integer id;
    private String name;

    private Set<Country> countries;

    public Region() {
    }

    public Region(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "REGION_ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "REGION_NAME", length = 25)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ElementCollection(fetch= FetchType.LAZY)
    @OneToMany(cascade={}, mappedBy = "region", orphanRemoval = true)
    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
