package ua.org.gostroy.oracleExamples.hr.dao.jpa;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import ua.org.gostroy.oracleExamples.hr.dao.JobDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Job;
import ua.org.gostroy.oracleExamples.hr.model.entity.Job;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
@Repository
public class JobImpl implements JobDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Job findById(String id) {
        Job job = em.find(Job.class, id);
        return job;
    }

    @Override
    public List<Job> findAll() {
        Query query = em.createQuery("SELECT e FROM JOBS e");
//        Query query = em.createQuery("SELECT e FROM Job e");
        List jobs = (List<Job>) query.getResultList();
        return jobs;
    }

    @Override
    public Job save(Job entity) throws DataIntegrityViolationException {
        Job newJob = em.merge(entity);
        return newJob;
    }

    @Override
    public Job update(Job entity) throws DataIntegrityViolationException {
        Job newJob = em.merge(entity);
        return newJob;
    }

    @Override
    public void delete(Job entity) throws DataIntegrityViolationException {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }
}
