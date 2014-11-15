package ua.org.gostroy.oracleExamples.hr.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.org.gostroy.oracleExamples.hr.model.entity.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Panov Sergey on 11/2/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/config/applicationContext.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class JobHistoryTest {

    Integer testEmployeeId = 102;
    Employee testEmployee;
    JobHistoryPk testJobHistoryId;
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    JobHistoryDao jobHistoryDao;

    @Before
    public void setup(){
        testEmployee = employeeDao.findById(testEmployeeId);
        testJobHistoryId = new JobHistoryPk(testEmployeeId,testEmployee.getHireDate());
    }

    @Test
    public void findById(){
        JobHistory test = jobHistoryDao.findById(testJobHistoryId);
        Assert.assertEquals(testJobHistoryId.getEmployeeId(), test.getEmployee().getId());
    }

    @Test
    public void findAll(){
        List<JobHistory> countries = jobHistoryDao.findAll();
        Assert.assertNotEquals(countries.size(),0);
    }

    @Test
    public void save(){
        JobHistoryPk jobHistoryPk = new JobHistoryPk(testEmployeeId, new Date());
        JobHistory test = new JobHistory(jobHistoryPk, testEmployee, new Date(),testEmployee.getJob());
        JobHistory testNew = jobHistoryDao.save(test);
        Assert.assertNotNull(testNew.getEmployee());
    }

    @Test
    public void update(){
        JobHistory test = jobHistoryDao.findById(testJobHistoryId);
        test.setEndDate(new Date());
        JobHistory testNew = jobHistoryDao.update(test);
        Assert.assertEquals(test, testNew);
    }

    @Test
    public void delete(){
        JobHistory test = jobHistoryDao.findById(testJobHistoryId);
        Integer sizeBeforeDelete = jobHistoryDao.findAll().size();
        jobHistoryDao.delete(test);
        Integer sizeAfterDelete = jobHistoryDao.findAll().size();
        Assert.assertTrue(sizeBeforeDelete == sizeAfterDelete + 1);
    }

    @Test
    public void findByEmployeeId(){
        JobHistory jobHistory = jobHistoryDao.findByEmployeeId(testEmployeeId);
        Assert.assertEquals(jobHistory.getJobHistoryPK().getEmployeeId(), testEmployeeId);
    }

    @Test
    public void findByStartDate(){
        JobHistory jobHistory = jobHistoryDao.findByStartDate(testJobHistoryId.getStartDate());
        Assert.assertEquals(jobHistory.getJobHistoryPK().getStartDate(), testJobHistoryId.getStartDate());
    }
}
