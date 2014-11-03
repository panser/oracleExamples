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
import ua.org.gostroy.oracleExamples.hr.model.entity.Region;

import java.util.List;

/**
 * Created by Panov Sergey on 11/2/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/ua/org/gostroy/oracleExamples/hr/applicationContext.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class RegionDaoTest {

    private Integer testRegionId = 1;
    @Autowired
    RegionDao regionDao;

    @Test
    public void findById(){
        Region test = regionDao.findById(testRegionId);
        Assert.assertEquals(testRegionId, test.getId());
    }

    @Test
    public void findAll(){
        List<Region> countries = regionDao.findAll();
        Assert.assertNotEquals(countries.size(),0);
    }

    @Test
    public void save(){
        Region test = new Region(10);
        Region testNew = regionDao.save(test);
        Assert.assertNotNull(testNew.getId());
    }

    @Test
    public void update(){
        Region test = regionDao.findById(testRegionId);
        test.setName("TEST");
        Region testNew = regionDao.update(test);
        Assert.assertEquals(test, testNew);
    }

    @Test
    public void delete(){
        Region test = regionDao.findById(testRegionId);
        Integer sizeBeforeDelete = regionDao.findAll().size();
        regionDao.delete(test);
        Integer sizeAfterDelete = regionDao.findAll().size();
        Assert.assertTrue(sizeBeforeDelete == sizeAfterDelete + 1);
    }
}
