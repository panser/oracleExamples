package ua.org.gostroy.oracleExamples.hr.web.controller.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;
import ua.org.gostroy.oracleExamples.hr.service.DepartmentService;
import ua.org.gostroy.oracleExamples.hr.web.jquery.DataTableRequest;
import ua.org.gostroy.oracleExamples.hr.web.jquery.DataTableResponse;

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
//    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DataTableResponse findAll(){
//    public DataTableResponse findAll(@RequestBody DataTableRequest dataTableRequest){
        List<Department> departments = departmentService.findAll();
        return new DataTableResponse();
    }

}
