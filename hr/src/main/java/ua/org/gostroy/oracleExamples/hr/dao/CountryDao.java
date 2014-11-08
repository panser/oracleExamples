package ua.org.gostroy.oracleExamples.hr.dao;

import org.springframework.dao.DataIntegrityViolationException;
import ua.org.gostroy.oracleExamples.hr.model.entity.Country;

import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public interface CountryDao {
    Country findById(String id);

    List<Country> findAll();

    Country save(Country entity) throws DataIntegrityViolationException;

    Country update(Country entity) throws DataIntegrityViolationException;

    void delete(Country entity) throws DataIntegrityViolationException;

    Country findByName(String name);
}
