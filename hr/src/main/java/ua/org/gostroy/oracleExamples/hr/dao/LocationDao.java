package ua.org.gostroy.oracleExamples.hr.dao;

import ua.org.gostroy.oracleExamples.hr.model.entity.Location;
import ua.org.gostroy.oracleExamples.hr.model.entity.Location;

import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public interface LocationDao {
    Location findById(Integer id);
    List<Location> findAll();
    Location save(Location entity);
    Location update(Location entity);
    void delete(Location entity);
}
