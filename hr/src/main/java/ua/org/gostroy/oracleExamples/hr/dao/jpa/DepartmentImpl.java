package ua.org.gostroy.oracleExamples.hr.dao.jpa;

import ua.org.gostroy.oracleExamples.hr.dao.DepartmentDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Country;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public class DepartmentImpl implements DepartmentDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Country findById(Integer id) {
        return null;
    }

    @Override
    public List<Country> findAll() {
        return null;
    }

    @Override
    public Country save(Country entity) {
        return null;
    }

    @Override
    public Country update(Country entity) {
        return null;
    }

    @Override
    public void delete(Country entity) {

    }
}
