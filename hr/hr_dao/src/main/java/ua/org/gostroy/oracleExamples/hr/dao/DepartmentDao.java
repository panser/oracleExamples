package ua.org.gostroy.oracleExamples.hr.dao;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;
import ua.org.gostroy.oracleExamples.hr.model.entity.Employee;
import ua.org.gostroy.oracleExamples.hr.model.entity.Location;

import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public interface DepartmentDao {
    Department findById(Integer id);

    List<Department> findAll();

    Department save(Department entity) throws DataIntegrityViolationException;

    Department update(Department entity) throws DataIntegrityViolationException;

    void delete(Department entity);

    Long getCount();

    List<Department> findWithPaginationAndSortingAndFiltering(Long start, Long size, List<String> sortOrder, String name, String manager, String location);

    Long findCountWithFiltering(String name, String manager, String location);
}
