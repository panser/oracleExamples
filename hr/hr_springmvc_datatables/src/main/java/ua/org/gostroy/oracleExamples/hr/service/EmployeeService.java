package ua.org.gostroy.oracleExamples.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.gostroy.oracleExamples.hr.dao.EmployeeDao;
import ua.org.gostroy.oracleExamples.hr.dao.EmployeeDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Employee;

import java.util.List;

/**
 * Created by Panov Sergey on 12/6/2014.
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
    public List<Employee> findAll() {
        List<Employee> result = employeeDao.findAll();
        return result;
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

}
