package ua.org.gostroy.oracleExamples.hr.model.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
@NamedQueries({
        @NamedQuery(name = "Department.findAll", query = "select o from Department o")
})
@Entity
@Table(name = "DEPARTMENTS")
public class Department {
    private Integer id;
    private String name;
    private Employee manager;
    private Location location;

    private Set<Employee> employees;
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

    @Id
    @Column(name = "DEPARTMENT_ID", precision = 4)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEP_SEQ")
    @SequenceGenerator(name="DEP_SEQ", sequenceName="DEPARTMENTS_SEQ")
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

    @OneToOne(cascade={}, orphanRemoval = true)
    @JoinColumn(name = "MANAGER_ID")
    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade={})
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @ElementCollection(fetch= FetchType.LAZY)
    @OneToMany(cascade={}, mappedBy = "department", orphanRemoval = true)
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @ElementCollection(fetch= FetchType.LAZY)
    @OneToMany(cascade={}, mappedBy = "department")
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
