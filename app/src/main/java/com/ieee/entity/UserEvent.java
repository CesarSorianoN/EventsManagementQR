package com.ieee.entity;

import java.util.Date;

/**
 * Created by soric on 21/10/2018.
 */

public class UserEvent {
    private int id_user;
    private int id_event;
    private int id_rol;
    private Date date_registry;

    public UserEvent(int id_user,int id_event,int id_rol, Date date_registry){

        this.id_user = id_user;
        this.id_event = id_event;
        this.id_rol = id_rol;
        this.date_registry = date_registry;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public Date getDate_registry() {
        return date_registry;
    }

    public void setDate_registry(Date date_registry) {
        this.date_registry = date_registry;
    }
}
