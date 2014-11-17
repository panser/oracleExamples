package ua.org.gostroy.oracleExamples.hr.javafx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.gostroy.oracleExamples.hr.dao.EmployeeDao;
import ua.org.gostroy.oracleExamples.hr.javafx.model.EmployeeFx;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;
import ua.org.gostroy.oracleExamples.hr.model.entity.Employee;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Panov Sergey on 11/17/2014.
 */
@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Transactional(readOnly = true)
    public Employee findById(Integer id) {
        Employee result = employeeDao.findById(id);
        return result;
    }

    @Transactional(readOnly = true)
    public List<EmployeeFx> findAll() {
        List<Employee> result = employeeDao.findAll();
        EmployeeFx employeeFx;
        List<EmployeeFx> employeeFxes = new ArrayList<>();
        for(Employee employee : result){
            employeeFx = new EmployeeFx(employee);
            employeeFxes.add(employeeFx);
        }
        return employeeFxes;
    }

    @Transactional(rollbackFor = Exception.class)
    public Employee save(Employee entity) throws DataIntegrityViolationException {
        Employee result = employeeDao.save(entity);
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public Employee update(Employee entity) throws DataIntegrityViolationException {
        Employee result = employeeDao.update(entity);
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Employee entity) {
        employeeDao.delete(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        Employee entity = findById(id);
        employeeDao.delete(entity);
    }

    public List<EmployeeFx> findByDepartment(Integer departmentId) {
        List<Employee> result = employeeDao.findByDepartmentId(departmentId);
        EmployeeFx employeeFx;
        List<EmployeeFx> employeeFxes = new ArrayList<>();
        for(Employee employee : result){
            employeeFx = new EmployeeFx(employee);
            employeeFxes.add(employeeFx);
        }
        return employeeFxes;
    }

}
