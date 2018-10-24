package com.ieee.entity;

/**
 * Created by soric on 21/10/2018.
 */

public class UserType {

    private int id_user;
    private String name_user_type;

    public UserType(int id_user, String name_user_type){
        this.id_user = id_user;
        this.name_user_type = name_user_type;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName_user_type() {
        return name_user_type;
    }

    public void setName_user_type(String name_user_type){
        this.name_user_type = name_user_type;
    }
}
