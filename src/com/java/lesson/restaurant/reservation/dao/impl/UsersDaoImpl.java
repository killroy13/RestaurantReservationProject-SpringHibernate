package com.java.lesson.restaurant.reservation.dao.impl;

import com.java.lesson.restaurant.reservation.dao.AbstractMySQLDao;
import com.java.lesson.restaurant.reservation.dao.UsersDao;
import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dao.exception.NoSuchEntityException;
import com.java.lesson.restaurant.reservation.dto.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by User on 03.03.2018.
 */
public class UsersDaoImpl extends AbstractMySQLDao<User> implements UsersDao {

    public UsersDaoImpl() throws DaoException {
    }

    @Override
    protected String selectQuery() {
        return "SELECT users_id, user_name, last_name, " +
                "user_birth, login, password, user_email, user_phone FROM users";
    }

    @Override
    protected String selectByIdQuery() {
        return "SELECT users_id, user_name, last_name," +
                " user_birth, login, password, user_email, user_phone FROM users " +
                "WHERE users_id = ?";
    }

    /**ONLY FOR THIS IMPLEMENTATION*/
    protected String selectByLoginQueryAndPassword() {
        return "SELECT users_id, user_name, last_name," +
                " user_birth, login, password, user_email, user_phone FROM users " +
                "WHERE login = ? and password = ?";
    }

    @Override
    protected String insertQuery() {
        return "INSERT INTO users (user_name, last_name," +
                " user_birth, login, password, user_email, user_phone) VALUES(?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected String updateQuery() {
        return "INSERT INTO users (users_id, user_name, last_name, user_birth, login, password, user_email, user_phone)" +
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?)" +
                "ON DUPLICATE KEY UPDATE " +
                "user_name = ?, last_name = ?, user_birth = ?, login = ?, password = ?, user_email = ?, user_phone = ?";
    }

    @Override
    protected String deleteQuery() {
        return "delete from users where users_id = ?";
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws DaoException {
        LinkedList<User> result = new LinkedList<>();
        try {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setfName(rs.getString(2));
                user.setsName(rs.getString(3));
                user.setBirthDate(rs.getString(4));
                user.setLogin(rs.getString(5));
                user.setPassword(rs.getString(6));
                user.seteMail(rs.getString(7));
                user.setPhone(rs.getString(8));
                result.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException("Error in parseResultSet method", e);
        }
        return result;
    }

    @Override
    protected void preparedStatementForSelectById(PreparedStatement ps, int id) throws SQLException {
        ps.setInt(1, id);
    }

    /**ONLY FOR THIS IMPLEMENTATION*/
    protected void preparedStatementForSelectByLoginAndPassword(PreparedStatement ps, String login, String password) throws SQLException {
        ps.setString(1, login);
        ps.setString(2, password);
    }

    @Override
    protected void preparedStatementForInsert(PreparedStatement ps, User user) throws SQLException {
//        ps.setInt(1, user.getId());
        ps.setString(1, user.getfName());
        ps.setString(2, user.getsName());
        ps.setString(3, user.getBirthDate());
        ps.setString(4, user.getLogin());
        ps.setString(5, user.getPassword());
        ps.setString(6, user.geteMail());
        ps.setString(7, user.getPhone());
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement ps, User user) throws SQLException {
        ps.setInt(1, user.getId());
        ps.setString(2, user.getfName());
        ps.setString(3, user.getsName());
        ps.setString(4, user.getBirthDate());
        ps.setString(5, user.getLogin());
        ps.setString(6, user.getPassword());
        ps.setString(7, user.geteMail());
        ps.setString(8, user.getPhone());
        ps.setString(9, user.getfName());
        ps.setString(10, user.getsName());
        ps.setString(11, user.getBirthDate());
        ps.setString(12, user.getLogin());
        ps.setString(13, user.getPassword());
        ps.setString(14, user.geteMail());
        ps.setString(15, user.getPhone());
    }

    @Override
    public List<User> getAll() throws DaoException {
        List<User> result;
        try {
            PreparedStatement preparedStatement = getPreparedStatement(selectQuery());
            try (ResultSet rs = preparedStatement.executeQuery()) {
                result = parseResultSet(rs);
            }
        } catch (SQLException e) {
            throw new DaoException("Error in getAll method", e);
        }
        return result;
    }

    @Override
    public User getById(int id) throws DaoException {
        User user = null;
        try {
            PreparedStatement preparedStatement = getPreparedStatement(selectByIdQuery());
            preparedStatementForSelectById(preparedStatement, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt(1));
                    user.setfName(resultSet.getString(2));
                    user.setsName(resultSet.getString(3));
                    user.setBirthDate(resultSet.getString(4));
                    user.setLogin(resultSet.getString(5));
                    user.setPassword(resultSet.getString(6));
                    user.seteMail(resultSet.getString(7));
                    user.setPhone(resultSet.getString(8));
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error in getById method", e);
        }
        if (user == null) {
            throw new NoSuchEntityException("No Users for id = '" + id + "' ");
        } else {
            return user;
        }
    }

    //TODO логином может выступать email
    @Override
    public User getByLoginAndPassword(String login, String password) throws DaoException, NoSuchEntityException {
        User user = null;
        try {
            PreparedStatement preparedStatement = getPreparedStatement(selectByLoginQueryAndPassword());
            preparedStatementForSelectByLoginAndPassword(preparedStatement, login, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
//                    if (){

                        user = new User();
                        user.setId(resultSet.getInt(1));
                        user.setfName(resultSet.getString(2));
                        user.setsName(resultSet.getString(3));
                        user.setBirthDate(resultSet.getString(4));
                        user.setLogin(resultSet.getString(5));
                        user.setPassword(resultSet.getString(6));
                        user.seteMail(resultSet.getString(7));
                        user.setPhone(resultSet.getString(8));
//                    }
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error in getByLoginAndPassword method", e);
        }
        if (user == null) {
            throw new NoSuchEntityException("No Users for login = '" + login + "' ");
        } else {
            return user;
        }
    }

    @Override
    public void insert(User user) throws DaoException {
        try {
            PreparedStatement ps = getPreparedStatement(insertQuery());
            preparedStatementForInsert(ps, user);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error in insert method", e);
        }
    }

    @Override
    public void update(User user) throws DaoException {
        try {
            PreparedStatement ps = getPreparedStatement(updateQuery());
            preparedStatementForUpdate(ps, user);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error in update method", e);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        try {
            PreparedStatement ps = getPreparedStatement(deleteQuery());
            preparedStatementForSelectById(ps, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error in delete method", e);
        }
    }
}
