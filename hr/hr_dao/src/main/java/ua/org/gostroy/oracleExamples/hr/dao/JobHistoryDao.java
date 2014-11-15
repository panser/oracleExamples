package ua.org.gostroy.oracleExamples.hr.dao;

import org.springframework.dao.DataIntegrityViolationException;
import ua.org.gostroy.oracleExamples.hr.model.entity.JobHistory;
import ua.org.gostroy.oracleExamples.hr.model.entity.JobHistoryPk;

import java.util.Date;
import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public interface JobHistoryDao {
    JobHistory findById(JobHistoryPk id);

    List<JobHistory> findAll();

    JobHistory save(JobHistory entity) throws DataIntegrityViolationException;

    JobHistory update(JobHistory entity) throws DataIntegrityViolationException;

    void delete(JobHistory entity) throws DataIntegrityViolationException;

    JobHistory findByEmployeeId(Integer employeeId);

    JobHistory findByStartDate(Date startDate);
}
