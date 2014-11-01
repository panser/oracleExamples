package ua.org.gostroy.oracleExamples.hr.dao;

import ua.org.gostroy.oracleExamples.hr.model.entity.Employee;
import ua.org.gostroy.oracleExamples.hr.model.entity.Employee;

import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public interface EmployeeDao {
    Employee findById(Integer id);
    List<Employee> findAll();
    Employee save(Employee entity);
    Employee update(Employee entity);
    void delete(Employee entity);
}
