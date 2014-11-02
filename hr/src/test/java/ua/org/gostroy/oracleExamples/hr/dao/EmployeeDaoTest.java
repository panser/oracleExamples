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
import ua.org.gostroy.oracleExamples.hr.model.entity.Employee;

import java.util.Date;
import java.util.List;

/**
 * Created by Panov Sergey on 11/2/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/ua/org/gostroy/oracleExamples/hr/applicationContext.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class EmployeeDaoTest {

    private Integer testEmployeeId = 198;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void findById(){
        Employee test = employeeDao.findById(testEmployeeId);
        Assert.assertEquals(testEmployeeId, test.getId());
    }

    @Test
    public void findAll(){
        List<Employee> countries = employeeDao.findAll();
        Assert.assertNotEquals(countries.size(),0);
    }

    @Test
    public void save(){
        Employee test = new Employee(987654, "TEST", "TEST@GMAIL.COM", new Date());
        Employee testNew = employeeDao.save(test);
        Assert.assertNotNull(testNew.getId());
    }

    @Test
    public void update(){
        Employee test = employeeDao.findById(testEmployeeId);
        test.setFirstName("TEST");
        Employee testNew = employeeDao.update(test);
        Assert.assertEquals(test, testNew);
    }

    @Test
    @Ignore
    public void delete(){
        Employee test = employeeDao.findById(testEmployeeId);
        Integer sizeBeforeDelete = employeeDao.findAll().size();
        employeeDao.delete(test);
        Integer sizeAfterDelete = employeeDao.findAll().size();
        Assert.assertTrue(sizeBeforeDelete == sizeAfterDelete + 1);
    }
}
