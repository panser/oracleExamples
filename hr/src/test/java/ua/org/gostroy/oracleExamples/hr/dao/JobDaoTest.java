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
import ua.org.gostroy.oracleExamples.hr.model.entity.Job;

import java.util.List;

/**
 * Created by Panov Sergey on 11/2/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/ua/org/gostroy/oracleExamples/hr/applicationContext.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class JobDaoTest {

    private String testJobId = "IT_PROG";
    @Autowired
    JobDao jobDao;

    @Test
    public void findById(){
        Job test = jobDao.findById(testJobId);
        Assert.assertEquals(testJobId, test.getId());
    }

    @Test
    public void findAll(){
        List<Job> countries = jobDao.findAll();
        Assert.assertNotEquals(countries.size(),0);
    }

    @Test
    public void save(){
        Job test = new Job("TEST");
        Job testNew = jobDao.save(test);
        Assert.assertNotNull(testNew.getId());
    }

    @Test
    public void update(){
        Job test = jobDao.findById(testJobId);
        test.setTitle("TEST");
        Job testNew = jobDao.update(test);
        Assert.assertEquals(test, testNew);
    }

    @Test
    public void delete(){
        Job test = jobDao.findById(testJobId);
        Integer sizeBeforeDelete = jobDao.findAll().size();
        jobDao.delete(test);
        Integer sizeAfterDelete = jobDao.findAll().size();
        Assert.assertTrue(sizeBeforeDelete == sizeAfterDelete + 1);
    }
}
