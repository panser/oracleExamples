package ua.org.gostroy.oracleExamples.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;
import ua.org.gostroy.oracleExamples.hr.web.dto.jtable.bean.JtableDepartment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Panov Sergey on 12/6/2014.
 */
@Service
public class JTableService {

    @Autowired
    DepartmentService departmentService;

    public List<JtableDepartment> findAll() {
        List<Department> departments = departmentService.findAll();
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

    public int getCount(){
        return findAll().size();
    }
}
