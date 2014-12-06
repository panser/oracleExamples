package ua.org.gostroy.oracleExamples.hr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.gostroy.oracleExamples.hr.dao.LocationDao;
import ua.org.gostroy.oracleExamples.hr.dao.LocationDao;
import ua.org.gostroy.oracleExamples.hr.model.entity.Location;

import java.util.List;

/**
 * Created by Panov Sergey on 12/6/2014.
 */
@Service
@Transactional
public class LocationService {

    @Autowired
    LocationDao locationDao;

    @Transactional(readOnly = true)
    public Location findById(Integer id) {
        Location result = locationDao.findById(id);
        return result;
    }

    @Transactional(readOnly = true)
    public List<Location> findAll() {
        List<Location> result = locationDao.findAll();
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public Location save(Location entity) throws DataIntegrityViolationException {
        Location result = locationDao.save(entity);
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public Location update(Location entity) throws DataIntegrityViolationException {
        Location result = locationDao.update(entity);
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Location entity) {
        locationDao.delete(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        Location entity = findById(id);
        locationDao.delete(entity);
    }

}
