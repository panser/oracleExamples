package ua.org.gostroy.oracleExamples.hr.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public class JobHistoryPk implements Serializable {
    private Employee employee;
    private Date startDate;

    public JobHistoryPk() {
    }

    public JobHistoryPk(Employee employee, Date startDate) {
        this.employee = employee;
        this.startDate = startDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobHistoryPk)) return false;

        JobHistoryPk that = (JobHistoryPk) o;

        if (employee != null ? !employee.equals(that.employee) : that.employee != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employee != null ? employee.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        return result;
    }
}
