package ua.org.gostroy.oracleExamples.hr.web.controller.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.org.gostroy.oracleExamples.hr.web.dto.jtable.bean.JsonDepartment;
import ua.org.gostroy.oracleExamples.hr.service.JTableService;
import ua.org.gostroy.oracleExamples.hr.web.dto.jtable.response.JsonResponse;
import ua.org.gostroy.oracleExamples.hr.web.dto.jtable.response.JsonListResponse;
import ua.org.gostroy.oracleExamples.hr.web.dto.jtable.response.JsonOptionsBean;
import ua.org.gostroy.oracleExamples.hr.web.dto.jtable.response.JsonOptionsResponse;

import java.util.List;

/**
 * Created by Panov Sergey on 12/6/2014.
 */
@Controller
@RequestMapping("/api/department/jTable")
public class JTableController {

    @Autowired
    JTableService jTableService;

    /*Table data load - This loads the data for the table*/
    @RequestMapping(value = "/List")
    @ResponseBody
    public JsonListResponse list(@RequestParam int jtStartIndex, @RequestParam int jtPageSize) {
        JsonListResponse jstr;

        try {
            Long departmCount = jTableService.getCount();
            List<JsonDepartment> depList = jTableService.findWithPagination(jtStartIndex, jtPageSize);
            jstr = new JsonListResponse("OK",depList,departmCount);
        } catch (Exception e) {
            jstr = new JsonListResponse("ERROR",e.getMessage());
        }

        return jstr;
    }

    /*Cascaded drop down*/
    @RequestMapping(value = "/List/Managers")
    @ResponseBody
    public JsonOptionsResponse getManagers(){
        JsonOptionsResponse jstr;
        try {
            List<JsonOptionsBean> employees = jTableService.findAllEmployee();
            jstr = new JsonOptionsResponse("OK",employees);
        } catch (Exception e) {
            jstr = new JsonOptionsResponse("ERROR",e.getMessage());
        }
        return jstr;
    }

    /*Cascaded drop down*/
    @RequestMapping(value = "/List/Locations")
    @ResponseBody
    public JsonOptionsResponse getLocations(){
        JsonOptionsResponse jstr;
        try {
            List<JsonOptionsBean> locations = jTableService.findAllLocation();
            jstr = new JsonOptionsResponse("OK",locations);
        } catch (Exception e) {
            jstr = new JsonOptionsResponse("ERROR",e.getMessage());
        }
        return jstr;
    }

    /*CRUD operation - Add */
    @RequestMapping(value = "/Create", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse addDepartment(@ModelAttribute JsonDepartment jsonDepartment, BindingResult result) {
        JsonResponse jsonResponse;
        if (result.hasErrors()) {
            jsonResponse = new JsonResponse("ERROR","Form invalid");
        }
        try {
            jTableService.save(jsonDepartment);
            jsonResponse = new JsonResponse("OK",jsonDepartment);
        } catch (Exception e) {
            jsonResponse = new JsonResponse("ERROR",e.getMessage());
        }
        return jsonResponse;
    }

    /*CRUD operation - Update */
    @RequestMapping(value = "/Update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse updateDepartment(@ModelAttribute JsonDepartment jsonDepartment, BindingResult result) {
        JsonResponse jsonResponse;
        if (result.hasErrors()) {
            jsonResponse = new JsonResponse("ERROR","Form invalid");
        }
        try {
            jTableService.update(jsonDepartment);
            jsonResponse = new JsonResponse("OK",jsonDepartment);
        } catch (Exception e) {
            jsonResponse = new JsonResponse("ERROR",e.getMessage());
        }
        return jsonResponse;
    }
}
