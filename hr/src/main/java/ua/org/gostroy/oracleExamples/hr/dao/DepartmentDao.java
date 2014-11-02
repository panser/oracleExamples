package ua.org.gostroy.oracleExamples.hr.dao;

import org.springframework.dao.DataIntegrityViolationException;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;

import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public interface DepartmentDao {
    Department findById(Integer id);
    List<Department> findAll();
    Department save(Department entity) throws DataIntegrityViolationException;
    Department update(Department entity) throws DataIntegrityViolationException;
    void delete(Department entity) throws DataIntegrityViolationException;
}
