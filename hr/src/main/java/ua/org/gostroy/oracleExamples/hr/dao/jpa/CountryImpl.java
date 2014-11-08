package ua.org.gostroy.oracleExamples.hr.dao.jpa;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import ua.org.gostroy.oracleExamples.hr.dao.CountryDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Country;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
@Repository
public class CountryImpl implements CountryDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Country findById(String id) {
        Country country = em.find(Country.class, id);
        return country;
    }

    @Override
    public List<Country> findAll() {
        Query query = em.createNamedQuery("Country.findAll");
//        Query query = em.createNamedQuery("Country.findAll2");
        List countries = (List<Country>) query.getResultList();
        return countries;
    }

    @Override
    public Country save(Country entity) throws DataIntegrityViolationException {
        Country newCountry = em.merge(entity);
        return newCountry;
    }

    @Override
    public Country update(Country entity) throws DataIntegrityViolationException {
        Country newCountry = em.merge(entity);
        return newCountry;
    }

    @Override
    public void delete(Country entity) throws DataIntegrityViolationException {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    @Override
    public Country findByName(String name) {
        Query query = em.createNamedQuery("Country.findByName");
        query.setParameter("name", name);
        Country country = (Country) query.getSingleResult();
        return country;
    }
}
