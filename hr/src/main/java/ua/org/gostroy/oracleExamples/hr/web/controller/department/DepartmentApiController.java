package ua.org.gostroy.oracleExamples.hr.web.controller.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;
import ua.org.gostroy.oracleExamples.hr.service.DepartmentService;

import java.util.List;

/**
 * Created by Panov Sergey on 11/5/2014.
 */
@Controller
@RequestMapping("/api/department")
public class DepartmentApiController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/")
    public List<Department> findAll(Model model){
        return departmentService.findAll();
    }

}
