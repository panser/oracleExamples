package ua.org.gostroy.oracleExamples.hr.dao.jpa;

import ua.org.gostroy.oracleExamples.hr.dao.RegionDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Region;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public class RegionImpl implements RegionDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Region findById(Integer id) {
        return null;
    }

    @Override
    public List<Region> findAll() {
        return null;
    }

    @Override
    public Region save(Region entity) {
        return null;
    }

    @Override
    public Region update(Region entity) {
        return null;
    }

    @Override
    public void delete(Region entity) {

    }
}
