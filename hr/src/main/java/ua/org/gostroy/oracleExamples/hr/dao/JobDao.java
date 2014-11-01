package ua.org.gostroy.oracleExamples.hr.dao;

import ua.org.gostroy.oracleExamples.hr.model.entity.Job;

import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public interface JobDao {
    Job findById(String id);
    List<Job> findAll();
    Job save(Job entity);
    Job update(Job entity);
    void delete(Job entity);
}
