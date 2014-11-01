package ua.org.gostroy.oracleExamples.hr.dao;

import ua.org.gostroy.oracleExamples.hr.model.entity.JobHistory;
import ua.org.gostroy.oracleExamples.hr.model.entity.JobHistory;
import ua.org.gostroy.oracleExamples.hr.model.entity.JobHistoryPk;

import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public interface JobHistoryDao {
    JobHistory findById(JobHistoryPk id);
    List<JobHistory> findAll();
    JobHistory save(JobHistory entity);
    JobHistory update(JobHistory entity);
    void delete(JobHistory entity);
}
