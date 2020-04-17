package com.lec.android.a008_recycler;

import java.io.Serializable;

public class Phonebook implements Serializable {
    int photo;
    String name;
    String phone;
    String email;

    public Phonebook(int photo, String name, String phone, String email) {
        this.photo = photo;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
