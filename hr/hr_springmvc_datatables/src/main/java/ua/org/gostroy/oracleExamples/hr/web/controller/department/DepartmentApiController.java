package ua.org.gostroy.oracleExamples.hr.web.controller.department;

import com.github.dandelion.datatables.core.ajax.DataSet;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;
import com.github.dandelion.datatables.core.ajax.DatatablesResponse;
import com.github.dandelion.datatables.extras.spring3.ajax.DatatablesParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;
import ua.org.gostroy.oracleExamples.hr.service.DepartmentOverDatatablesService;
import ua.org.gostroy.oracleExamples.hr.service.DepartmentService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Panov Sergey on 11/5/2014.
 */
@Controller
@RequestMapping("/api/department")
public class DepartmentApiController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    DepartmentOverDatatablesService departmentOverDatatablesService;

    @RequestMapping(value = "/")
    public @ResponseBody
    DatatablesResponse<Department> findAllForDataTablesFullSpring(@DatatablesParams DatatablesCriterias criterias) {
//    DatatablesResponse<Department> findAllForDataTables(HttpServletRequest request) {
//        DatatablesCriterias criterias = DatatablesCriterias.getFromRequest(request);
        DataSet<Department> departments = departmentOverDatatablesService.findDepartmentsWithDatatablesCriterias(criterias);
        return DatatablesResponse.build(departments, criterias);
    }

    @RequestMapping(value = "/{id}/delete")
    public @ResponseBody
    String delete(@PathVariable Integer id) {
        departmentService.delete(id);
        return "OK";
    }

}
