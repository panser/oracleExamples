package ua.org.gostroy.oracleExamples.hr.model.entity;

import javax.persistence.*;

/**
 * Created by Panov Sergey on 11/4/2014.
 */
@NamedQueries({
        @NamedQuery(name = "EmpDetailsView.findAll", query = "select o from EmpDetailsView o"),
        @NamedQuery(name = "EmpDetailsView.findByEmployeeId", query = "select o from EmpDetailsView o where empDetailsViewId.employeeId = :employeeId"),
        @NamedQuery(name = "EmpDetailsView.findByJobId", query = "SELECT o FROM EmpDetailsView o WHERE empDetailsViewId.jobId = :jobId"),
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "EmpDetailsView.findByEmployeeId2", query = "select * from EMP_DETAILS_VIEW WHERE EMPLOYEE_ID = :employeeId")
})
@Entity
@Table(name = "EMP_DETAILS_VIEW")
public class EmpDetailsView {

    private EmpDetailsViewId empDetailsViewId;

    public EmpDetailsView() {
    }

    public EmpDetailsView(EmpDetailsViewId empDetailsViewId) {
        this.empDetailsViewId = empDetailsViewId;
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "employeeId", column = @Column(name = "EMPLOYEE_ID", nullable = false, precision = 6, scale = 0)),
            @AttributeOverride(name = "jobId", column = @Column(name = "JOB_ID", nullable = false, length = 10)),
            @AttributeOverride(name = "managerId", column = @Column(name = "MANAGER_ID", precision = 6, scale = 0)),
            @AttributeOverride(name = "departmentId", column = @Column(name = "DEPARTMENT_ID", precision = 4, scale = 0)),
            @AttributeOverride(name = "locationId", column = @Column(name = "LOCATION_ID", precision = 4, scale = 0)),
            @AttributeOverride(name = "countryId", column = @Column(name = "COUNTRY_ID", length = 2, columnDefinition = "CHAR")),
            @AttributeOverride(name = "firstName", column = @Column(name = "FIRST_NAME", length = 20)),
            @AttributeOverride(name = "lastName", column = @Column(name = "LAST_NAME", nullable = false, length = 25)),
            @AttributeOverride(name = "salary", column = @Column(name = "SALARY", precision = 8)),
            @AttributeOverride(name = "commissionPct", column = @Column(name = "COMMISSION_PCT", precision = 2)),
            @AttributeOverride(name = "departmentName", column = @Column(name = "DEPARTMENT_NAME", nullable = false, length = 30)),
            @AttributeOverride(name = "jobTitle", column = @Column(name = "JOB_TITLE", nullable = false, length = 35)),
            @AttributeOverride(name = "city", column = @Column(name = "CITY", nullable = false, length = 30)),
            @AttributeOverride(name = "stateProvince", column = @Column(name = "STATE_PROVINCE", length = 25)),
            @AttributeOverride(name = "countryName", column = @Column(name = "COUNTRY_NAME", length = 40)),
            @AttributeOverride(name = "regionName", column = @Column(name = "REGION_NAME", length = 25))})

    public EmpDetailsViewId getEmpDetailsViewId() {
        return empDetailsViewId;
    }

    public void setEmpDetailsViewId(EmpDetailsViewId empDetailsViewId) {
        this.empDetailsViewId = empDetailsViewId;
    }
}
