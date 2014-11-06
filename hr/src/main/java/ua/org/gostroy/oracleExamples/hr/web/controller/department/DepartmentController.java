package ua.org.gostroy.oracleExamples.hr.web.controller.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;
import ua.org.gostroy.oracleExamples.hr.service.DepartmentService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Panov Sergey on 11/4/2014.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostConstruct
    protected void beforeConstruct(){
        System.out.println(getClass() + " :post construct method invoked");
    }

    @RequestMapping(value = "/")
    public String list(Model model){
        model.addAttribute("departments", departmentService.findAll());
        return "department/list";
    }

}
