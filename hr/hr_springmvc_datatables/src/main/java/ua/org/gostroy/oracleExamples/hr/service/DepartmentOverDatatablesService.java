package ua.org.gostroy.oracleExamples.hr.service;

import com.github.dandelion.datatables.core.ajax.DataSet;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.gostroy.oracleExamples.hr.dao.DepartmentOverDatatablesDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;

import java.util.List;

/**
 * Created by Panov Sergey on 11/8/2014.
 */
@Service
@Transactional
public class DepartmentOverDatatablesService {

    @Autowired
    DepartmentOverDatatablesDao departmentOverDatatablesDao;

    public List<Department> findAll() {
        return departmentOverDatatablesDao.findAll();
    }

    public List<Department> findLimited(int maxResult) {
        return departmentOverDatatablesDao.findLimited(maxResult);
    }

    public DataSet<Department> findDepartmentsWithDatatablesCriterias(DatatablesCriterias criterias) {

        List<Department> persons = departmentOverDatatablesDao.findDepartmentWithDatatablesCriterias(criterias);
        Long count = departmentOverDatatablesDao.getTotalCount();
        Long countFiltered = departmentOverDatatablesDao.getFilteredCount(criterias);

        return new DataSet<Department>(persons, count, countFiltered);
    }

}
