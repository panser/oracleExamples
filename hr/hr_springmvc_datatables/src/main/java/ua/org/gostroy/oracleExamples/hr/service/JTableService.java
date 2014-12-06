package ua.org.gostroy.oracleExamples.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.org.gostroy.oracleExamples.hr.dao.DepartmentDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;
import ua.org.gostroy.oracleExamples.hr.model.entity.Employee;
import ua.org.gostroy.oracleExamples.hr.model.entity.Location;
import ua.org.gostroy.oracleExamples.hr.web.dto.jtable.bean.JtableDepartment;
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

    public List<JtableDepartment> findWithPagination(int start, int size) {
        List<Department> departments = departmentService.findWithPagination(start, size);
        List<JtableDepartment> result = new ArrayList<JtableDepartment>();
        for(Department department : departments){
            JtableDepartment jtableDepartment = new JtableDepartment();
            jtableDepartment.setId(department.getId());
            jtableDepartment.setName(department.getName());
            jtableDepartment.setManager((department.getManager() != null) ? department.getManager().getFirstName() : "");
            jtableDepartment.setLocation((department.getLocation() != null) ? department.getLocation().getCity() : "");

            result.add(jtableDepartment);
        }
        return result;
    }

    public List<JsonOptionsBean> findAllEmployee(){
        List<Employee> employees = employeeService.findAll();
        List<JsonOptionsBean> result = new ArrayList<JsonOptionsBean>();
        for(Employee employee : employees){
            JsonOptionsBean jsonOptionsBean = new JsonOptionsBean();
            jsonOptionsBean.setId(employee.getId());
            jsonOptionsBean.setDisplayText(employee.getFirstName() + " " + employee.getLastName());

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
            jsonOptionsBean.setDisplayText(location.getCity());

            result.add(jsonOptionsBean);
        }
        return result;
    }

    public Long getCount(){
        return departmentDao.getCount();
    }
}
