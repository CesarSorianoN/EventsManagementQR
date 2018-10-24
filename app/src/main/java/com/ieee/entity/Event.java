package com.ieee.entity;

import java.util.Date;

/**
 * Created by soric on 21/10/2018.
 */

public class Event {

    private int id_event;
    private String name;
    private Date start_date;
    private Date finish_date;
    private String location;

    public Event(int id_event, String name, Date start_date, Date finish_date, String location) {
        this.id_event = id_event;
        this.name = name;
        this.start_date = start_date;
        this.finish_date = finish_date;
        this.location = location;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(Date finish_date) {
        this.finish_date = finish_date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
