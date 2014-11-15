package ua.org.gostroy.oracleExamples.hr.model.entity;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
@Embeddable
public class JobHistoryPk implements Serializable {
    private Integer employeeId;
    private Date startDate;

    public JobHistoryPk() {
    }

    public JobHistoryPk(Integer employeeId, Date startDate) {
        this.employeeId = employeeId;
        this.startDate = startDate;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobHistoryPk)) return false;

        JobHistoryPk that = (JobHistoryPk) o;

        if (!employeeId.equals(that.employeeId)) return false;
        if (!startDate.equals(that.startDate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId.hashCode();
        result = 31 * result + startDate.hashCode();
        return result;
    }
}
