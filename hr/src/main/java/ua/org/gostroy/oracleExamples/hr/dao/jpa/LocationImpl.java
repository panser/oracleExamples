package ua.org.gostroy.oracleExamples.hr.dao.jpa;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import ua.org.gostroy.oracleExamples.hr.dao.LocationDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Location;
import ua.org.gostroy.oracleExamples.hr.model.entity.Location;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
@Repository
public class LocationImpl implements LocationDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Location findById(Integer id) {
        Location location = em.find(Location.class, id);
        return location;
    }

    @Override
    public List<Location> findAll() {
        Query query = em.createQuery("SELECT e FROM LOCATIONS e");
//        Query query = em.createQuery("SELECT e FROM Location e");
        List locations = (List<Location>) query.getResultList();
        return locations;
    }

    @Override
    public Location save(Location entity) throws DataIntegrityViolationException {
        Location newLocation = em.merge(entity);
        return newLocation;
    }

    @Override
    public Location update(Location entity) throws DataIntegrityViolationException {
        Location newLocation = em.merge(entity);
        return newLocation;
    }

    @Override
    public void delete(Location entity) throws DataIntegrityViolationException {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }
}
