package com.java.lesson.restaurant.reservation.dao.impl;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dto.UserDto;
import org.dbunit.DBTestCase;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by User on 24.03.2018.
 *
 * @author Igor Iv.
 */
public class UsersDaoImplTestJUnit extends DBTestCase {

    public UsersDaoImplTestJUnit() throws DaoException {
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

    @Before
    public void setUp() throws Exception {
        IDatabaseTester databaseTester = new JdbcDatabaseTester(System.getProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS),
                System.getProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL),
                System.getProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME),
                System.getProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD));
//        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setSetUpOperation(DatabaseOperation.NONE);
        IDataSet exceptedDataSet = getDataSet();
        databaseTester.setDataSet(exceptedDataSet);
        databaseTester.onSetup();
//        System.out.println("Before");
    }

    @After
    public void tearDown () throws Exception {
//        System.out.println("After");
    }

    @Test(expected = NullPointerException.class)
    public void testGetAll() throws Exception {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        List<UserDto> list = usersDao.getAll();
        assertEquals("Excepted: ", getDataSet().getTable("users").getRowCount(), list.size());
//        System.out.println("test GetAll");
    }

    @Test
    public void testGetById() throws Exception {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        UserDto user = usersDao.getById(1);
        assertEquals("Expected: ", 1, user.getId());
        assertEquals("First Name expected: ", "Named", user.getfName());
        assertEquals("Second Name expected: ", "Sec", user.getsName());
//        System.out.println("test GetById");
    }

    @Test
    public void testGetByLoginAndPassword() throws Exception {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        UserDto user = usersDao.getByLoginAndPassword("oil", "li");
        assertEquals("FirstName expected: ", "Lara", user.getfName());
        assertEquals("SecondName expected: ", "Croft", user.getsName());
//        System.out.println("test GetByIdAndLogin");
    }

//    @Test
//    public void testInsert() throws Exception {
//        UsersDaoImpl usersDao = new UsersDaoImpl();
//        UserDto user = new UserDto();
//        user.setfName("Sunny");
//        user.setsName("Bunny");
//        user.setBirthDate("1988-12-05");
//        user.setLogin("sun");
//        user.setPassword("bun");
//        user.seteMail("mail@s");
//        user.setPhone("345-22-752-55-55");
//        usersDao.insert(user);
//
//        // Compare data
//        QueryDataSet dataSet = new QueryDataSet(getDatabaseTester().getConnection());
//        dataSet.addTable("users");
//        IDataSet addDataSet = new FlatXmlDataSetBuilder().build(new File("src/test/resources/user_data_add.xml"));
//        String[] ignore = {"users_id", "user_birth"};
//        Assertion.assertEqualsIgnoreCols(addDataSet, dataSet, "users", ignore);
//
//        System.out.println("test insert");
//    }
//
//    @Test
//    public void testUpdate() throws Exception {
//        UsersDaoImpl usersDao = new UsersDaoImpl();
//        UserDto user = new UserDto();
//        user.setId(21);
//        user.setfName("Sunny");
//        user.setsName("Bunny");
//        user.setBirthDate("1988-12-05");
//        user.setLogin("sun");
//        user.setPassword("bun");
//        user.seteMail("mail@s");
//        user.setPhone("345-22-752-55-55");
//        usersDao.update(user);
//
//        QueryDataSet dataSet = new QueryDataSet(getDatabaseTester().getConnection());
//        dataSet.addTable("users");
//        IDataSet addDataSet = new FlatXmlDataSetBuilder().build(new File("src/test/resources/user_data_update.xml"));
//        String[] ignore = {"users_id", "user_birth"};
//        Assertion.assertEqualsIgnoreCols(addDataSet, dataSet, "users", ignore);
//
//        System.out.println("test update");
//    }
//
//    @Test
//    public void testDelete() throws Exception {
//        UsersDaoImpl usersDao = new UsersDaoImpl();
//        usersDao.delete(26);
//
//        QueryDataSet dataSet = new QueryDataSet(getDatabaseTester().getConnection());
//        dataSet.addTable("users");
//        IDataSet addDataSet = new FlatXmlDataSetBuilder().build(new File("src/test/resources/user_data_delete.xml"));
//        String[] ignore = {"users_id", "user_birth"};
//        Assertion.assertEqualsIgnoreCols(addDataSet, dataSet, "users", ignore);
//
//        System.out.println("test Delete");
//    }
}


// //   Insert data from users db in .xml
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_reservation_db?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "user1");
//        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
//        QueryDataSet partialDataSet = new QueryDataSet(connection);
//        partialDataSet.addTable("users");
//        FlatXmlDataSet.write(partialDataSet, new FileOutputStream("src/test/resources/user_data_add.xml"));
