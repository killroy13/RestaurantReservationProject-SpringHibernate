package com.java.lesson.restaurant.reservation.dao;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * Created by UserDto on 02.03.2018.
 * @author Igor Iv.
 */
public abstract class AbstractMySQLDao<T> {

    private Map<String, PreparedStatement> preparedStatements = new HashMap<>();

    protected Connection connection;

    protected abstract String selectQuery();

    protected abstract String selectByIdQuery();

    /***/
//    protected abstract String selectByLoginQueryAndPassword();

    protected abstract String insertQuery();

    protected abstract String updateQuery();

    protected abstract String deleteQuery();

    protected abstract List<T> parseResultSet(ResultSet rs) throws DaoException;

    protected abstract void preparedStatementForSelectById(PreparedStatement ps, int id) throws SQLException;

    /***/
//    protected abstract void preparedStatementForSelectByLoginAndPassword(PreparedStatement ps, String login, String password) throws SQLException;

    protected abstract void preparedStatementForInsert(PreparedStatement ps, T t) throws SQLException;

    protected abstract void preparedStatementForUpdate(PreparedStatement ps, T t) throws SQLException;


//    Properties property = new Properties();
//    try (FileInputStream file = new FileInputStream("src/com/java/lesson/prim10/mySqlDB/config.properties")) {
//        property.load(file);
//    } catch (IOException e) {
//        System.err.println(e);
//    }
//    String URL =
//            property.getProperty("URL");
//    String USER = property.getProperty("USER");
//    String PASSWORD = property.getProperty("PASSWORD");
//    Connection connection = null;
//    try {
//        connection = DriverManager.getConnection(URL, USER, PASSWORD);
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//    return connection;
//}
//}



    public Connection getConnection() throws DaoException {
        Properties property = new Properties();
        try (InputStream in = /*Main.class*/getClass().getResourceAsStream("/mySqlDB/config.properties")) {
//            if (in != null) {
                property.load(in);
                String URL = property.getProperty("URL");
                String USER = property.getProperty("USER");
                String PASSWORD = property.getProperty("PASSWORD");
                String DRIVER = property.getProperty("DRIVER");
                Class.forName(DRIVER);
                return DriverManager.getConnection(URL, USER, PASSWORD);
//            }
//            else {
//                throw new DaoException("File not found");
//            }
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new DaoException("Error in getConnection method", e);
        }
    }

    public PreparedStatement getPreparedStatement(String sql) throws DaoException {
        PreparedStatement preparedStatement = preparedStatements.get(sql);
        if (preparedStatement == null) {
            try {
                preparedStatement = getConnection().prepareStatement(sql);
            } catch (SQLException e) {
                throw new DaoException(e);
            }
        }
        return preparedStatement;
    }

    public void close() throws DaoException {
        List<SQLException> list = new ArrayList<>();
        for (PreparedStatement preparedStatement : preparedStatements.values()) {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                list.add(e);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                list.add(e);
            }
        }
        Exception ex = new Exception();
        if (!list.isEmpty()) {
            list.forEach(ex::addSuppressed);
            throw new DaoException("Error in close DAO", ex);
        }
    }
}
