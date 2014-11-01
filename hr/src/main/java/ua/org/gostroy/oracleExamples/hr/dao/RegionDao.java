package ua.org.gostroy.oracleExamples.hr.dao;

import ua.org.gostroy.oracleExamples.hr.model.entity.Region;
import ua.org.gostroy.oracleExamples.hr.model.entity.Region;

import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public interface RegionDao {
    Region findById(Integer id);
    List<Region> findAll();
    Region save(Region entity);
    Region update(Region entity);
    void delete(Region entity);
}
