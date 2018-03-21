package com.java.lesson.restaurant.reservation;

import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dao.impl.AdvertisementsDaoImpl;
import com.java.lesson.restaurant.reservation.dao.impl.RestaurantsDaoImpl;
import com.java.lesson.restaurant.reservation.dao.impl.UsersDaoImpl;
import com.java.lesson.restaurant.reservation.dto.Advertisement;
import com.java.lesson.restaurant.reservation.dto.Restaurant;
import com.java.lesson.restaurant.reservation.dto.User;

/**
 * Created by User on 02.03.2018.
 */
public class Main {
    public static void main(String[] args) throws DaoException {
        UsersDaoImpl us = new UsersDaoImpl();

        User user1 = new User();
        user1.setId(3);
        user1.setfName("Daiv");
        user1.setsName("Peterson");
        user1.setBirthDate("2012-12-15");
        user1.setLogin("login");
        user1.setPassword("password");
        user1.seteMail("mail");
        user1.setPhone("345345345");

        User user2 = new User();
        user2.setId(4);
        user2.setfName("testt");
        user2.setsName("fest");
        user2.setBirthDate("2012-12-15");
        user2.setLogin("logieen");
        user2.setPassword("paseesword");
        user2.seteMail("mailsd");
        user2.setPhone("345345sds345");


        /**Users*/

        /*Вывод по id*/
//        System.out.println(us.getById(20));

         /*Вывод по login*/
//        System.out.println(us.getByLoginAndPassword("login", "password"));

        /*Обновление*/
//        us.update(user1);
//
        /*Удаление*/
//        us.delete(4);

        /*Добавление*/
//        us.insert(user2);

        /*Вывод списка user*/
//        System.out.println(us.getAll());

        /*ЗАкрытие*/
//        us.close();


        /**Restaurant*/

        RestaurantsDaoImpl rest = new RestaurantsDaoImpl();

        Restaurant restaurant1 = new Restaurant();
        restaurant1.setId(5);
        restaurant1.setName("Daiv");
        restaurant1.setCity("Minsk");
        restaurant1.setDistrict("Leninsko");
        restaurant1.setStreet("gorox");
        restaurant1.setHouseNumber("23");
        restaurant1.setPhone("375-44-598-59-59");
        restaurant1.setDescribe("345 re 345345. R");
        restaurant1.setPhoto("12");

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setId(6);
        restaurant2.setName("4ff");
        restaurant2.setCity("Minsk");
        restaurant2.setDistrict("Leninsko");
        restaurant2.setStreet("gorox");
        restaurant2.setHouseNumber("23");
        restaurant2.setPhone("375-44-598-59-59");
        restaurant2.setDescribe("book is good thing. Because it very interesting");
        restaurant2.setPhoto("12");

        /*Вывод по id*/
//        System.out.println(rest.getById(2));

        /*Добавление*/
//        rest.insert(restaurant2);

        /*Удаление*/
//        rest.delete(4);

        /*Обновление*/
//        rest.update(restaurant2);

        /*Вывод списка*/
//        System.out.println(rest.getAll());

        /*ЗАкрытие*/
//        rest.close();



        /**Advertisement*/

        AdvertisementsDaoImpl adv = new AdvertisementsDaoImpl();

        Advertisement advertisement1 = new Advertisement();
        advertisement1.setId(5);
        advertisement1.setOfferText("Daiv");
        advertisement1.setRestaurantId(5);

        Advertisement advertisement2 = new Advertisement();
        advertisement2.setId(3);
        advertisement2.setOfferText("Minsk");
        advertisement2.setRestaurantId(6);

        /*Вывод по id*/
//        System.out.println(adv.getById(2));

        /*Добавление*/
//        adv.insert(advertisement1);

        /*Удаление*/
//        adv.delete(3);

        /*Обновление*/
//        adv.update(advertisement2);

        /*Вывод списка*/
//        System.out.println(adv.getAll());

        /*Закрытие*/
//        adv.close();


        /**Orders*/

//        AdvertisementsDaoImpl adv = new AdvertisementsDaoImpl();
//
//        Advertisement advertisement1 = new Advertisement();
//        advertisement1.setId(5);
//        advertisement1.setOfferText("Daiv");
//        advertisement1.setRestaurantId(5);
//
//        Advertisement advertisement2 = new Advertisement();
//        advertisement2.setId(3);
//        advertisement2.setOfferText("Minsk");
//        advertisement2.setRestaurantId(6);

        /*Вывод по id*/
//        System.out.println(adv.getById(2));

        /*Добавление*/
//        adv.insert(advertisement1);

        /*Удаление*/
//        adv.delete(3);

        /*Обновление*/
//        adv.update(advertisement2);

        /*Вывод списка*/
//        System.out.println(adv.getAll());

        /*Закрытие*/
//        adv.close();







    }
}
