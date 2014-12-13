package ua.org.gostroy.oracleExamples.hr.dao.jpa;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import ua.org.gostroy.oracleExamples.hr.dao.DepartmentDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;
import ua.org.gostroy.oracleExamples.hr.model.entity.Employee;
import ua.org.gostroy.oracleExamples.hr.model.entity.Location;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    @Override
    public Long getCount() {
        Query query = em.createNamedQuery("Department.count");
        Long count = (Long)query.getSingleResult();
        return count;
    }

    @Override
    public List<Department> findWithPaginationAndSortingAndFiltering(Long start, Long size, List<String> sortOrder, String name, String manager, String location) {
        StringBuilder queryString = new StringBuilder("select o from Department o");
        queryString.append(" where 1=1");
        if(name != null) queryString.append(" and LOWER(o.name) like :name");
        if(manager != null) queryString.append(" and (LOWER(o.manager.lastName) like :manager OR LOWER(o.manager.firstName) like :manager)");
        if(location != null) queryString.append(" and LOWER(o.location.city) like :location");

        if(sortOrder.size() != 0){
            queryString.append(" ORDER BY");
            for(String order : sortOrder){
                queryString.append(" ").append("o.").append(order).append(",");
            }
            queryString.deleteCharAt(queryString.length() - 1);
        }

        Query query = em.createQuery(queryString.toString());
        if(name != null) query.setParameter("name",'%' + name.toLowerCase() + '%');
        if(manager != null) query.setParameter("manager",'%' + manager.toLowerCase() + '%');
        if(location != null) query.setParameter("location",'%' + location.toLowerCase() + '%');

        if(start < Integer.MAX_VALUE && size < Integer.MAX_VALUE) {
            query.setFirstResult(Integer.parseInt(start.toString()));
            query.setMaxResults(Integer.parseInt(size.toString()));
        }
        List departments = (List<Department>) query.getResultList();
        return departments;
    }
}
