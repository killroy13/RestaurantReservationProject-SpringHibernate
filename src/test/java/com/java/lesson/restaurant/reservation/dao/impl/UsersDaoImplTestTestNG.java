package com.java.lesson.restaurant.reservation.dao.impl;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dto.User;
import org.dbunit.*;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by User on 28.03.2018.
 *
 * @author Igor Iv.
 */
public class UsersDaoImplTestTestNG extends DBTestCase {

    public UsersDaoImplTestTestNG() throws DaoException {
        setProperties();
    }

    private void setProperties() throws DaoException {
        Properties property = new Properties();
        try (InputStream in = this.getClass().getClassLoader().getResourceAsStream("test_config.properties")) {
            property.load(in);
            System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, property.getProperty("DRIVER"));
            System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, property.getProperty("URL"));
            System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, property.getProperty("USER"));
            System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, property.getProperty("PASSWORD"));
        } catch (IOException e) {
            throw new DaoException("Properties file not found ", e);
        }
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new File("src/test/resources/all_tables_dataset.xml"));
    }

    @BeforeMethod
    public void setUp() throws Exception {
        IDatabaseTester databaseTester = new JdbcDatabaseTester(System.getProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS),
                System.getProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL),
                System.getProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME),
                System.getProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD));
        databaseTester.setSetUpOperation(DatabaseOperation.NONE);
        IDataSet exceptedDataSet = getDataSet();
        databaseTester.setDataSet(exceptedDataSet);
        databaseTester.onSetup();
//        System.out.println("BeforeMethod");
    }

    @Test(groups = {"get"})
    public void testGetAll() throws Exception {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        List<User> list = usersDao.getAll();
        assertEquals("Excepted: ", getDataSet().getTable("users").getRowCount(), list.size());
//        System.out.println("test GetAll");
    }

    @Test(groups = {"get"}, dependsOnMethods = "testGetAll")
    public void testGetById() throws Exception {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        User user = usersDao.getById(1);
        assertEquals("Expected: ", 1, user.getId());
        assertEquals("First Name expected: ", "Dav", user.getfName());
        assertEquals("Second Name expected: ", "Peterson", user.getsName());
//        System.out.println("test GetById");
    }

    @Test(groups = {"get"}, dependsOnMethods = "testGetById")
    public void testGetByLoginAndPassword() throws Exception {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        User user = usersDao.getByLoginAndPassword("qwe", "wer");
        assertEquals("FirstName expected: ", "Tom", user.getfName());
        assertEquals("SecondName expected: ", "Tester", user.getsName());
//        System.out.println("test GetByIdAndLogin");
    }

    @Test(groups = {"crud"}, dependsOnMethods = "testGetByLoginAndPassword")
    public void testUpdate() throws Exception {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        User user = new User();
        user.setId(5);
        user.setfName("Lara");
        user.setsName("Test");
        user.setBirthDate("2018-03-14");
        user.setLogin("edf");
        user.setPassword("wer");
        user.seteMail("wer");
        user.setPhone("12");
        usersDao.update(user);
        // Compare data
        QueryDataSet dataSet = new QueryDataSet(getDatabaseTester().getConnection());
        dataSet.addTable("users");
        IDataSet addDataSet = new FlatXmlDataSetBuilder().build(new File("src/test/resources/user_data_update.xml"));
        String[] ignore = {"users_id", "user_birth"};
        Assertion.assertEqualsIgnoreCols(addDataSet, dataSet, "users", ignore);
//        System.out.println("test Update");
    }

    @Test(groups = {"crud"}, dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        usersDao.delete(5);
        QueryDataSet dataSet = new QueryDataSet(getDatabaseTester().getConnection());
        dataSet.addTable("users");
        IDataSet addDataSet = new FlatXmlDataSetBuilder().build(new File("src/test/resources/user_data_delete.xml"));
        String[] ignore = {"users_id", "user_birth"};
        Assertion.assertEqualsIgnoreCols(addDataSet, dataSet, "users", ignore);
//        System.out.println("test Delete");
    }


    @Test(groups = {"crud"}, dependsOnMethods = "testDelete")
    public void testInsert() throws Exception {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        User user = new User();
        user.setfName("Sunny");
        user.setsName("Bunny");
        user.setBirthDate("1988-12-05");
        user.setLogin("sun");
        user.setPassword("bun");
        user.seteMail("mail@s");
        user.setPhone("345-22-752-55-55");
        usersDao.insert(user);
        QueryDataSet dataSet = new QueryDataSet(getDatabaseTester().getConnection());
        dataSet.addTable("users");
        IDataSet addDataSet = new FlatXmlDataSetBuilder().build(new File("src/test/resources/user_data_add.xml"));
        String[] ignore = {"users_id", "user_birth"};
        Assertion.assertEqualsIgnoreCols(addDataSet, dataSet, "users", ignore);
//        System.out.println("test Insert");
    }
}







