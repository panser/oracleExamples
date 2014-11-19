package config;

import org.dbunit.DBTestCase;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.dataset.IDataSet;
import org.dbunit.ext.oracle.OracleDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Panov Sergey on 11/19/2014.
 */
public class DBUnitConfig extends DBTestCase {

    protected IDatabaseTester tester;
    private Properties prop;
    protected IDataSet beforeData;

    @Before
    public void setUp() throws Exception {
        tester = new JdbcDatabaseTester(prop.getProperty("jdbc.driver"),
                prop.getProperty("jdbc.url"),
                prop.getProperty("jdbc.username"),
                prop.getProperty("jdbc.password"),
                prop.getProperty("jdbc.schema"));
//        tester.getConnection().getConfig().setFeature(DatabaseConfig.FEATURE_SKIP_ORACLE_RECYCLEBIN_TABLES, true);
//        tester.getConnection().getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());
//        tester.getConnection().getConfig().setFeature(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, false);
    }

    public DBUnitConfig() {
        super();
        prop = new Properties();
        try {
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config/properties/db_gostroy_oracle.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, prop.getProperty("jdbc.driver"));
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, prop.getProperty("jdbc.url"));
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, prop.getProperty("jdbc.username"));
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, prop.getProperty("jdbc.password"));
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, prop.getProperty("jdbc.schema"));
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return beforeData;
    }

    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception {
        return null;
//        return DatabaseOperation.DELETE_ALL;
    }

}
