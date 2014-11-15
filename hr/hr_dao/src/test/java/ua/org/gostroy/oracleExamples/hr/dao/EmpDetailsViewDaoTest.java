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
import ua.org.gostroy.oracleExamples.hr.model.entity.EmpDetailsView;

import java.util.List;

/**
 * Created by Panov Sergey on 11/4/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/config/applicationContext.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class EmpDetailsViewDaoTest {

    Integer employeeId = 100;
    String jobId = "IT_PROG";
    @Autowired
    EmpDetailsViewDao empDetailsViewDao;

    @Test
    public void findAll(){
        List<EmpDetailsView> empDetailsViewList = empDetailsViewDao.findAll();
        Assert.assertNotEquals(empDetailsViewList.size(), 0);
    }

    @Test
    @Ignore
    public void findByEmployeeId(){
        List<EmpDetailsView> empDetailsView = empDetailsViewDao.findByEmployeeId(employeeId);
        Assert.assertEquals(empDetailsView.get(0).getEmpDetailsViewId().getEmployeeId(), employeeId);
    }

    @Test
    @Ignore
    public void findByJobId(){
        List<EmpDetailsView> empDetailsView = empDetailsViewDao.findByJobId(jobId);
        Assert.assertEquals(empDetailsView.get(0).getEmpDetailsViewId().getJobId(), jobId);
    }

}
