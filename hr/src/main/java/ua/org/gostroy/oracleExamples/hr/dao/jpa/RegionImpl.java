package ua.org.gostroy.oracleExamples.hr.dao.jpa;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import ua.org.gostroy.oracleExamples.hr.dao.RegionDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Region;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
@Repository
public class RegionImpl implements RegionDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Region findById(Integer id) {
        Region region = em.find(Region.class, id);
        return region;
    }

    @Override
    public List<Region> findAll() {
        Query query = em.createNamedQuery("Region.findAll");
        List regions = (List<Region>) query.getResultList();
        return regions;
    }

    @Override
    public Region save(Region entity) throws DataIntegrityViolationException {
        Region newRegion = em.merge(entity);
        return newRegion;
    }

    @Override
    public Region update(Region entity) throws DataIntegrityViolationException {
        Region newRegion = em.merge(entity);
        return newRegion;
    }

    @Override
    public void delete(Region entity) throws DataIntegrityViolationException {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }
}
