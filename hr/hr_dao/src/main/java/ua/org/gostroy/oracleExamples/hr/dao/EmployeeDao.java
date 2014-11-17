package ua.org.gostroy.oracleExamples.hr.dao;

import org.springframework.dao.DataIntegrityViolationException;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;
import ua.org.gostroy.oracleExamples.hr.model.entity.Employee;

import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public interface EmployeeDao {
    Employee findById(Integer id);

    List<Employee> findAll();

    Employee save(Employee entity) throws DataIntegrityViolationException;

    Employee update(Employee entity) throws DataIntegrityViolationException;

    void delete(Employee entity) throws DataIntegrityViolationException;

    List<Employee> findByDepartmentId(Integer departmentId);
}
