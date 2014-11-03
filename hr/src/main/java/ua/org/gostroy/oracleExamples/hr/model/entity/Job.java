package ua.org.gostroy.oracleExamples.hr.model.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
@NamedQueries({
        @NamedQuery(name = "Job.findAll", query = "select o from JOBS o")
})
@Entity(name = "JOBS")
public class Job {
    @Id
    @Column(name = "JOB_ID", length = 10)
    private String id;
    @Column(name = "JOB_TITLE", length = 35)
    private String title;
    @Column(name = "MIN_SALARY", precision = 6)
    private Integer minSalary;
    @Column(name = "MAX_SALARY", precision = 6)
    private Integer maxSalary;

    @ElementCollection(fetch= FetchType.LAZY)
    @OneToMany(cascade={}, mappedBy = "job", orphanRemoval = true)
    private Set<Employee> employees;
    @ElementCollection(fetch= FetchType.LAZY)
    @OneToMany(cascade={}, mappedBy = "job")
    private Set<JobHistory> jobHistories;

    public Job() {
    }

    public Job(String id) {
        this.id = id;
    }

    @PreRemove
    private void preRemove() {
        for(JobHistory jobHistory : jobHistories){
            jobHistories = null;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
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
        return "Job{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}
