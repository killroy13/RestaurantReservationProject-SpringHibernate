package com.java.lesson.restaurant.reservation.dto;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by UserDto on 02.03.2018.
 * @author Igor Iv.
 */
public class User extends Model {
    String fName;
    String sName;
    String birthDate;
    String login;
    String password;
    String eMail;
    String phone;

    public User() {
    }

    public User(int id, String f_name, String s_name, String birth_day, String login, String password, String e_mail, String phone){
        this.id = id;
        this.fName = f_name;
        this.sName = s_name;
        this.birthDate = birth_day;
        this.login = login;
        this.password = password;
        this.eMail = e_mail;
        this.phone = phone;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "\n" +
                "user_id=" + id +
                ", fName=" + fName +
                ", sName=" + sName +
                ", birthDate=" + birthDate +
                ", login=" + login +
                ", password=" + password +
                ", eMail=" + eMail +
                ", phone=" + phone;
    }


//    public boolean validate() {
//        boolean allOk=true;
//        if (fName.equals("")) {
//            errors.put("firstName","Please enter your first name");
//            firstName="";
//            allOk=false;
//        }
//        if (lastName.equals("")) {
//            errors.put("lastName","Please enter your last name");
//            lastName="";
//            allOk=false;
//        }
//        if (email.equals("") || (email.indexOf('@') == -1)) {
//            errors.put("email","Please enter a valid email address");
//            email="";
//            allOk=false;
//        }
//        if (password1.equals("") ) {
//            errors.put("password","Please enter a valid password");
//            password1="";
//            allOk=false;
//        }
//        return allOk;
//    }



}
