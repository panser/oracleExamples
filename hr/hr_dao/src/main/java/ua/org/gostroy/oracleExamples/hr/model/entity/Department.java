package ua.org.gostroy.oracleExamples.hr.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
@NamedQueries({
        @NamedQuery(name = "Department.findAll", query = "select o from Department o")
})
@Entity
@Table(name = "DEPARTMENTS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department {
    private Integer id;
    private String name;
    private Employee manager;
    private Location location;

    @JsonBackReference
    private Set<Employee> employees = new HashSet<>(0);
    @JsonBackReference
    private Set<JobHistory> jobHistories = new HashSet<>(0);

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    @PreRemove
    private void preRemove() {
        location = null;
    }

    @Id
    @Column(name = "DEPARTMENT_ID", precision = 4, unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEP_SEQ")
    @SequenceGenerator(name = "DEP_SEQ", sequenceName = "DEPARTMENTS_SEQ")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "DEPARTMENT_NAME", length = 30, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(cascade = {}, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @ManyToOne(optional = true, fetch = FetchType.EAGER, cascade = {})
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = {}, mappedBy = "department", orphanRemoval = true)
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = {}, mappedBy = "department", orphanRemoval = true)
    public Set<JobHistory> getJobHistories() {
        return jobHistories;
    }

    public void setJobHistories(Set<JobHistory> jobHistories) {
        this.jobHistories = jobHistories;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
