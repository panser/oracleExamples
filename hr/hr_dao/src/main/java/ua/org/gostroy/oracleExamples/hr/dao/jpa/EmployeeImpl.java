package ua.org.gostroy.oracleExamples.hr.dao.jpa;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import ua.org.gostroy.oracleExamples.hr.dao.EmployeeDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
@Repository(value = "employeeDao")
public class EmployeeImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Employee findById(Integer id) {
        Employee employee = em.find(Employee.class, id);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        Query query = em.createNamedQuery("Employee.findAll");
        List employees = (List<Employee>) query.getResultList();
        return employees;
    }

    @Override
    public Employee save(Employee entity) throws DataIntegrityViolationException {
        Employee newEmployee = em.merge(entity);
        return newEmployee;
    }

    @Override
    public Employee update(Employee entity) throws DataIntegrityViolationException {
        Employee newEmployee = em.merge(entity);
        return newEmployee;
    }

    @Override
    public void delete(Employee entity) throws DataIntegrityViolationException {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }
}
