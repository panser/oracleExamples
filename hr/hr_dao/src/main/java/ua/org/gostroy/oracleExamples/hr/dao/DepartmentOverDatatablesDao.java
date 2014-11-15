package ua.org.gostroy.oracleExamples.hr.dao;

import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;

import java.util.List;

/**
 * Created by Panov Sergey on 11/8/2014.
 */
public interface DepartmentOverDatatablesDao {

    public List<Department> findAll();

    public List<Department> findLimited(int maxResult);

    public List<Department> findDepartmentWithDatatablesCriterias(DatatablesCriterias criterias);

    public Long getFilteredCount(DatatablesCriterias criterias);

    public Long getTotalCount();

}
