package ua.org.gostroy.oracleExamples.hr.dao;

import config.DBUnitConfig;
import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import ua.org.gostroy.oracleExamples.hr.model.entity.Country;
import ua.org.gostroy.oracleExamples.hr.model.entity.Region;

import java.util.List;

/**
 * Created by Panov Sergey on 11/1/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/config/applicationContext.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
//@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
//                        TransactionalTestExecutionListener.class,
//                        RollbackTransactionalDataSetTestExecutionListener.class})
//@DataSet
public class CountryDaoTest {
//public class CountryDaoTest extends DBUnitConfig {

    private String testCountryId = "UK";
    private Integer testRegionId = 3;
    private String testCountryName = "United Kingdom";
    @Autowired
    CountryDao countryDao;
    @Autowired
    RegionDao regionDao;

/*
    @Before
    public void setUp() throws Exception {
        super.setUp();
        beforeData = new FlatXmlDataSetBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("ua/org/gostroy/oracleExamples/hr/dao/country-data.xml"));

        tester.setDataSet(beforeData);
        tester.onSetup();
    }
*/

    @Test
    public void findById(){
        Country test = countryDao.findById(testCountryId);
        Assert.assertEquals(testCountryId, test.getId());
    }

    @Test
    public void findAll() throws Exception{
        List<Country> countries = countryDao.findAll();
        Assert.assertNotEquals(countries.size(),0);

/*
        IDataSet expectedData = new FlatXmlDataSetBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("ua/org/gostroy/oracleExamples/hr/dao/country-data.xml"));
        IDataSet actualData = tester.getConnection().createDataSet();
        Assertion.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData.getTable("person").getRowCount(), countries.size());
*/
    }

    @Test
    public void save(){
        Country test = new Country("TE");
        Country testNew = countryDao.save(test);
        Assert.assertNotNull(testNew.getId());
    }

    @Test
    public void update(){
        Country test = countryDao.findById(testCountryId);
        test.setName("TEST");
        Country testNew = countryDao.update(test);
        Assert.assertEquals(test, testNew);
    }

    @Test
    public void delete(){
        Country test = countryDao.findById(testCountryId);
        Integer sizeBeforeDelete = countryDao.findAll().size();
        countryDao.delete(test);
        Integer sizeAfterDelete = countryDao.findAll().size();
        Assert.assertTrue(sizeBeforeDelete == sizeAfterDelete + 1);
    }

    @Test
    public void findByName(){
        Country test = countryDao.findByName(testCountryName);
        Assert.assertEquals(testCountryName, test.getName());
    }

    @Test
    //it show that bi-direction links don't auto update
    public void biDirectionList(){
        Country testCountry = countryDao.findById(testCountryId);
        Region testRegion = regionDao.findById(testRegionId);
        Assert.assertNotEquals(testCountry.getRegion().getId(), testRegion.getId());

        int countriesInRegion = testRegion.getCountries().size();
        testCountry.setRegion(testRegion);
        int countriesInRegionNew = testRegion.getCountries().size();
        Assert.assertEquals(countriesInRegion, countriesInRegionNew);
    }


}
