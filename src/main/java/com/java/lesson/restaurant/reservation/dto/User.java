package com.java.lesson.restaurant.reservation.dto;


import javax.persistence.*;

/**
 * Created by UserDto on 02.03.2018.
 * @author Igor Iv.
 */

//TODO extends Model
@Entity
@Table(name = "users")
public class User/* extends Model*/ {

    @Id
    @Column(name = "users_id", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "user_name", nullable = false, insertable = true, updatable = true)
    String fName;

    @Column(name = "last_name", nullable = false, insertable = true, updatable = true)
    String sName;

    @Column(name = "user_birth", nullable = false, insertable = true, updatable = true)
    String birthDate;

    @Column(name = "login", nullable = false, insertable = true, updatable = true)
    String login;

    @Column(name = "password", nullable = false, insertable = true, updatable = true)
    String password;

    @Column(name = "user_email", nullable = false, insertable = true, updatable = true)
    String eMail;

    @Column(name = "user_phone", nullable = false, insertable = true, updatable = true)
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        User that = (User) obj;

        if (id != that.id) return false;
        if (fName != null ? !fName.equals(that.fName) : that.fName != null) return false;
        if (sName != null ? !sName.equals(that.sName) : that.sName != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (login != null ? !login.equals(that.login) : that.login!= null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (eMail != null ? !eMail.equals(that.eMail) : that.eMail != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fName!= null ? fName.hashCode() : 0);
        result = 31 * result + (sName != null ? sName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
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
}
