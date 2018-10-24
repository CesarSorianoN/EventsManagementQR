package com.ieee.entity;

import java.util.Date;

/**
 * Created by soric on 21/10/2018.
 */

public class Activity {

    private int id_activity;

    private int id_event;

    private int id_type_activity;

    private int QR_code;

    private Date start_date;

    private Date finish_date;

    private String location;

    private String speaker;

    private String description;

    public Activity(int id_activity, int id_event, int id_type_activity, int QR_code, Date start_date, Date finish_date, String location, String speaker, String description) {
        this.id_activity = id_activity;
        this.id_event = id_event;
        this.id_type_activity = id_type_activity;
        this.QR_code = QR_code;
        this.start_date = start_date;
        this.finish_date = finish_date;
        this.location = location;
        this.speaker = speaker;
        this.description = description;
    }

    public int getId_activity() {
        return id_activity;
    }

    public void setId_activity(int id_activity) {
        this.id_activity = id_activity;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_type_activity() {
        return id_type_activity;
    }

    public void setId_type_activity(int id_type_activity) {
        this.id_type_activity = id_type_activity;
    }

    public int getQR_code() {
        return QR_code;
    }

    public void setQR_code(int QR_code) {
        this.QR_code = QR_code;
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

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
