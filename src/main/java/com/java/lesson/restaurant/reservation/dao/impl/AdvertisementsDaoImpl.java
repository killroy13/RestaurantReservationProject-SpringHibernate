package com.java.lesson.restaurant.reservation.dao.impl;

import com.java.lesson.restaurant.reservation.dao.AbstractMySQLDao;
import com.java.lesson.restaurant.reservation.dao.AdvertisementsDao;
import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dto.Advertisement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by UserDto on 21.03.2018.
 */

@Repository("advertisementsDao")
public class AdvertisementsDaoImpl extends AbstractMySQLDao<Advertisement> implements AdvertisementsDao {

    @Autowired
    SessionFactory sessionFactory;

    public AdvertisementsDaoImpl() throws DaoException {
    }

    @Override
    protected String selectQuery() {
        return "SELECT advertisement_id, adv_text, restaurant_id FROM advertisements";
    }

    @Override
    protected String selectByIdQuery() {
        return "SELECT advertisement_id, adv_text, restaurant_id FROM advertisements WHERE advertisement_id = ?";
    }

    @Override
    protected String insertQuery() {
        return "INSERT INTO advertisements (adv_text, restaurant_id) VALUES (?, ?)";
    }

    @Override
    protected String updateQuery() {
        return "INSERT INTO advertisements (advertisement_id, adv_text, restaurant_id) " +
                "VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE adv_text = ?, restaurant_id = ?";
    }

    @Override
    protected String deleteQuery() {
        return "DELETE FROM advertisements WHERE advertisement_id = ?";
    }

    @Override
    protected List<Advertisement> parseResultSet(ResultSet rs) throws DaoException {
        LinkedList<Advertisement> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Advertisement advertisement = new Advertisement();
                advertisement.setId(rs.getInt(1));
                advertisement.setOfferText(rs.getString(2));
                advertisement.setRestaurantId(rs.getInt(3));
                result.add(advertisement);
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
    protected void preparedStatementForInsert(PreparedStatement ps, Advertisement advertisement) throws SQLException {
        ps.setString(1, advertisement.getOfferText());
        ps.setInt(2, advertisement.getRestaurantId());
    }

    @Override
    protected void preparedStatementForUpdate(PreparedStatement ps, Advertisement advertisement) throws SQLException {
        ps.setInt(1, advertisement.getId());
        ps.setString(2, advertisement.getOfferText());
        ps.setInt(3, advertisement.getRestaurantId());
        ps.setString(4, advertisement.getOfferText());
        ps.setInt(5, advertisement.getRestaurantId());
    }

    @Override
    public List<Advertisement> getAll() throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        List<Advertisement> result;
        try {
            result = session.createQuery("from Advertisement order by id").list();
        } catch (Exception e) {
            throw new DaoException("Error in getAll method", e);
        }
        return result;
    }

    @Override
    public Advertisement getById(int id) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        Advertisement advertisement;
        try {
            advertisement = session.get(Advertisement.class, id);
        } catch (Exception e) {
            throw new DaoException("Error in getById method", e);
        }
        return advertisement;
    }

    @Override
    public void insert(Advertisement advertisement) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(advertisement);
        } catch (Exception e) {
            throw new DaoException("Error in insert method", e);
        }
    }

    //TODO рассмотреть возможность изменения (необходима ли функция??)
    @Override
    public void update(Advertisement advertisement) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(advertisement);
        } catch (Exception e) {
            throw new DaoException("Error in update method", e);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        Session session = sessionFactory.getCurrentSession();
        try {
            Advertisement advertisement = session.get(Advertisement.class, id);
            session.delete(advertisement);
        } catch (Exception e) {
            throw new DaoException("Error in delete method", e);
        }
    }
}
