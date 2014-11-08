package ua.org.gostroy.oracleExamples.hr.dao;

import org.springframework.dao.DataIntegrityViolationException;
import ua.org.gostroy.oracleExamples.hr.model.entity.Job;

import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public interface JobDao {
    Job findById(String id);

    List<Job> findAll();

    Job save(Job entity) throws DataIntegrityViolationException;

    Job update(Job entity) throws DataIntegrityViolationException;

    void delete(Job entity) throws DataIntegrityViolationException;
}
