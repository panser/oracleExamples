package ua.org.gostroy.oracleExamples.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.gostroy.oracleExamples.hr.dao.DepartmentDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;
import ua.org.gostroy.oracleExamples.hr.model.entity.Employee;
import ua.org.gostroy.oracleExamples.hr.model.entity.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Panov Sergey on 11/4/2014.
 */
@Service
@Transactional
public class DepartmentService {

    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    LocationService locationService;

    @Transactional(readOnly = true)
    public Department findById(Integer id) {
        Department result = departmentDao.findById(id);
        return result;
    }

    @Transactional(readOnly = true)
    public List<Department> findAll() {
        List<Department> result = departmentDao.findAll();
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public Department save(Department entity) throws DataIntegrityViolationException {
        Department result = departmentDao.save(entity);
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public Department update(Department entity) throws DataIntegrityViolationException {
        Department result = departmentDao.update(entity);
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Department entity) {
        departmentDao.delete(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        Department entity = findById(id);
        departmentDao.delete(entity);
    }

    @Transactional(readOnly = true)
    public List<Department> findWithPaginationAndFiltering(Long start, Long size, List<String> sortOrder, String name, String manager, String location) {

        List<Department> result = departmentDao.findWithPaginationAndSortingAndFiltering(start, size, sortOrder, name, manager, location);
        return result;
    }

    @Transactional(readOnly = true)
    public Long findCountWithFiltering(String name, String manager, String location) {

        Long result = departmentDao.findCountWithFiltering(name, manager, location);
        return result;
    }

    @Transactional(readOnly = true)
    public Long getCount(){
        return departmentDao.getCount();
    }
}
