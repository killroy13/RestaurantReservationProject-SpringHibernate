package com.java.lesson.restaurant.reservation.attributes;

import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Created by User on 11.03.2018.
 */
public class Attributes {

    public Attributes() {
    }

    /**
    * ADVERTISEMENT'S ATTRIBUTE
     */
    public static final String ADVERTISEMENTS_DAO = "advertisementsDao";
    public static final String ADVERTISEMENT_DTO = "advertisements";
    public static final String ADVERTISEMENT_MODEL_TO_VIEW = "advertisement";

    /*ADVERTISEMENT DATA*/
    public static final String ADVERTISEMENT_ID = "id";
    public static final String ADVERTISEMENT_TEXT = "offerText";
    public static final String ADVERTISEMENT_OF_RESTAURANT_ID= "restaurantId";

    /*JSP ADVERTISEMENT PAGES*/
    public static final String SHOW_ALL_ADVERTISEMENTS_PAGE = "/jsp/showAdvertisements.jsp";
    public static final String ADVERTISEMENT_PAGE = "jsp/advertisement.jsp";
    /*подумать о надобности этих ф-ций*/
//    public static final String EDIT_ADVERTISEMENT_PAGE = "jsp/editAdvertisement.jsp";
//    public static final String RE_EDIT_ADVERTISEMENT_PAGE = "jsp/reEditAdvertisement.jsp";
//    public static final String SUCCESS_EDIT_ADVERTISEMENT_PAGE = "jsp/successEditAdvertisement.jsp";
    public static final String RE_ADD_ADVERTISEMENT_PAGE = "jsp/reAddAdvertisement.jsp";
    public static final String ADD_ADVERTISEMENT_SUCCESS_PAGE = "jsp/successAddAdvertisement.jsp";
    public static final String SUCCESS_DELETE_ADVERTISEMENT_PAGE = "jsp/deleteAdvertisement.jsp";


    /**
     * RESTAURANT'S ATTRIBUTE
     */
    public static final String RESTAURANTS_DAO = "restaurantsDao";
    public static final String RESTAURANT_DTO = "restaurants";
    public static final String RESTAURANT_MODEL_TO_VIEW = "restaurant";

    /*RESTAURANT DATA*/
    public static final String RESTAURANT_ID = "id";
    public static final String RESTAURANT_NAME = "restName";
    public static final String RESTAURANT_CITY = "restCity";
    public static final String RESTAURANT_DISTRICT = "restDistrict";
    public static final String RESTAURANT_STREET = "restStreet";
    public static final String HOUSE_NUMBER = "houseNumber";
    public static final String RESTAURANT_PHONE = "restPhone";
    public static final String RESTAURANT_DESCRIBE = "restDescribe";
    public static final String RESTAURANT_PHOTO = "restPhoto";

    /*JSP RESTAURANT PAGES*/
    public static final String SHOW_ALL_RESTAURANTS_PAGE = "/jsp/showRestaurants.jsp";
    public static final String RESTAURANT_PAGE = "jsp/restaurant.jsp";
    public static final String EDIT_RESTAURANT_PAGE = "jsp/editRestaurant.jsp";
    public static final String RE_EDIT_RESTAURANT_PAGE = "jsp/reEditRestaurant.jsp";
    public static final String SUCCESS_EDIT_RESTAURANT_PAGE = "jsp/successEditRestaurant.jsp";
    public static final String RE_ADD_RESTAURANT_PAGE = "jsp/reAddRestaurant.jsp";
    public static final String ADD_RESTAURANT_SUCCESS_PAGE = "jsp/successAddRestaurant.jsp";
    public static final String SUCCESS_DELETE_RESTAURANT_PAGE = "jsp/deleteRestaurant.jsp";

    /**
     * USER'S ATTRIBUTE
     */
    public static final String USERS_DAO = "usersDao";
    public static final String USER_DTO = "users";
    public static final String USER_MODEL_TO_VIEW = "user";

    /*USER DATA*/
    public static final String ID = "id";
    public static final String FIRST_NAME = "firstName";
    public static final String SECOND_NAME = "secondName";
    public static final String BIRTH_DATE = "birthDate";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";

    /*JSP USER PAGES*/
    public static final String MAIN_PAGE = "/index.jsp";
    public static final String ERROR_PAGE = "../error/error.jsp";
    public static final String SHOW_ALL_USERS_PAGE = "/jsp/showUsers.jsp";
    public static final String LOGIN_SUCCESS_PAGE = "/jsp/form/successLogin.jsp";
    public static final String RE_LOGIN_PAGE = "/jsp/form/reLogin.jsp";
    public static final String USER_PAGE = "jsp/user.jsp";
    public static final String EDIT_USER_PAGE = "jsp/editUser.jsp";
    public static final String RE_EDIT_USER_PAGE = "jsp/reEditUser.jsp";
    public static final String SUCCESS_EDIT_USER_PAGE = "jsp/successEditUser.jsp";
    public static final String RE_REGISTRATION_PAGE = "jsp/reRegistration.jsp";
    public static final String REGISTRATION_SUCCESS_PAGE = "jsp/successRegistration.jsp";
    public static final String SUCCESS_DELETE_USER_PAGE = "jsp/deleteUser.jsp";



    /**
     * ORDER'S ATTRIBUTE
     */

    /**
     * REVIEWS ATTRIBUTE
     */



    /*VALIDATIONS USER*/
    public static final String ID_VALIDATION = "\\d+";

    //Имя пользователя (с ограничением 2-20 символов, которыми могут быть буквы и цифры, первый символ обязательно буква)
    public static final String NAME_VALIDATION = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";

    //Дата в формате YYYY-MM-DD:   //
    public static final String DATE_VALIDATION = "[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])";
//    public static final String DATE_VALIDATION2 = "(19|20)\\d\\d-((0[1-9]|1[012])-(0[1-9]|[12]\\d)|(0[13-9]|1[012])-30|(0[13578]|1[02])-31)";

    //Набор из букв и цифр (латиница + кириллица)а-яА-ЯёЁa-
//    public static final String PASSWORD_VALIDATION = "";
//    public static final String LOGIN_VALIDATION = "";

    public static final String PHONE_VALIDATION = "[0-9]{3}-[0-9]{2}-[0-9]{3}-[0-9]{2}-[0-9]{2}";





    /*VALIDATIONS ADVERTISEMENT*/
    public HashMap<String, String> vaidateInsertAdvertisement(String offerText, String restaurantId){
        HashMap<String, String> errors = new HashMap<>();
        validateOfferText(offerText, errors);
        validateId(restaurantId, errors);
        return errors;
    }

//    public HashMap<String, String> validateUpdateRestaurant(String id, String name, String city, String district, String street, String houseNumber, String phone, String describe, String photo) {
//        HashMap<String, String> errors = new HashMap<>();
//        validateId(id, errors);
//        validateName(name, errors);
//        validateCity(city, errors);
//        validateDistrict(district, errors);
//        validateStreet(street, errors);
//        validateHouseNumber(houseNumber, errors);
//        validatePhoneNumber(phone, errors);
//        validateDescribe(describe, errors);
//        return errors;
//    }


    /*VALIDATIONS RESTAURANT*/
    public HashMap<String, String> validateUpdateRestaurant(String id, String name, String city, String district, String street, String houseNumber, String phone, String describe, String photo) {
        HashMap<String, String> errors = new HashMap<>();
        validateId(id, errors);
        validateName(name, errors);
        validateCity(city, errors);
        validateDistrict(district, errors);
        validateStreet(street, errors);
        validateHouseNumber(houseNumber, errors);
        validatePhoneNumber(phone, errors);
        validateDescribe(describe, errors);
//        validatePhoto();
        return errors;
    }

    public HashMap<String, String> vaidateInsertRestaurant(String name, String city, String district, String street, String houseNumber, String phone, String describe, String photo){
        HashMap<String, String> errors = new HashMap<>();
        validateName(name, errors);
        validateCity(city, errors);
        validateDistrict(district, errors);
        validateStreet(street, errors);
        validateHouseNumber(houseNumber, errors);
        validatePhoneNumber(phone, errors);
        validateDescribe(describe, errors);
        return errors;
    }


    /*VALIDATIONS USER*/
    public HashMap<String, String> validId(String id) {
        HashMap<String, String> errors = new HashMap<>();
        validateId(id, errors);
        return errors;
    }

//    public HashMap<String, String> validLogin(String login) {
//        HashMap<String, String> errors = new HashMap<>();
//        validateId(login, errors);
//        return errors;
//    }
//
//    public HashMap<String, String> validPassword(String password) {
//        HashMap<String, String> errors = new HashMap<>();
//        validateId(password, errors);
//        return errors;
//    }

    public HashMap<String, String> validateLoginUser(String login, String password) {
        HashMap<String, String> errors = new HashMap<>();
        validateLogin(login, errors);
        validatePassword(password, errors);
        return errors;
    }

    public HashMap<String, String> validateUpdateUser(String id, String fName, String sName, String birthDate, String login, String password, String eMail, String phone) {
        HashMap<String, String> errors = new HashMap<>();
        validateId(id, errors);
        validateFName(fName, errors);
        validateSName(sName, errors);
        validateBirthDate(birthDate, errors);
        validateLogin(login, errors);
        validatePassword(password, errors);
        validateEmail(eMail, errors);
        validatePhoneNumber(phone, errors);
        return errors;
    }

    public HashMap<String, String> validateInsertUser(String fName, String sName, String birthDate, String password, String login, String eMail, String phone) {
        HashMap<String, String> errors = new HashMap<>();
        validateFName(fName, errors);
        validateSName(sName, errors);
        validateBirthDate(birthDate, errors);
        validateLogin(login, errors);
        validatePassword(password, errors);
        validateEmail(eMail, errors);
        validatePhoneNumber(phone, errors);
        return errors;
    }

    //TODO     /*id.equals("") &&*/   проверку на пустое поле
    public void validateId(String id, HashMap<String, String> errors) {
        if (!Pattern.compile(ID_VALIDATION).matcher(id).matches()) {
            errors.put("id", "Id value can only be positive number and not empty");
        }
    }

    public void validateFName(String name, HashMap<String, String> errors) {
        if (!Pattern.compile(NAME_VALIDATION).matcher(name).matches()) {
            errors.put("fName", "Name must have between 2 and 20 characters and not empty.");
        }
    }



    /*USERS FIELDS*/
    public void validateSName(String name, HashMap<String, String> errors) {
        if (!Pattern.compile(NAME_VALIDATION).matcher(name).matches()) {
            errors.put("sName", "Name must have between 2 and 20 characters and not empty.");
        }
    }

    public void validateBirthDate(String birthDate, HashMap<String, String> errors) {
        if (!Pattern.compile(DATE_VALIDATION).matcher(birthDate).matches()) {
            errors.put("birthDate", "Дата в формате YYYY-MM-DD and not empty");
        }
    }

    public void validatePhoneNumber(String phone, HashMap<String, String> errors) {
        if (!Pattern.compile(PHONE_VALIDATION).matcher(phone).matches()) {
            errors.put("phone", "Телефон в формате 375-**-***-**-** and not empty");
        }
    }

    public void validatePassword(String password, HashMap<String, String> errors) {
//        if (!Pattern.compile(PASSWORD_VALIDATION).matcher(password).matches()) {
        if (password.equals("")) {
            errors.put("password", "Password is not specified");
        }
    }

    public void validateLogin(String login, HashMap<String, String> errors) {
//        if (!Pattern.compile(LOGIN_VALIDATION).matcher(login).matches()) {
        if (login.equals("")) {
            errors.put("login", "Login is not specified");
        }
    }

    public void validateEmail(String eMail, HashMap<String, String> errors) {
//        if (!Pattern.compile(LOGIN_VALIDATION).matcher(login).matches()) {
        if (eMail.equals("")) {
            errors.put("eMail", "Not empty");
        }
    }


    /*ADVERTISEMENTS FIELDS*/
    public void validateOfferText (String offerText, HashMap<String, String> errors){
        if (offerText.equals("")){
            errors.put("offerText", "Not empty");
        }
    }



    /*RESTAURANTS FIELDS*/
    public void validateName(String name, HashMap<String, String> errors) {
        if (name.equals("")) {
            errors.put("name", "Not empty");
        }
    }

    public void validateCity(String city, HashMap<String, String> errors) {
        if (city.equals("")) {
            errors.put("city", "Not empty");
        }
    }

    public void validateDistrict(String district, HashMap<String, String> errors) {
        if (district.equals("")) {
            errors.put("district", "Not empty");
        }
    }

    public void validateStreet(String street, HashMap<String, String> errors) {
        if (street.equals("")) {
            errors.put("street", "Not empty");
        }
    }

    public void validateHouseNumber(String houseNumber, HashMap<String, String> errors) {
        if (houseNumber.equals("")) {
            errors.put("houseNumber", "Not empty");
        }
    }

    public void validateDescribe(String describe, HashMap<String, String> errors) {
        if (describe.equals("")) {
            errors.put("describe", "Not empty");
        }
    }

    //TODO доделать валидацию по размеру загружаемого фото (после перестройки форматов данных для фото (хранение))
    public void validatePhoto(String photo, HashMap<String, String> errors) {
        if (photo.equals("")) {
            errors.put("photo", "Not empty");
        }
    }
}