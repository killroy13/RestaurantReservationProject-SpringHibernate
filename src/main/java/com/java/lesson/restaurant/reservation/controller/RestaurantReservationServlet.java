package com.java.lesson.restaurant.reservation.controller;

import com.java.lesson.restaurant.reservation.attributes.RestaurantReservationAttributes;
import com.java.lesson.restaurant.reservation.dao.exception.DaoException;
import com.java.lesson.restaurant.reservation.dao.impl.AdvertisementsDaoImpl;
import com.java.lesson.restaurant.reservation.dto.Advertisement;
import com.java.lesson.restaurant.reservation.dto.Restaurant;
import com.java.lesson.restaurant.reservation.dto.User;
import com.java.lesson.restaurant.reservation.service.AdvertisementsService;
import com.java.lesson.restaurant.reservation.service.RestaurantsService;
import com.java.lesson.restaurant.reservation.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

import static com.java.lesson.restaurant.reservation.attributes.RestaurantReservationAttributes.*;

/**
 * Created by UserDto on 02.03.2018.
 * @author Igor Iv
 */
@WebServlet(name = "RestaurantReservationServlet", urlPatterns = "/users")
public class RestaurantReservationServlet extends HttpServlet {

    @Autowired
    private AdvertisementsDaoImpl advertisementsDao;

    @Autowired
    private UsersService usersService;

    @Autowired
    private RestaurantsService restaurantsService;

    @Autowired
    private AdvertisementsService advertisementsService;


    public void init() throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    public static RestaurantReservationAttributes attributes = new RestaurantReservationAttributes();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=windows-1251");
        String link = null;
        try {

            HttpSession session = request.getSession(false);

            if (request.getParameter("showUsers") != null) {
                link = showUsers(request);
            } else if (request.getParameter("showUserById") != null) {
                link = showUserById(request);
            } else if (request.getParameter("updateUser") != null) {
                link = updateUser(request);
            } else if (request.getParameter("insertUser") != null) {
                link = insertUser(request);
            } else if (request.getParameter("deleteUser") != null) {
                link = deleteUser(request);
            } else if (request.getParameter("login") != null) {
                link = userLogin(request);
            } else if (request.getParameter("logout") != null) {
                link = userLogout(session);

            } else if (request.getParameter("showRestaurants") != null) {
                link = showRestaurants(request);
            } else if (request.getParameter("showRestaurantById") != null) {
                link = showRestaurantById(request);
            } else if (request.getParameter("updateRestaurant") != null) {
                link = updateRestaurant(request);
            } else if (request.getParameter("insertRestaurant") != null) {
                link = insertRestaurant(request);
            } else if (request.getParameter("deleteRestaurant") != null) {
                link = deleteRestaurant(request);

            } else if (request.getParameter("showAdvertisements") != null) {
                link = showAdvertisements(request);
            }else if (request.getParameter("showAdvertisementById") != null) {
                link = showAdvertisementById(request);



            }else if (request.getParameter("addAdvertisement") != null) {
                link = addAdvertisement(request);

//            }else if (request.getParameter("addAdvertisementAjax") != null) {
//                addAdvertisementAjax(request);


            }else if (request.getParameter("deleteAdvertisement") != null) {
                link = deleteAdvertisement(request);

            }else if (request.getParameter("deleteAdvertisementAjax") != null) {
                deleteAdvertisementAjax(request);



            } else {
                link = ERROR_PAGE;
            }
//            if (link != null){
            request.getRequestDispatcher(link).forward(request, response);
//            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            throw new ServletException(e);
        }
    }


    /**
     * USERS
     */

    protected String showUsers(HttpServletRequest request) throws IOException, ServletException {
        String link;
        try {
            request.setAttribute(USER_DTO, usersService.getAll());

            link = SHOW_ALL_USERS_PAGE;
        } catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }

    //TODO показ пользователю сообщения об ошибке (нет в базе)
    protected String showUserById(HttpServletRequest request) throws IOException, ServletException {
        String link;
        try {
            String idStr = request.getParameter(ID);
            if (attributes.validId(idStr).isEmpty()) {
                Integer id = Integer.valueOf(idStr);

                User user = usersService.getById(id);

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
    protected String updateUser(HttpServletRequest request) throws ServletException, IOException {
        String link;
        try {

            User user = new User();

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

                usersService.update(user);

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

    protected String insertUser(HttpServletRequest request) throws ServletException, IOException {
        String link;
        try {
            User user = new User();

            String fName = request.getParameter(FIRST_NAME);
            String sName = request.getParameter(SECOND_NAME);
            String birthDate = request.getParameter(BIRTH_DATE);
            String login = request.getParameter(LOGIN);
            String password = request.getParameter(PASSWORD);
            String eMail = request.getParameter(EMAIL);
            String phone = request.getParameter(PHONE);

            HashMap<String, String> dataErrorMap = attributes.validateInsertUser(fName, sName, birthDate, password, login, eMail, phone);
            if (dataErrorMap.isEmpty()) {
                user.setfName(fName);
                user.setsName(sName);
                user.setBirthDate(birthDate);
                user.setLogin(login);
                user.setPassword(password);
                user.seteMail(eMail);
                user.setPhone(phone);

                usersService.insert(user);

                request.setAttribute("fName", fName);
                request.setAttribute("sName", sName);
                request.setAttribute("birthDate", birthDate);
                request.setAttribute("eMail", eMail);
                request.setAttribute("password", password);
                request.setAttribute("login", login);
                request.setAttribute("phone", phone);
                link = REGISTRATION_SUCCESS_PAGE;
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
                link = RE_REGISTRATION_PAGE;
            }
        } catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }


    protected String deleteUser(HttpServletRequest request) throws ServletException, IOException {
        String link;
        try {
            String id = request.getParameter("idForDelete");
            if (attributes.validId(id).isEmpty()) {
                request.setAttribute("id", id);
                usersService.delete(Integer.parseInt(id));

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
    protected String userLogin(HttpServletRequest request) throws ServletException, IOException {
        String link;
        try {
            String login = request.getParameter(LOGIN);
            String password = request.getParameter(PASSWORD);

            HttpSession session = request.getSession(true);

            HashMap<String, String> dataErrorMap = attributes.validateLoginUser(login, password);

            if (dataErrorMap.isEmpty()) {
                User user = usersService.getByLoginAndPassword(login, password);

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
                link = RE_LOGIN_PAGE;
            }
        } catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }


    /**
     * RESTAURANTS
     */

    protected String showRestaurants(HttpServletRequest request) throws IOException, ServletException {
        String link;
        try {
//            request.setAttribute(RESTAURANT_DTO, restaurantsDao.getAll());

            request.setAttribute(RESTAURANT_DTO, restaurantsService.getAll());

            link = SHOW_ALL_RESTAURANTS_PAGE;
        } catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }


    protected String showRestaurantById(HttpServletRequest request) throws IOException, ServletException {
        String link;
        try {
            String idStr = request.getParameter(RESTAURANT_ID);
            if (attributes.validId(idStr).isEmpty()) {
                Integer id = Integer.valueOf(idStr);
                Restaurant restaurant = restaurantsService.getById(id);
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
    protected String updateRestaurant(HttpServletRequest request) throws IOException, ServletException {
        String link;
        try {
            Restaurant restaurant = new Restaurant();
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

                restaurantsService.update(restaurant);

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
    protected String insertRestaurant(HttpServletRequest request) throws ServletException, IOException {
        String link;
        try {
            Restaurant restaurant = new Restaurant();
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

                restaurantsService.insert(restaurant);

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

    protected String deleteRestaurant(HttpServletRequest request) throws ServletException, IOException {
        String link;
        try {
            String id = request.getParameter("restaurantIdForDelete");
            if (attributes.validId(id).isEmpty()) {
                request.setAttribute("id", id);
                restaurantsService.delete(Integer.parseInt(id));
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
     * ADVERTISEMENTS
     */

    protected String showAdvertisements(HttpServletRequest request) throws IOException, ServletException {
        String link;
        try {
            request.setAttribute(ADVERTISEMENT_DTO, advertisementsService.getAll());
            link = SHOW_ALL_ADVERTISEMENTS_PAGE;
        } catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
            link = ERROR_PAGE;
        }
        return link;
    }

    protected String showAdvertisementById(HttpServletRequest request) throws IOException, ServletException{
        String link;
        try {
            String idStr = request.getParameter(ADVERTISEMENT_ID);
            if (attributes.validId(idStr).isEmpty()){
                Integer id = Integer.valueOf(idStr);
                Advertisement advertisement = advertisementsService.getById(id);
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

    protected String addAdvertisement (HttpServletRequest request)throws ServletException, IOException{
        String link;
        try {
            Advertisement advertisement = new Advertisement();
            String offerText = request.getParameter(ADVERTISEMENT_TEXT);
            String restaurantId = request.getParameter(ADVERTISEMENT_OF_RESTAURANT_ID);
            HashMap<String, String> dataErrorMap = attributes.vaidateInsertAdvertisement(offerText, restaurantId);
            if (dataErrorMap.isEmpty()){
                advertisement.setOfferText(offerText);
                advertisement.setRestaurantId(Integer.valueOf(restaurantId));
                advertisementsService.insert(advertisement);
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
//
//
//    protected void addAdvertisementAjax (HttpServletRequest request)throws ServletException, IOException{
//        try {
//            Advertisement advertisement = new Advertisement();
//            String offerText = request.getParameter(ADVERTISEMENT_TEXT);
//            String restaurantId = request.getParameter(ADVERTISEMENT_OF_RESTAURANT_ID);
//            HashMap<String, String> dataErrorMap = attributes.vaidateInsertAdvertisement(offerText, restaurantId);
//            if (dataErrorMap.isEmpty()){
//                advertisement.setOfferText(offerText);
//                advertisement.setRestaurantId(Integer.valueOf(restaurantId));
//                advertisementsService.insert(advertisement);
//                request.setAttribute("offerText", offerText);
//                request.setAttribute("restaurantId", restaurantId);
//            }else {
//                request.setAttribute("offerText", offerText);
//                request.setAttribute("restaurantId", restaurantId);
//                request.setAttribute("errorsOfferText", dataErrorMap.get("offerText"));
//                request.setAttribute("errorsRestaurantId", dataErrorMap.get("id"));
//                request.setAttribute("nullErrors", "");
//                request.setAttribute("errors", dataErrorMap);
//            }
//        }catch (DaoException e) {
//            e.printStackTrace();
//            request.setAttribute("error", e);
//        }
//    }


    //TODO Исправить ошибку с удалением номера которого нет
    protected String deleteAdvertisement(HttpServletRequest request) throws IOException, ServletException{
        String link;
        try {
            String id = request.getParameter("advertisementIdForDelete");
            if(attributes.validId(id).isEmpty()){
                request.setAttribute("id", id);
                advertisementsService.delete(Integer.parseInt(id));
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

    protected void deleteAdvertisementAjax(HttpServletRequest request) throws IOException, ServletException{
        try {
            String id = request.getParameter("advertisementIdForDelete");
            if(attributes.validId(id).isEmpty()){
                request.setAttribute("id", id);
                advertisementsService.delete(Integer.parseInt(id));
            }else {
                request.setAttribute("advertisementId", id);
                request.setAttribute("errors", attributes.validId(id));
            }
        }catch (DaoException e) {
            e.printStackTrace();
            request.setAttribute("error", e);
        }
    }



}











