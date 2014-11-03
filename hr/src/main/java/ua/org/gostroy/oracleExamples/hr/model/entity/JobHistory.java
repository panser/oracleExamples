package ua.org.gostroy.oracleExamples.hr.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
@NamedQueries({
        @NamedQuery(name = "JobHistory.findAll", query = "select o from JobHistory o")
})
@Entity
@Table(name = "JOB_HISTORY")
public class JobHistory {
    @EmbeddedId
    protected JobHistoryPk jobHistoryPK;

    @MapsId("employeeId")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID", nullable = false)
    private Employee employee;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_DATE", nullable = false)
    private Date endDate;
    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade={})
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID", nullable = false)
    private Job job;
    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade={})
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    private Department department;

    public JobHistory() {
    }

    public JobHistory(JobHistoryPk jobHistoryPK, Employee employee, Date endDate, Job job) {
        this.jobHistoryPK = jobHistoryPK;
        this.employee = employee;
        this.endDate = endDate;
        this.job = job;
    }

    @PreRemove
    private void preRemove() {
        job = null;
        department = null;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public JobHistoryPk getJobHistoryPK() {
        return jobHistoryPK;
    }

    public void setJobHistoryPK(JobHistoryPk jobHistoryPK) {
        this.jobHistoryPK = jobHistoryPK;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "JobHistory{" +
                ", endDate=" + endDate +
                '}';
    }
}
