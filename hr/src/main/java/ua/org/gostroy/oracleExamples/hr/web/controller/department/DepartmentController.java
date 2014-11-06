package ua.org.gostroy.oracleExamples.hr.web.controller.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;
import ua.org.gostroy.oracleExamples.hr.service.DepartmentService;
import ua.org.gostroy.oracleExamples.hr.web.jquery.DataTableRequest;
import ua.org.gostroy.oracleExamples.hr.web.jquery.DataTableResponse;

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

    @RequestMapping(value = "/DataTablesList")
    public String dataTablesList(Model model){
        model.addAttribute("departments", departmentService.findAll());
        return "department/DataTablesList";
    }

    @RequestMapping(value = "/DataTablesListAjax")
    public String dataTablesListAjax(Model model){
        return "department/DataTablesListAjax";
    }

}
