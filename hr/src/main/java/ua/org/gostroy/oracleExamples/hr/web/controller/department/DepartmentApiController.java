package ua.org.gostroy.oracleExamples.hr.web.controller.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;
import ua.org.gostroy.oracleExamples.hr.service.DepartmentService;
import ua.org.gostroy.oracleExamples.hr.web.ajax.DataTableRequest;
import ua.org.gostroy.oracleExamples.hr.web.ajax.DataTableResponse;

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
    @ResponseBody
    public DataTableResponse findAll(@RequestBody DataTableRequest dataTableRequest){
        List<Department> departments = departmentService.findAll();
        return new DataTableResponse();
    }

}
