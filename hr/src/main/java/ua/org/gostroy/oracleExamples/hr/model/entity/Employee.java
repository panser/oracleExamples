package ua.org.gostroy.oracleExamples.hr.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
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
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private Date hireDate;
    private Job job;
    private BigDecimal salary;
    private BigDecimal commissionPct;
    private Employee manager;
    private Department department;

    @JsonIgnore
    private Department managerOfDepartment;
    @JsonIgnore
    private Set<Employee> employeesesOfThisManager = new HashSet<>(0);
    @JsonIgnore
    private Set<JobHistory> jobHistories = new HashSet<>(0);

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
        for(Employee employee : employeesesOfThisManager){
            employee.setManager(null);
        }
    }

    @Id
    @Column(name = "EMPLOYEE_ID", precision = 6, unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMP_SEQ")
    @SequenceGenerator(name="EMP_SEQ", allocationSize=10, sequenceName="EMPLOYEES_SEQ")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "FIRST_NAME", length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME", length = 25, nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "EMAIL", length = 25, nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "PHONE_NUMBER", length = 20)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HIRE_DATE", nullable = false)
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade={})
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID", nullable = false)
    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Column(name = "SALARY", precision = 8, scale = 2)
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Column(name = "COMMISSION_PCT", precision = 2, scale = 2)
    public BigDecimal getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade={})
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade={})
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @OneToOne(mappedBy = "manager")
    public Department getManagerOfDepartment() {
        return managerOfDepartment;
    }

    public void setManagerOfDepartment(Department managerOfDepartment) {
        this.managerOfDepartment = managerOfDepartment;
    }

    @OneToMany(fetch= FetchType.LAZY, cascade={}, mappedBy = "manager")
    public Set<Employee> getEmployeesesOfThisManager() {
        return employeesesOfThisManager;
    }

    public void setEmployeesesOfThisManager(Set<Employee> employeesesOfThisManager) {
        this.employeesesOfThisManager = employeesesOfThisManager;
    }

    @OneToMany(fetch= FetchType.LAZY, cascade={}, mappedBy = "employee", orphanRemoval = true)
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
