package ua.org.gostroy.oracleExamples.hr.dao.jpa;

import ua.org.gostroy.oracleExamples.hr.dao.LocationDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Location;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public class LocationImpl implements LocationDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Location findById(Integer id) {
        return null;
    }

    @Override
    public List<Location> findAll() {
        return null;
    }

    @Override
    public Location save(Location entity) {
        return null;
    }

    @Override
    public Location update(Location entity) {
        return null;
    }

    @Override
    public void delete(Location entity) {

    }
}
