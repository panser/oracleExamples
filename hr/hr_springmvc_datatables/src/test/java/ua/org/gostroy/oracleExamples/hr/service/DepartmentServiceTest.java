package ua.org.gostroy.oracleExamples.hr.service;

import org.junit.Assert;
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
 * Created by Panov Sergey on 11/4/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/config/applicationContext.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class DepartmentServiceTest {

    private Integer testDepartmentId = 40;
    @Autowired
    DepartmentService departmentService;

    @Test
    public void notNull(){
        Assert.assertNotNull(departmentService);
    }

    @Test
    public void findById(){
        Department test = departmentService.findById(testDepartmentId);
        Assert.assertEquals(testDepartmentId, test.getId());
    }

    @Test
    public void findAll(){
        List<Department> countries = departmentService.findAll();
        Assert.assertNotEquals(countries.size(), 0);
    }

    @Test
    public void save(){
        Department test = new Department("TEST");
        Department testNew = departmentService.save(test);
        Assert.assertNotNull(testNew.getId());
    }

    @Test
    public void update(){
        Department test = departmentService.findById(testDepartmentId);
        test.setName("TEST");
        Department testNew = departmentService.update(test);
        Assert.assertEquals(test, testNew);
    }

    @Test
    public void delete(){
        Department test = departmentService.findById(testDepartmentId);
        Integer sizeBeforeDelete = departmentService.findAll().size();
        departmentService.delete(test);
        Integer sizeAfterDelete = departmentService.findAll().size();
        Assert.assertTrue(sizeBeforeDelete == sizeAfterDelete + 1);
    }

}
