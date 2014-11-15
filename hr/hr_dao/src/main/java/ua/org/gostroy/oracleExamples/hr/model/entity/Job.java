package ua.org.gostroy.oracleExamples.hr.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
@NamedQueries({
        @NamedQuery(name = "Job.findAll", query = "select o from Job o")
})
@Entity
@Table(name = "JOBS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Job {
    private String id;
    private String title;
    private Integer minSalary;
    private Integer maxSalary;

    @JsonBackReference
    private Set<Employee> employees = new HashSet<>(0);
    @JsonBackReference
    private Set<JobHistory> jobHistories = new HashSet<>(0);

    public Job() {
    }

    public Job(String id) {
        this.id = id;
    }

    @PreRemove
    private void preRemove() {
    }

    @Id
    @Column(name = "JOB_ID", length = 10, unique = true, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "JOB_TITLE", length = 35)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "MIN_SALARY", precision = 6)
    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    @Column(name = "MAX_SALARY", precision = 6)
    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = {}, mappedBy = "job", orphanRemoval = true)
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = {}, mappedBy = "job", orphanRemoval = true)
    public Set<JobHistory> getJobHistories() {
        return jobHistories;
    }

    public void setJobHistories(Set<JobHistory> jobHistories) {
        this.jobHistories = jobHistories;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}
