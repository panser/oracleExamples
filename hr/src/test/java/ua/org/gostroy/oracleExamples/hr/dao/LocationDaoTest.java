package ua.org.gostroy.oracleExamples.hr.dao;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.org.gostroy.oracleExamples.hr.model.entity.Location;

import java.util.List;

/**
 * Created by Panov Sergey on 11/2/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/ua/org/gostroy/oracleExamples/hr/applicationContext.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class LocationDaoTest {

    private Integer testLocationId = 1000;
    @Autowired
    LocationDao locationDao;

    @Test
    public void findById(){
        Location test = locationDao.findById(testLocationId);
        Assert.assertEquals(testLocationId, test.getId());
    }

    @Test
    public void findAll(){
        List<Location> countries = locationDao.findAll();
        Assert.assertNotEquals(countries.size(),0);
    }

    @Test
    public void save(){
        Location test = new Location(987654, "TEST");
        Location testNew = locationDao.save(test);
        Assert.assertNotNull(testNew.getId());
    }

    @Test
    public void update(){
        Location test = locationDao.findById(testLocationId);
        test.setCity("TEST2");
        Location testNew = locationDao.update(test);
        Assert.assertEquals(test, testNew);
    }

    @Test
    @Ignore
    public void delete(){
        Location test = locationDao.findById(testLocationId);
        Integer sizeBeforeDelete = locationDao.findAll().size();
        locationDao.delete(test);
        Integer sizeAfterDelete = locationDao.findAll().size();
        Assert.assertTrue(sizeBeforeDelete == sizeAfterDelete + 1);
    }
}
