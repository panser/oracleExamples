package ua.org.gostroy.oracleExamples.hr.dao;

import ua.org.gostroy.oracleExamples.hr.model.entity.EmpDetailsView;

import java.util.List;

/**
 * Created by Panov Sergey on 11/4/2014.
 */
public interface EmpDetailsViewDao {
    List<EmpDetailsView> findAll();
    List<EmpDetailsView> findByEmployeeId(Integer employeeId);
    List<EmpDetailsView> findByJobId(String jobId);
}
