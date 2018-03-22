package com.java.lesson.restaurant.reservation.controller;

import com.java.lesson.restaurant.reservation.attributes.Attributes;
import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dao.impl.AdvertisementsDaoImpl;
import com.java.lesson.restaurant.reservation.dao.impl.RestaurantsDaoImpl;
import com.java.lesson.restaurant.reservation.dao.impl.UsersDaoImpl;
import com.java.lesson.restaurant.reservation.dto.Advertisement;
import com.java.lesson.restaurant.reservation.dto.Restaurant;
import com.java.lesson.restaurant.reservation.dto.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

import static com.java.lesson.restaurant.reservation.attributes.Attributes.*;

/**
 * Created by User on 02.03.2018.
 */

@WebServlet(name = "RestaurantReservation", urlPatterns = "/users")
public class RestaurantReservation extends HttpServlet {

    public static Attributes attributes = new Attributes();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=windows-1251");
        String link;
        try {
            HttpSession session = request.getSession(false);

            if (request.getParameter("showUsers") != null) {
                link = showUsers(request, session);
            } else if (request.getParameter("showUserById") != null) {
                link = showUserById(request, session);
            } else if (request.getParameter("updateUser") != null) {
                link = updateUser(request, session);
            } else if (request.getParameter("insertUser") != null) {
                link = insertUser(request, session);
            } else if (request.getParameter("deleteUser") != null) {
                link = deleteUser(request, session);
            } else if (request.getParameter("login") != null) {
                link = userLogin(request, session);
//                System.out.println(">>>> IN ELSE IF processREQUEST");
//                throw new DaoException();
            } else if (request.getParameter("logout") != null) {
                link = userLogout(session);

            } else if (request.getParameter("showRestaurants") != null) {
//                System.out.println(">>>> IN ELSE 1");
                link = showRestaurants(request, session);
            } else if (request.getParameter("showRestaurantById") != null) {
                link = showRestaurantById(request, session);
            } else if (request.getParameter("updateRestaurant") != null) {
                link = updateRestaurant(request, session);
            } else if (request.getParameter("insertRestaurant") != null) {
                link = insertRestaurant(request, session);
            } else if (request.getParameter("deleteRestaurant") != null) {
                link = deleteRestaurant(request, session);


            } else if (request.getParameter("showAdvertisements") != null) {
                link = showAdvertisements(request, session);
            }else if (request.getParameter("showAdvertisementById") != null) {
                link = showAdvertisementById(request, session);
            }else if (request.getParameter("addAdvertisement") != null) {
                link = addAdvertisement(request, session);
            }else if (request.getParameter("deleteAdvertisement") != null) {
                link = deleteAdvertisement(request, session);
            } else {
                link = ERROR_PAGE;
            }
            request.getRequestDispatcher(link).forward(request, response);
        } catch (Exception e) {
//            System.out.println(">>>> IN CATCH REQUESTRESP");
            e.printStackTrace();
            request.setAttribute("error", e);
            throw new ServletException(e);
        }
    }


    /**
     * ADVERTISEMENTS
     */

    protected String showAdvertisements(HttpServletRequest request, HttpSession session) throws IOException, ServletException {
        String link;
        try {
            AdvertisementsDaoImpl advertisementsDao = (AdvertisementsDaoImpl) session.getAttribute(ADVERTISEMENTS_DAO);
            request.setAttribute(ADVERTISEMENT_DTO, advertisementsDao.getAll());
            link = SHOW_ALL_ADVERTISEMENTS_PAGE;
        } catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }

    protected String showAdvertisementById(HttpServletRequest request, HttpSession session) throws IOException, ServletException{
        String link;
        try {
            AdvertisementsDaoImpl advertisementsDao = (AdvertisementsDaoImpl) session.getAttribute(ADVERTISEMENTS_DAO);
            String idStr = request.getParameter(ADVERTISEMENT_ID);
            if (attributes.validId(idStr).isEmpty()){
                Integer id = Integer.valueOf(idStr);
                Advertisement advertisement = advertisementsDao.getById(id);
                request.setAttribute(ADVERTISEMENT_MODEL_TO_VIEW, advertisement);
                link = ADVERTISEMENT_PAGE;
            }else {
                request.setAttribute("advertisementId", idStr);
                request.setAttribute("errors", attributes.validId(idStr));
                link = ERROR_PAGE;
            }
        }catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }

    protected String addAdvertisement (HttpServletRequest request, HttpSession session)throws ServletException, IOException{
        String link;
        try {
            AdvertisementsDaoImpl advertisementsDao = (AdvertisementsDaoImpl) session.getAttribute(ADVERTISEMENTS_DAO);
            Advertisement advertisement = (Advertisement) session.getAttribute(ADVERTISEMENT_DTO);
            String offerText = request.getParameter(ADVERTISEMENT_TEXT);
            String restaurantId = request.getParameter(ADVERTISEMENT_OF_RESTAURANT_ID);
            HashMap<String, String> dataErrorMap = attributes.vaidateInsertAdvertisement(offerText, restaurantId);
            if (dataErrorMap.isEmpty()){
                advertisement.setOfferText(offerText);
                advertisement.setRestaurantId(Integer.valueOf(restaurantId));
                advertisementsDao.insert(advertisement);
                request.setAttribute("offerText", offerText);
                request.setAttribute("restaurantId", restaurantId);
                link = ADD_ADVERTISEMENT_SUCCESS_PAGE;
            }else {
                request.setAttribute("offerText", offerText);
                request.setAttribute("restaurantId", restaurantId);
                request.setAttribute("errorsOfferText", dataErrorMap.get("offerText"));
                request.setAttribute("errorsRestaurantId", dataErrorMap.get("id"));
                request.setAttribute("nullErrors", "");
                request.setAttribute("errors", dataErrorMap);
                link = RE_ADD_ADVERTISEMENT_PAGE;
            }
        }catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }

    //TODO Исправить ошибку с удалением номера которого нет
    protected String deleteAdvertisement(HttpServletRequest request, HttpSession session) throws IOException, ServletException{
        String link;
        try {
            AdvertisementsDaoImpl advertisementsDao = (AdvertisementsDaoImpl) session.getAttribute(ADVERTISEMENTS_DAO);
            String id = request.getParameter("advertisementIdForDelete");
            if(attributes.validId(id).isEmpty()){
                request.setAttribute("id", id);
                advertisementsDao.delete(Integer.parseInt(id));
                link = SUCCESS_DELETE_ADVERTISEMENT_PAGE;
            }else {
                request.setAttribute("advertisementId", id);
                request.setAttribute("errors", attributes.validId(id));
                link = ERROR_PAGE;
            }
        }catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }




    /**
     * RESTAURANTS
     */

    protected String showRestaurants(HttpServletRequest request, HttpSession session) throws IOException, ServletException {
        String link;
        try {
//            System.out.println(">>>> IN TRY");
            RestaurantsDaoImpl restaurantsDao = (RestaurantsDaoImpl) session.getAttribute(RESTAURANTS_DAO);
            request.setAttribute(RESTAURANT_DTO, restaurantsDao.getAll());
            link = SHOW_ALL_RESTAURANTS_PAGE;
        } catch (DaoException e) {
//            System.out.println(">>>> IN CATCH");
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }



    protected String showRestaurantById(HttpServletRequest request, HttpSession session) throws IOException, ServletException {
        String link;
        try {
            RestaurantsDaoImpl restaurantsDao = (RestaurantsDaoImpl) session.getAttribute(RESTAURANTS_DAO);
            String idStr = request.getParameter(RESTAURANT_ID);
            if (attributes.validId(idStr).isEmpty()) {
                Integer id = Integer.valueOf(idStr);
                Restaurant restaurant = restaurantsDao.getById(id);
                request.setAttribute(RESTAURANT_MODEL_TO_VIEW, restaurant);
                link = RESTAURANT_PAGE;
            } else {
                request.setAttribute("restaurantId", idStr);
                request.setAttribute("errors", attributes.validId(idStr));
                link = ERROR_PAGE;
            }
        } catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }

    //TODO Исправить на заливку фото с компьютера (не ссылка)
    protected String updateRestaurant(HttpServletRequest request, HttpSession session) throws IOException, ServletException {
        String link;
        try {
            RestaurantsDaoImpl restaurantsDao = (RestaurantsDaoImpl) session.getAttribute(RESTAURANTS_DAO);
            Restaurant restaurant = (Restaurant) session.getAttribute(RESTAURANT_DTO);
            String id = request.getParameter(RESTAURANT_ID);
            String name = request.getParameter(RESTAURANT_NAME);
            String city = request.getParameter(RESTAURANT_CITY);
            String district = request.getParameter(RESTAURANT_DISTRICT);
            String street = request.getParameter(RESTAURANT_STREET);
            String houseNumber = request.getParameter(HOUSE_NUMBER);
            String phone = request.getParameter(RESTAURANT_PHONE);
            String describe = request.getParameter(RESTAURANT_DESCRIBE);
            String photo = request.getParameter(RESTAURANT_PHOTO);
            HashMap<String, String> dataErrorMap = attributes.validateUpdateRestaurant(id, name, city, district, street, houseNumber, phone, describe, photo);
            if (dataErrorMap.isEmpty()) {
                restaurant.setId(Integer.parseInt(id));
                restaurant.setName(name);
                restaurant.setCity(city);
                restaurant.setDistrict(district);
                restaurant.setStreet(street);
                restaurant.setHouseNumber(houseNumber);
                restaurant.setPhone(phone);
                restaurant.setDescribe(describe);
                restaurant.setPhoto(photo);

                restaurantsDao.update(restaurant);

                request.setAttribute("id", id);
                request.setAttribute("name", name);
                request.setAttribute("city", city);
                request.setAttribute("district", district);
                request.setAttribute("street", street);
                request.setAttribute("houseNumber", houseNumber);
                request.setAttribute("phone", phone);
                request.setAttribute("describe", describe);
                request.setAttribute("photo", photo);

                link = SUCCESS_EDIT_RESTAURANT_PAGE;
            } else {
                request.setAttribute("id", id);
                request.setAttribute("name", name);
                request.setAttribute("city", city);
                request.setAttribute("district", district);
                request.setAttribute("street", street);
                request.setAttribute("houseNumber", houseNumber);
                request.setAttribute("phone", phone);
                request.setAttribute("describe", describe);
                request.setAttribute("photo", photo);

                request.setAttribute("errorId", dataErrorMap.get("id"));
                request.setAttribute("errorsName", dataErrorMap.get("name"));
                request.setAttribute("errorsCity", dataErrorMap.get("city"));
                request.setAttribute("errorsDistrict", dataErrorMap.get("district"));
                request.setAttribute("errorsStreet", dataErrorMap.get("street"));
                request.setAttribute("errorsHouseNumber", dataErrorMap.get("houseNumber"));
                request.setAttribute("errorsPhone", dataErrorMap.get("phone"));
                request.setAttribute("errorsDescribe", dataErrorMap.get("describe"));
                request.setAttribute("errorsPhoto", dataErrorMap.get("photo"));

                request.setAttribute("nullErrors", "");
                request.setAttribute("errors", dataErrorMap);

                link = RE_EDIT_RESTAURANT_PAGE;
            }
        } catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }




    //TODO Доделать формат для фото
    protected String insertRestaurant(HttpServletRequest request, HttpSession session) throws ServletException, IOException {
        String link;
        try {
            RestaurantsDaoImpl restaurantsDao = (RestaurantsDaoImpl) session.getAttribute(RESTAURANTS_DAO);
            Restaurant restaurant = (Restaurant) session.getAttribute(RESTAURANT_DTO);
            String name = request.getParameter(RESTAURANT_NAME);
            String city = request.getParameter(RESTAURANT_CITY);
            String district = request.getParameter(RESTAURANT_DISTRICT);
            String street = request.getParameter(RESTAURANT_STREET);
            String houseNumber = request.getParameter(HOUSE_NUMBER);
            String phone = request.getParameter(RESTAURANT_PHONE);
            String describe = request.getParameter(RESTAURANT_DESCRIBE);
            String photo = request.getParameter(RESTAURANT_PHOTO);
            HashMap<String, String> dataErrorMap = attributes.vaidateInsertRestaurant(name, city, district, street, houseNumber, phone, describe, photo);
            if (dataErrorMap.isEmpty()) {
                restaurant.setName(name);
                restaurant.setCity(city);
                restaurant.setDistrict(district);
                restaurant.setStreet(street);
                restaurant.setHouseNumber(houseNumber);
                restaurant.setPhone(phone);
                restaurant.setDescribe(describe);
                restaurant.setPhoto(photo);

                restaurantsDao.insert(restaurant);

                request.setAttribute("name", name);
                request.setAttribute("city", city);
                request.setAttribute("district", district);
                request.setAttribute("street", street);
                request.setAttribute("houseNumber", houseNumber);
                request.setAttribute("phone", phone);
                request.setAttribute("describe", describe);
//                request.setAttribute("photo", photo);

                link = ADD_RESTAURANT_SUCCESS_PAGE;
            } else {
                request.setAttribute("name", name);
                request.setAttribute("city", city);
                request.setAttribute("district", district);
                request.setAttribute("street", street);
                request.setAttribute("houseNumber", houseNumber);
                request.setAttribute("phone", phone);
                request.setAttribute("describe", describe);
//                request.setAttribute("photo", photo);

                request.setAttribute("errorsName", dataErrorMap.get("name"));
                request.setAttribute("errorsCity", dataErrorMap.get("city"));
                request.setAttribute("errorsDistrict", dataErrorMap.get("district"));
                request.setAttribute("errorsStreet", dataErrorMap.get("street"));
                request.setAttribute("errorsHouseNumber", dataErrorMap.get("houseNumber"));
                request.setAttribute("errorsPhone", dataErrorMap.get("phone"));
                request.setAttribute("errorsDescribe", dataErrorMap.get("describe"));
//                request.setAttribute("errorsPhoto", dataErrorMap.get("photo"));

                request.setAttribute("nullErrors", "");

                request.setAttribute("errors", dataErrorMap);

                link = RE_ADD_RESTAURANT_PAGE;
            }
        } catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }

    protected String deleteRestaurant(HttpServletRequest request, HttpSession session) throws ServletException, IOException {
        String link;
        try {
            RestaurantsDaoImpl restaurantsDao = (RestaurantsDaoImpl) session.getAttribute(RESTAURANTS_DAO);
            String id = request.getParameter("restaurantIdForDelete");
            if (attributes.validId(id).isEmpty()) {
                request.setAttribute("id", id);
                restaurantsDao.delete(Integer.parseInt(id));
                link = SUCCESS_DELETE_RESTAURANT_PAGE;
            } else {
                request.setAttribute("restaurantId", id);
                request.setAttribute("errors", attributes.validId(id));
                link = ERROR_PAGE;
            }
        } catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }


    /**
     * USERS
     */

    protected String showUsers(HttpServletRequest request, HttpSession session) throws IOException, ServletException {
        String link;
        try {
            UsersDaoImpl usersDao = (UsersDaoImpl) session.getAttribute(USERS_DAO);
            request.setAttribute(USER_DTO, usersDao.getAll());
            link = SHOW_ALL_USERS_PAGE;
        } catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }

    //TODO показ пользователю сообщения об ошибке (нет в базе)
    protected String showUserById(HttpServletRequest request, HttpSession session) throws IOException, ServletException {
        String link;
        try {
            UsersDaoImpl usersDao = (UsersDaoImpl) session.getAttribute(USERS_DAO);
            String idStr = request.getParameter(ID);
            if (attributes.validId(idStr).isEmpty()) {
                Integer id = Integer.valueOf(idStr);
                User user = usersDao.getById(id);
                request.setAttribute(USER_MODEL_TO_VIEW, user);
                link = USER_PAGE;
            } else {
                request.setAttribute("userId", idStr);
                request.setAttribute("errors", attributes.validId(idStr));
                link = ERROR_PAGE;
            }
        } catch (DaoException | NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }

    //TODO Исправить! (возможность изменять только 1 поле)
    protected String updateUser(HttpServletRequest request, HttpSession session) throws ServletException, IOException {
        String link;
        try {
            UsersDaoImpl usersDao = (UsersDaoImpl) session.getAttribute(USERS_DAO);
            User user = (User) session.getAttribute(USER_DTO);

            String id = request.getParameter(ID);
            String fName = request.getParameter(FIRST_NAME);
            String sName = request.getParameter(SECOND_NAME);
            String birthDate = request.getParameter(BIRTH_DATE);
            String login = request.getParameter(LOGIN);
            String password = request.getParameter(PASSWORD);
            String eMail = request.getParameter(EMAIL);
            String phone = request.getParameter(PHONE);

            HashMap<String, String> dataErrorMap = attributes.validateUpdateUser(id, fName, sName, birthDate, login, password, eMail, phone);

            if (dataErrorMap.isEmpty()) {
                user.setId(Integer.parseInt(id));
                user.setfName(fName);
                user.setsName(sName);
                user.setBirthDate(birthDate);
                user.setLogin(login);
                user.setPassword(password);
                user.seteMail(eMail);
                user.setPhone(phone);

                usersDao.update(user);

                request.setAttribute("id", id);
                request.setAttribute("fName", fName);
                request.setAttribute("sName", sName);
                request.setAttribute("eMail", eMail);
                request.setAttribute("login", login);
                request.setAttribute("phone", phone);

                link = SUCCESS_EDIT_USER_PAGE;
            } else {
                request.setAttribute("id", id);
                request.setAttribute("fName", fName);
                request.setAttribute("sName", sName);
                request.setAttribute("birthDate", birthDate);
                request.setAttribute("eMail", eMail);
                request.setAttribute("password", password);
                request.setAttribute("login", login);
                request.setAttribute("phone", phone);

                request.setAttribute("errorId", dataErrorMap.get("id"));

                request.setAttribute("errorsFName", dataErrorMap.get("fName"));
                request.setAttribute("errorsSName", dataErrorMap.get("sName"));
                request.setAttribute("errorsBirthDate", dataErrorMap.get("birthDate"));
                request.setAttribute("errorsEmail", dataErrorMap.get("eMail"));
                request.setAttribute("errorsPassword", dataErrorMap.get("password"));
                request.setAttribute("errorsLogin", dataErrorMap.get("login"));
                request.setAttribute("errorsPhone", dataErrorMap.get("phone"));

                request.setAttribute("nullErrors", "");
                request.setAttribute("errors", dataErrorMap);

                link = RE_EDIT_USER_PAGE;
            }
        } catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }

    protected String insertUser(HttpServletRequest request, HttpSession session) throws ServletException, IOException {
        String link;
        try {
            UsersDaoImpl usersDao = (UsersDaoImpl) session.getAttribute(USERS_DAO);
            User user = (User) session.getAttribute(USER_DTO);

            String fName = request.getParameter(FIRST_NAME);
            String sName = request.getParameter(SECOND_NAME);
            String birthDate = request.getParameter(BIRTH_DATE);
            String login = request.getParameter(LOGIN);
            String password = request.getParameter(PASSWORD);
            String eMail = request.getParameter(EMAIL);
            String phone = request.getParameter(PHONE);

            HashMap<String, String> dataErrorMap = attributes.validateInsertUser(fName, sName, birthDate, password, login, eMail, phone);
//            System.out.println(">>> IN TRY");
            if (dataErrorMap.isEmpty()) {
//                System.out.println(">>> IN  IF");

                user.setfName(fName);
                user.setsName(sName);
                user.setBirthDate(birthDate);
                user.setLogin(login);
                user.setPassword(password);
                user.seteMail(eMail);
                user.setPhone(phone);
//                System.out.println(">>> IN  IF 2");
                usersDao.insert(user);
//                System.out.println(">>> IN  IF 3");
                request.setAttribute("fName", fName);
                request.setAttribute("sName", sName);
                request.setAttribute("birthDate", birthDate);
                request.setAttribute("eMail", eMail);
                request.setAttribute("password", password);
                request.setAttribute("login", login);
                request.setAttribute("phone", phone);
//                request.getRequestDispatcher(REGISTRATION_SUCCESS_PAGE).forward(request, response);
                link = REGISTRATION_SUCCESS_PAGE;
//                System.out.println(">>> IN  IF 4");
            } else {
                request.setAttribute("fName", fName);
                request.setAttribute("sName", sName);
                request.setAttribute("birthDate", birthDate);
                request.setAttribute("eMail", eMail);
                request.setAttribute("password", password);
                request.setAttribute("login", login);
                request.setAttribute("phone", phone);

                request.setAttribute("errorsFName", dataErrorMap.get("fName"));
                request.setAttribute("errorsSName", dataErrorMap.get("sName"));
                request.setAttribute("errorsBirthDate", dataErrorMap.get("birthDate"));
                request.setAttribute("errorsEmail", dataErrorMap.get("eMail"));
                request.setAttribute("errorsPassword", dataErrorMap.get("password"));
                request.setAttribute("errorsLogin", dataErrorMap.get("login"));
                request.setAttribute("errorsPhone", dataErrorMap.get("phone"));

                request.setAttribute("nullErrors", "");

                request.setAttribute("errors", dataErrorMap);
//                System.out.println(">>> IN ELSE");
//                request.getRequestDispatcher(RE_REGISTRATION_PAGE).forward(request, response);
                link = RE_REGISTRATION_PAGE;
            }
        } catch (DaoException e) {
            e.printStackTrace();
//            System.out.println(">>> IN CATCH 1");
            request.setAttribute("error", e);
//            request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
            link = ERROR_PAGE;
        }
        return link;
    }


    protected String deleteUser(HttpServletRequest request, HttpSession session) throws ServletException, IOException {
        String link;
        try {
            UsersDaoImpl usersDao = (UsersDaoImpl) session.getAttribute(USERS_DAO);
            String id = request.getParameter("idForDelete");
            if (attributes.validId(id).isEmpty()) {
                request.setAttribute("id", id);
                usersDao.delete(Integer.parseInt(id));
                link = SUCCESS_DELETE_USER_PAGE;
            } else {
                request.setAttribute("userId", id);
                request.setAttribute("errors", attributes.validId(id));
                link = ERROR_PAGE;
            }
        } catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }

    //TODO 1. разлогирование и переход с других страниц на MAIN
    protected String userLogout(HttpSession session) throws ServletException, IOException {
        String link;
        session.removeAttribute("name");
        session.removeAttribute("sName");
        link = MAIN_PAGE;
        session.invalidate();
        return link;
    }

    //TODO Убрать вход когда уже вошел/  Проблема с воодом пароля (Вывод сообщения: Incorrect password)
    protected String userLogin(HttpServletRequest request, HttpSession session) throws ServletException, IOException {
        String link;
        try {
            String login = request.getParameter(LOGIN);
            String password = request.getParameter(PASSWORD);

            HashMap<String, String> dataErrorMap = attributes.validateLoginUser(login, password);

            if (dataErrorMap.isEmpty()) {
                System.out.println(">>>> IN IF");
//кидает ошибку!!!!!!
                UsersDaoImpl usersDao = (UsersDaoImpl) session.getAttribute(USERS_DAO);
                User user = usersDao.getByLoginAndPassword(login, password);
                System.out.println(">>>> IN TRY");

                session.setAttribute("name", user.getfName());
                session.setAttribute("sName", user.getsName());

                String nameDB = user.getsName();
                String secondNameDB = user.getfName();
                request.setAttribute("nameDB", nameDB);
                request.setAttribute("secondNameDB", secondNameDB);

                link = LOGIN_SUCCESS_PAGE;
            } else {
                request.setAttribute("login", login);
                request.setAttribute("password", password);

                request.setAttribute("errorsLogin", dataErrorMap.get("login"));
                request.setAttribute("errorsPassword", dataErrorMap.get("password"));

                request.setAttribute("nullErrors", "");

                request.setAttribute("errors", dataErrorMap);
                System.out.println(">>>> IN ELSE");
                link = RE_LOGIN_PAGE;
            }
        } catch (DaoException e) {
            System.out.println(">>>> IN CATCH");
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }
}




























