package ua.org.gostroy.oracleExamples.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.gostroy.oracleExamples.hr.dao.DepartmentDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;
import ua.org.gostroy.oracleExamples.hr.model.entity.Employee;
import ua.org.gostroy.oracleExamples.hr.model.entity.Location;
import ua.org.gostroy.oracleExamples.hr.web.dto.jtable.bean.JsonDepartment;
import ua.org.gostroy.oracleExamples.hr.web.dto.jtable.response.JsonOptionsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Panov Sergey on 12/6/2014.
 */
@Service
public class JTableService {

    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    LocationService locationService;

    public List<JsonOptionsBean> findAllEmployee(){
        List<Employee> employees = employeeService.findAll();
        List<JsonOptionsBean> result = new ArrayList<JsonOptionsBean>();
        for(Employee employee : employees){
            JsonOptionsBean jsonOptionsBean = new JsonOptionsBean();
            jsonOptionsBean.setId(employee.getId());
            jsonOptionsBean.setDisplayText(employee);

            result.add(jsonOptionsBean);
        }
        return result;
    }

    public List<JsonOptionsBean> findAllLocation(){
        List<Location> locations = locationService.findAll();
        List<JsonOptionsBean> result = new ArrayList<JsonOptionsBean>();
        for(Location location : locations){
            JsonOptionsBean jsonOptionsBean = new JsonOptionsBean();
            jsonOptionsBean.setId(location.getId());
            jsonOptionsBean.setDisplayText(location);

            result.add(jsonOptionsBean);
        }
        return result;
    }

    @Transactional(readOnly = true)
    public Long getCount(){
        return departmentDao.getCount();
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(JsonDepartment jsonDepartment) {
        Department department = new Department();
        department.setName(jsonDepartment.getName());
//        department.setManager();
//        department.setLocation();
        departmentDao.save(department);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(JsonDepartment jsonDepartment) {
        Department department = departmentDao.findById(jsonDepartment.getId());
        department.setName(jsonDepartment.getName());
//        department.setManager();
//        department.setLocation();
        departmentDao.update(department);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        Department department = departmentDao.findById(id);
        departmentDao.delete(department);
    }
}
