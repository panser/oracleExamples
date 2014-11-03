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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEP_SEQ")
    @SequenceGenerator(name="DEP_SEQ", sequenceName="DEPARTMENTS_SEQ")
    private Integer id;
    @Column(name = "DEPARTMENT_NAME", length = 30, nullable = false)
    private String name;
    @OneToOne(cascade={}, orphanRemoval = true)
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;
    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade={})
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
    private Location location;

    @ElementCollection(fetch= FetchType.LAZY)
    @OneToMany(cascade={}, mappedBy = "department", orphanRemoval = true)
    private Set<Employee> employees;
    @ElementCollection(fetch= FetchType.LAZY)
    @OneToMany(cascade={}, mappedBy = "department")
    private Set<JobHistory> jobHistories;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    @PreRemove
    private void preRemove() {
        location = null;
        for(JobHistory jobHistory : jobHistories){
            jobHistories = null;
        }
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
