package ua.org.gostroy.oracleExamples.hr.dao;

import ua.org.gostroy.oracleExamples.hr.model.entity.Country;

import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
public interface CountryDao {
    Country findById(String id);
    List<Country> findAll();
    Country save(Country entity);
    Country update(Country entity);
    void delete(Country entity);
}
