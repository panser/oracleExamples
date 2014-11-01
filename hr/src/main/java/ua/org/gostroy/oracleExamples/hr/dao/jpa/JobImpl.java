package ua.org.gostroy.oracleExamples.hr.dao.jpa;

import ua.org.gostroy.oracleExamples.hr.dao.JobDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Job;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public class JobImpl implements JobDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Job findById(String id) {
        return null;
    }

    @Override
    public List<Job> findAll() {
        return null;
    }

    @Override
    public Job save(Job entity) {
        return null;
    }

    @Override
    public Job update(Job entity) {
        return null;
    }

    @Override
    public void delete(Job entity) {

    }
}
