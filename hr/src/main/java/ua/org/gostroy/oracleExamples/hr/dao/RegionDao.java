package ua.org.gostroy.oracleExamples.hr.dao;

import org.springframework.dao.DataIntegrityViolationException;
import ua.org.gostroy.oracleExamples.hr.model.entity.Region;

import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public interface RegionDao {
    Region findById(Integer id);

    List<Region> findAll();

    Region save(Region entity) throws DataIntegrityViolationException;

    Region update(Region entity) throws DataIntegrityViolationException;

    void delete(Region entity) throws DataIntegrityViolationException;
}
