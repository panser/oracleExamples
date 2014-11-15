package ua.org.gostroy.oracleExamples.hr.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
@NamedQueries({
        @NamedQuery(name = "JobHistory.findAll", query = "select o from JobHistory o"),
        @NamedQuery(name = "JobHistory.findByEmployeeId", query = "SELECT o FROM JobHistory o WHERE o.jobHistoryPK.employeeId = :employeeId"),
        @NamedQuery(name = "JobHistory.findByStartDate", query = "SELECT o FROM JobHistory o WHERE o.jobHistoryPK.startDate = :startDate"),
})
@Entity
@Table(name = "JOB_HISTORY")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobHistory {
    private JobHistoryPk jobHistoryPK;

    private Employee employee;

    private Date endDate;
    private Job job;
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
        employee = null;
        job = null;
        department = null;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_DATE", nullable = false)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID", nullable = false)
    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "employeeId", column = @Column(name = "EMPLOYEE_ID", nullable = false, precision = 6, scale = 0)),
            @AttributeOverride(name = "startDate", column = @Column(name = "START_DATE", nullable = false, columnDefinition = "TIMESTAMP"))})
    public JobHistoryPk getJobHistoryPK() {
        return jobHistoryPK;
    }

    public void setJobHistoryPK(JobHistoryPk jobHistoryPK) {
        this.jobHistoryPK = jobHistoryPK;
    }

    @MapsId("employeeId")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID", nullable = false)
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
