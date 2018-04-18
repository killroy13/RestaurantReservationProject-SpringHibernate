package com.java.lesson.restaurant.reservation.attributes;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dao.impl.AdvertisementsDaoImpl;
import com.java.lesson.restaurant.reservation.dao.impl.RestaurantsDaoImpl;
import com.java.lesson.restaurant.reservation.dao.impl.UsersDaoImpl;
import com.java.lesson.restaurant.reservation.dto.Advertisement;
import com.java.lesson.restaurant.reservation.dto.Restaurant;
import com.java.lesson.restaurant.reservation.dto.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by User on 01.04.2018.
 */
@Configuration
@PropertySource("classpath:mySqlDB/config.properties")
@EnableTransactionManagement
@ComponentScans(value = {
        @ComponentScan("com.java.lesson.restaurant.reservation")
})
public class RestaurantReservationConfig {

    @Autowired
    private Environment env;

    @Bean
    public UsersDaoImpl usersDao() throws DaoException {
        return new UsersDaoImpl();
    }

    @Bean
    public RestaurantsDaoImpl restaurantsDao() throws DaoException{
        return new RestaurantsDaoImpl();
    }

    @Bean
    public AdvertisementsDaoImpl advertisementsDao() throws DaoException{
        return new AdvertisementsDaoImpl();
    }


//
//    @Bean
//    public User user (){
//        return new User();
//    }
//
//    @Bean
//    public Restaurant restaurant() {
//        return new Restaurant();
//    }
//
//    @Bean
//    public Advertisement advertisement(){
//        return new Advertisement();
//    }

@Bean
    public DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("DRIVER"));
        dataSource.setUrl(env.getProperty("URL"));
        dataSource.setUsername(env.getProperty("USER"));
        dataSource.setPassword(env.getProperty("PASSWORD"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.connection.pool_size", env.getProperty("hibernate.connection.pool_size"));
        properties.put("spring.jpa.properties.hibernate.current_session_context_class", env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));

        factoryBean.setHibernateProperties(properties);
        factoryBean.setAnnotatedClasses(User.class, Restaurant.class, Advertisement.class);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }


}
