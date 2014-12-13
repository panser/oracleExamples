package ua.org.gostroy.oracleExamples.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    LocationService locationService;

    public List<JsonDepartment> findWithPaginationAndSortingAndFiltering(Long jtStartIndex, Long jtPageSize, String jtSorting,
                                                                         String name, String manager, String location) {
        List<String> sortOrders = new ArrayList<>();
        if(jtSorting != null) {
            String[] orders = jtSorting.split(",");
            for (String order : orders) {
                String[] str = order.split(" ");
                switch (str[0]) {
                    case "id":
                        sortOrders.add("id " + str[1]);
                        break;
                    case "name":
                        sortOrders.add("name " + str[1]);
                        break;
                    case "manager":
                        sortOrders.add("manager.lastName " + str[1]);
                        break;
                    case "location":
                        sortOrders.add("location.city " + str[1]);
                        break;
                }
            }
        }
        name = (name != null && name.isEmpty()) ? null : name;
        manager = (manager != null && manager.isEmpty()) ? null : manager;
        location = (location != null && location.isEmpty()) ? null : location;
        List<Department> departments = departmentService.findWithPaginationAndFiltering(jtStartIndex, jtPageSize, sortOrders,
                name, manager, location);

        List<JsonDepartment> result = new ArrayList<JsonDepartment>();
        for(Department department : departments){
            JsonDepartment jtableDepartment = new JsonDepartment();
            jtableDepartment.setId(department.getId());
            jtableDepartment.setName(department.getName());
            jtableDepartment.setManager((department.getManager() != null) ? department.getManager().getId() : 0);
            jtableDepartment.setLocation((department.getLocation() != null) ? department.getLocation().getId() : 0);

            result.add(jtableDepartment);
        }
        return result;
    }

    public List<JsonOptionsBean> findAllEmployee(){
        List<Employee> employees = employeeService.findAll();
        List<JsonOptionsBean> result = new ArrayList<JsonOptionsBean>();
        JsonOptionsBean nullJsonOptionsBean = new JsonOptionsBean(0, "");
        result.add(nullJsonOptionsBean);
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
        return departmentService.getCount();
    }

    public void save(JsonDepartment jsonDepartment) {
        Department department = new Department();
        department.setName(jsonDepartment.getName());
        if(jsonDepartment.getManager() != 0) {
            Employee manager = employeeService.findById(jsonDepartment.getManager());
            department.setManager(manager);
        }
        Location location = locationService.findById(jsonDepartment.getLocation());
        department.setLocation(location);

        departmentService.save(department);
    }

    public void update(JsonDepartment jsonDepartment) {
        Department department = departmentService.findById(jsonDepartment.getId());
        department.setName(jsonDepartment.getName());
        if(jsonDepartment.getManager() != 0) {
            Employee manager = employeeService.findById(jsonDepartment.getManager());
            department.setManager(manager);
        }
        Location location = locationService.findById(jsonDepartment.getLocation());
        department.setLocation(location);

        departmentService.update(department);
    }

    public void delete(Integer id) {
        Department department = departmentService.findById(id);
        departmentService.delete(department);
    }
}
