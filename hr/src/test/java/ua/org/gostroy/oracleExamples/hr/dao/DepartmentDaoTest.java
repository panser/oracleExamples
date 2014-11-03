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
import ua.org.gostroy.oracleExamples.hr.model.entity.Department;

import java.util.List;

/**
 * Created by Panov Sergey on 11/2/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/ua/org/gostroy/oracleExamples/hr/applicationContext.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class DepartmentDaoTest {

    private Integer testDepartmentId = 10;
    @Autowired
    DepartmentDao departmentDao;

    @Test
    public void findById(){
        Department test = departmentDao.findById(testDepartmentId);
        Assert.assertEquals(testDepartmentId, test.getId());
    }

    @Test
    public void findAll(){
        List<Department> countries = departmentDao.findAll();
        Assert.assertNotEquals(countries.size(),0);
    }

    @Test
    public void save(){
        Department test = new Department("TEST");
        Department testNew = departmentDao.save(test);
        Assert.assertNotNull(testNew.getId());
    }

    @Test
    public void update(){
        Department test = departmentDao.findById(testDepartmentId);
        test.setName("TEST");
        Department testNew = departmentDao.update(test);
        Assert.assertEquals(test, testNew);
    }

    @Test
    @Ignore
    public void delete(){
        Department test = departmentDao.findById(testDepartmentId);
        Integer sizeBeforeDelete = departmentDao.findAll().size();
        departmentDao.delete(test);
        Integer sizeAfterDelete = departmentDao.findAll().size();
        Assert.assertTrue(sizeBeforeDelete == sizeAfterDelete + 1);
    }
}
