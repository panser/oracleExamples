package ua.org.gostroy.oracleExamples.hr.dao.jpa;

import ua.org.gostroy.oracleExamples.hr.dao.EmployeeDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public class EmployeeImpl implements EmployeeDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Employee findById(Integer id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public Employee save(Employee entity) {
        return null;
    }

    @Override
    public Employee update(Employee entity) {
        return null;
    }

    @Override
    public void delete(Employee entity) {

    }
}
