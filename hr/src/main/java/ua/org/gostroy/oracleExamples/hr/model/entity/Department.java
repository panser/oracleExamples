package ua.org.gostroy.oracleExamples.hr.model.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
@Entity(name = "DEPARTMENTS")
public class Department {
    @Id
    @Column(name = "DEPARTMENT_ID", precision = 4)
    private Integer id;
    @Column(name = "DEPARTMENT_NAME", length = 30, nullable = false)
    private String name;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;
    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
    private Location location;

    @ElementCollection(fetch= FetchType.LAZY)
    @OneToMany(cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}, mappedBy = "department")
    private Set<Employee> employees;
    @ElementCollection(fetch= FetchType.LAZY)
    @OneToMany(cascade={CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}, mappedBy = "department")
    private Set<JobHistory> jobHistories;

    public Department() {
    }

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

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
