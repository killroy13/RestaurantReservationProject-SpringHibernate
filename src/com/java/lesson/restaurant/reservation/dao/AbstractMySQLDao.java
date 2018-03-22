package com.java.lesson.restaurant.reservation.dao;

import tests.Main;
import com.java.lesson.restaurant.reservation.dao.exception.DaoException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * Created by User on 02.03.2018.
 */
public abstract class AbstractMySQLDao<T> {

    private Map<String, PreparedStatement> preparedStatements = new HashMap<>();

    protected Connection connection;

    public AbstractMySQLDao() throws DaoException {
        this.connection = getConnection();
    }

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


    public Connection getConnection() throws DaoException {
        Properties property = new Properties();
        try (InputStream in = Main.class.getResourceAsStream("config.properties")) {
            property.load(in);
            String URL = property.getProperty("URL");
            String USER = property.getProperty("USER");
            String PASSWORD = property.getProperty("PASSWORD");
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
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
