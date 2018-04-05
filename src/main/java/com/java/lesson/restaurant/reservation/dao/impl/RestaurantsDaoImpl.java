package com.java.lesson.restaurant.reservation.dao.impl;

import com.java.lesson.restaurant.reservation.dao.AbstractMySQLDao;
import com.java.lesson.restaurant.reservation.dao.RestaurantsDao;
import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dao.exception.NoSuchEntityException;
import com.java.lesson.restaurant.reservation.dto.Restaurant;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by UserDto on 20.03.2018.
 */
//@Repository
    @Component("restaurantsDao")
public class RestaurantsDaoImpl extends AbstractMySQLDao<Restaurant> implements RestaurantsDao {

    public RestaurantsDaoImpl() throws DaoException {
    }

    @Override
    protected String selectQuery() {
        return "SELECT restaurant_id, rest_name, rest_city, " +
                "rest_district, rest_street, house_number, rest_phone, rest_describe, " +
                "rest_photo FROM restaurants";
    }

    @Override
    protected String selectByIdQuery() {
        return "SELECT restaurant_id, rest_name, rest_city, " +
                "rest_district, rest_street, house_number, rest_phone, rest_describe, " +
                "rest_photo FROM restaurants " +
                "WHERE restaurant_id = ?";
    }

    @Override
    protected String insertQuery() {
        return "INSERT INTO restaurants (rest_name, rest_city," +
                " rest_district, rest_street, house_number, rest_phone, rest_describe," +
                "rest_photo) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected String updateQuery() {
        return "INSERT INTO restaurants (restaurant_id, rest_name, rest_city, rest_district, " +
                "rest_street, house_number, rest_phone, rest_describe, rest_photo)" +
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)" +
                "ON DUPLICATE KEY UPDATE " +
                "rest_name = ?, rest_city = ?, rest_district = ?, rest_street = ?, house_number = ?, " +
                "rest_phone = ?, rest_describe = ?, rest_photo = ?";
    }

    @Override
    protected String deleteQuery() {
        return "delete from restaurants where restaurant_id = ?";
    }

    //TODO
    protected String forDeleteQuery() {
        return "DELETE FROM marks WHERE student_id = ?";
    }

    @Override
    protected List<Restaurant> parseResultSet(ResultSet rs) throws DaoException {
        LinkedList<Restaurant> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(rs.getInt(1));
                restaurant.setName(rs.getString(2));
                restaurant.setCity(rs.getString(3));
                restaurant.setDistrict(rs.getString(4));
                restaurant.setStreet(rs.getString(5));
                restaurant.setHouseNumber(rs.getString(6));
                restaurant.setPhone(rs.getString(7));
                restaurant.setDescribe(rs.getString(8));
                restaurant.setPhoto(rs.getString(9));
                result.add(restaurant);
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

    @Override
    protected void preparedStatementForInsert(PreparedStatement ps, Restaurant restaurant) throws SQLException {
        ps.setString(1, restaurant.getName());
        ps.setString(2, restaurant.getCity());
        ps.setString(3, restaurant.getDistrict());
        ps.setString(4, restaurant.getStreet());
        ps.setString(5, restaurant.getHouseNumber());
        ps.setString(6, restaurant.getPhone());
        ps.setString(7, restaurant.getDescribe());
        ps.setString(8, restaurant.getPhoto());
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement ps, Restaurant restaurant) throws SQLException {
        ps.setInt(1, restaurant.getId());
        ps.setString(2, restaurant.getName());
        ps.setString(3, restaurant.getCity());
        ps.setString(4, restaurant.getDistrict());
        ps.setString(5, restaurant.getStreet());
        ps.setString(6, restaurant.getHouseNumber());
        ps.setString(7, restaurant.getPhone());
        ps.setString(8, restaurant.getDescribe());
        ps.setString(9, restaurant.getPhoto());
        ps.setString(10, restaurant.getName());
        ps.setString(11, restaurant.getCity());
        ps.setString(12, restaurant.getDistrict());
        ps.setString(13, restaurant.getStreet());
        ps.setString(14, restaurant.getHouseNumber());
        ps.setString(15, restaurant.getPhone());
        ps.setString(16, restaurant.getDescribe());
        ps.setString(17, restaurant.getPhoto());
    }

    @Override
    public List<Restaurant> getAll() throws DaoException {
        List<Restaurant> result;
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
    public Restaurant getById(int id) throws DaoException {
        Restaurant restaurant = null;
        try {
            PreparedStatement preparedStatement = getPreparedStatement(selectByIdQuery());
            preparedStatementForSelectById(preparedStatement, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    restaurant = new Restaurant();
                    restaurant.setId(rs.getInt(1));
                    restaurant.setName(rs.getString(2));
                    restaurant.setCity(rs.getString(3));
                    restaurant.setDistrict(rs.getString(4));
                    restaurant.setStreet(rs.getString(5));
                    restaurant.setHouseNumber(rs.getString(6));
                    restaurant.setPhone(rs.getString(7));
                    restaurant.setDescribe(rs.getString(8));
                    restaurant.setPhoto(rs.getString(9));
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error in getById method", e);
        }
        if (restaurant == null) {
            throw new NoSuchEntityException("No RestaurantDto for id = '" + id + "' ");
        } else {
            return restaurant;
        }
    }

    @Override
    public void insert(Restaurant restaurant) throws DaoException {
        try {
            PreparedStatement ps = getPreparedStatement(insertQuery());
            preparedStatementForInsert(ps, restaurant);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error in insert method", e);
        }
    }

    @Override
    public void update(Restaurant restaurant) throws DaoException {
        try {
            PreparedStatement ps = getPreparedStatement(updateQuery());
            preparedStatementForUpdate(ps, restaurant);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error in update method", e);
        }
    }

    //TODO
    @Override
    public void delete(int id) throws DaoException {
        try {
//            PreparedStatement ps = getPreparedStatement(forDeleteQuery());
//            preparedStatementForSelectById(ps, id);
//            ps.executeUpdate();
            PreparedStatement ps = getPreparedStatement(deleteQuery());
            preparedStatementForSelectById(ps, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error in delete method", e);
        }
    }
}
