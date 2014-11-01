package ua.org.gostroy.oracleExamples.hr.dao.jpa;

import ua.org.gostroy.oracleExamples.hr.dao.JobHistoryDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.JobHistory;
import ua.org.gostroy.oracleExamples.hr.model.entity.JobHistoryPk;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public class JobHistoryImpl implements JobHistoryDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public JobHistory findById(JobHistoryPk id) {
        return null;
    }

    @Override
    public List<JobHistory> findAll() {
        return null;
    }

    @Override
    public JobHistory save(JobHistory entity) {
        return null;
    }

    @Override
    public JobHistory update(JobHistory entity) {
        return null;
    }

    @Override
    public void delete(JobHistory entity) {

    }
}
