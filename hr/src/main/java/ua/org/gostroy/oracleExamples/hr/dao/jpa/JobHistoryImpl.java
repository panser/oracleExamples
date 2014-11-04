package ua.org.gostroy.oracleExamples.hr.dao.jpa;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import ua.org.gostroy.oracleExamples.hr.dao.JobHistoryDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.EmpDetailsView;
import ua.org.gostroy.oracleExamples.hr.model.entity.JobHistory;
import ua.org.gostroy.oracleExamples.hr.model.entity.JobHistory;
import ua.org.gostroy.oracleExamples.hr.model.entity.JobHistoryPk;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
@Repository
public class JobHistoryImpl implements JobHistoryDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public JobHistory findById(JobHistoryPk id) {
        JobHistory jobHistory = em.find(JobHistory.class, id);
        return jobHistory;
    }

    @Override
    public List<JobHistory> findAll() {
        Query query = em.createNamedQuery("JobHistory.findAll");
        List jobHistories = (List<JobHistory>) query.getResultList();
        return jobHistories;
    }

    @Override
    public JobHistory save(JobHistory entity) throws DataIntegrityViolationException {
        JobHistory newJobHistory = em.merge(entity);
        return newJobHistory;
    }

    @Override
    public JobHistory update(JobHistory entity) throws DataIntegrityViolationException {
        JobHistory newJobHistory = em.merge(entity);
        return newJobHistory;
    }

    @Override
    public void delete(JobHistory entity) throws DataIntegrityViolationException {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Override
    public JobHistory findByEmployeeId(Integer employeeId) {
        Query query = em.createNamedQuery("JobHistory.findByEmployeeId");
        query.setParameter("employeeId", employeeId);
        JobHistory jobHistory = (JobHistory)query.getSingleResult();
        return jobHistory;
    }

    @Override
    public JobHistory findByStartDate(Date startDate) {
        Query query = em.createNamedQuery("JobHistory.findByStartDate");
        query.setParameter("startDate", startDate);
        JobHistory jobHistory = (JobHistory)query.getSingleResult();
        return jobHistory;
    }

}
