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
@IdClass(value = JobHistoryPk.class)
public class JobHistory implements Serializable {
    @Id
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID", nullable = false)
    private Employee employee;
    @Id
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_DATE", nullable = false)
    private Date startDate;
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

    public JobHistory(Employee employee, Date startDate, Date endDate, Job job) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.job = job;
    }

    @PreRemove
    private void preRemove() {
        employee = null;
        job = null;
        department = null;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    @Override
    public String toString() {
        return "JobHistory{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
