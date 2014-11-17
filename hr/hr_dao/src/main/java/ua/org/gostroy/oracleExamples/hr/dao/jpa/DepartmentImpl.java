package ua.org.gostroy.oracleExamples.hr.dao.jpa;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import ua.org.gostroy.oracleExamples.hr.dao.DepartmentDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
@Repository(value = "departmentDao")
public class DepartmentImpl implements DepartmentDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Department findById(Integer id) {
        Department department = em.find(Department.class, id);
        return department;
    }

    @Override
    public List<Department> findAll() {
        Query query = em.createNamedQuery("Department.findAll");
        List departments = (List<Department>) query.getResultList();
        return departments;
    }

    @Override
    public Department save(Department entity) throws DataIntegrityViolationException {
        Department newDepartment = em.merge(entity);
        return newDepartment;
    }

    @Override
    public Department update(Department entity) throws DataIntegrityViolationException {
        Department newDepartment = em.merge(entity);
        return newDepartment;
    }

    @Override
    public void delete(Department entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }
}
