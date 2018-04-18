package com.java.lesson.restaurant.reservation.dto;

import javax.persistence.*;

/**
 * Created by UserDto on 02.03.2018.
 *
 * @author Igor Iv.
 */
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @Column(name = "restaurant_id", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "rest_name", nullable = false, insertable = true, updatable = true)
    String name;

    @Column(name = "rest_city", nullable = false, insertable = true, updatable = true)
    String city;

    @Column(name = "rest_district", nullable = false, insertable = true, updatable = true)
    String district;

    @Column(name = "rest_street", nullable = false, insertable = true, updatable = true)
    String street;

    @Column(name = "house_number", nullable = false, insertable = true, updatable = true)
    String houseNumber;

    @Column(name = "rest_phone", nullable = false, insertable = true, updatable = true)
    String phone;

    @Column(name = "rest_describe", nullable = false, insertable = true, updatable = true)
    String describe;

    @Column(name = "rest_photo", nullable = true, insertable = true, updatable = true)
    String photo;

    public Restaurant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Restaurant that = (Restaurant) obj;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (district != null ? !district.equals(that.district) : that.district != null) return false;
        if (street!= null ? !street.equals(that.street) : that.street != null) return false;
        if (houseNumber != null ? !houseNumber.equals(that.houseNumber) : that.houseNumber!= null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (describe != null ? !describe.equals(that.describe) : that.describe != null) return false;
        if (photo != null ? !photo.equals(that.photo) : that.photo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name!= null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (houseNumber != null ? houseNumber.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (describe != null ? describe.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", describe='" + describe + '\'' +
                ", photo='" + photo;
    }
}
