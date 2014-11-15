package ua.org.gostroy.oracleExamples.hr;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 * Created by Panov Sergey on 10/31/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/config/applicationContext.xml")
public class ContextTest {

    @Autowired
    DataSource dataSource;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void testDataSourceContext(){
        Assert.assertNotNull(dataSource);
    }

    @Test
    public void testEntityManager(){
        Assert.assertNotNull(em);
    }

}
