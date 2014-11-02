package ua.org.gostroy.oracleExamples.hr.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.org.gostroy.oracleExamples.hr.model.entity.Employee;
import ua.org.gostroy.oracleExamples.hr.model.entity.Job;
import ua.org.gostroy.oracleExamples.hr.model.entity.JobHistory;
import ua.org.gostroy.oracleExamples.hr.model.entity.JobHistoryPk;

import java.util.Date;
import java.util.List;

/**
 * Created by Panov Sergey on 11/2/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/ua/org/gostroy/oracleExamples/hr/applicationContext.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class JobHistoryTest {

    JobHistoryPk testJobHistoryId;
    Employee testEmployee;
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    JobHistoryDao jobHistoryDao;

    @Before
    public void setup(){
        Integer testEmployeeId = 102;
//        Integer testEmployeeId = 198;
        testEmployee = employeeDao.findById(testEmployeeId);

        testJobHistoryId = new JobHistoryPk(testEmployee,testEmployee.getHireDate());
    }

    @Test
    public void findById(){
        JobHistory test = jobHistoryDao.findById(testJobHistoryId);
        Assert.assertEquals(testJobHistoryId.getEmployee(), test.getEmployee());
    }

    @Test
    public void findAll(){
        List<JobHistory> countries = jobHistoryDao.findAll();
        Assert.assertNotEquals(countries.size(),0);
    }

    @Test
    public void save(){
        JobHistory test = new JobHistory(testEmployee,new Date(), new Date(),testEmployee.getJob());
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
    @Ignore
    public void delete(){
        JobHistory test = jobHistoryDao.findById(testJobHistoryId);
        Integer sizeBeforeDelete = jobHistoryDao.findAll().size();
        jobHistoryDao.delete(test);
        Integer sizeAfterDelete = jobHistoryDao.findAll().size();
        Assert.assertTrue(sizeBeforeDelete == sizeAfterDelete + 1);
    }
}
