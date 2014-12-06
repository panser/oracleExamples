package ua.org.gostroy.oracleExamples.hr.web.controller.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.org.gostroy.oracleExamples.hr.web.dto.jtable.bean.JtableDepartment;
import ua.org.gostroy.oracleExamples.hr.service.JTableService;
import ua.org.gostroy.oracleExamples.hr.web.dto.jtable.response.JsonList;

import java.util.List;

/**
 * Created by Panov Sergey on 12/6/2014.
 */
@Controller
@RequestMapping("/api/department/jTable")
public class JTableController {

    @Autowired
    JTableService jTableService;

    @RequestMapping(value = "/List")
    @ResponseBody
    public JsonList jTableList(@RequestParam int jtStartIndex, @RequestParam int jtPageSize) {
        JsonList jstr;

        try {
            Long departmCount = jTableService.getCount();
            List<JtableDepartment> depList = jTableService.findWithPagination(jtStartIndex,jtPageSize);
            jstr = new JsonList("OK",depList,departmCount);
        } catch (Exception e) {
            jstr = new JsonList("ERROR",e.getMessage());
        }

        return jstr;
    }
}
