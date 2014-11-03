package ua.org.gostroy.oracleExamples.hr.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "select o from Employee o")
})
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @Column(name = "EMPLOYEE_ID", precision = 6)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMP_SEQ")
    @SequenceGenerator(name="EMP_SEQ", allocationSize=10, sequenceName="EMPLOYEES_SEQ")
    private Integer id;
    @Column(name = "FIRST_NAME", length = 20)
    private String firstName;
    @Column(name = "LAST_NAME", length = 25, nullable = false)
    private String lastName;
    @Column(name = "EMAIL", length = 25, nullable = false, unique = true)
    private String email;
    @Column(name = "PHONE_NUMBER", length = 20)
    private String phoneNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HIRE_DATE", nullable = false)
    private Date hireDate;
    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade={})
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID", nullable = false)
    private Job job;
    @Column(name = "SALARY", precision = 8, scale = 2)
    private BigDecimal salary;
    @Column(name = "COMMISSION_PCT", precision = 2, scale = 2)
    private BigDecimal commissionPct;
    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade={})
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
    private Employee manager;
    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade={})
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    private Department department;

    @OneToOne(mappedBy = "manager", cascade={})
    private Department managerOfDepartment;
    @ElementCollection(fetch= FetchType.LAZY)
    @OneToMany(cascade={}, mappedBy = "employee")
    private Set<JobHistory> jobHistories;

    public Employee() {
    }

    public Employee(String lastName, String email, Date hireDate, Job job) {
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.job = job;
    }

    @PreRemove
    private void preRemove() {
        job = null;
        manager = null;
        department = null;
        managerOfDepartment = null;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getManagerOfDepartment() {
        return managerOfDepartment;
    }

    public void setManagerOfDepartment(Department managerOfDepartment) {
        this.managerOfDepartment = managerOfDepartment;
    }

    public Set<JobHistory> getJobHistories() {
        return jobHistories;
    }

    public void setJobHistories(Set<JobHistory> jobHistories) {
        this.jobHistories = jobHistories;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                '}';
    }
}
