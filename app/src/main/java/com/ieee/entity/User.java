package com.ieee.entity;

/**
 * Created by soric on 21/10/2018.
 */

public class User {

    private int id_user;

    private String name_user;

    private String password;

    private int id_user_type;

    private String mail;

    private int id_career;

    public User(int id_user, String name_user,String password,int id_user_type,String mail, int id_career){
        this.id_user =id_user;
        this.name_user = name_user;
        this.password = password;
        this.id_user_type = id_user_type;
        this.mail = mail;
        this.id_career = id_career;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_user_type() {
        return id_user_type;
    }

    public void setId_user_type(int id_user_type) {
        this.id_user_type = id_user_type;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getId_career() {
        return id_career;
    }

    public void setId_career(int id_career) {
        this.id_career = id_career;
    }
}
