package com.ieee.entity;

/**
 * Created by soric on 21/10/2018.
 */

public class TypeActivity {
    private int id_type_activity;
    private String name_type_activity;

    public TypeActivity(int id_type_activity, String name_type_activity){
        this.id_type_activity = id_type_activity;
        this.name_type_activity = name_type_activity;
    }

    public int getId_type_activity() {
        return id_type_activity;
    }

    public void setId_type_activity(int id_type_activity) {
        this.id_type_activity = id_type_activity;
    }

    public String getName_type_activity() {
        return name_type_activity;
    }

    public void setName_type_activity(String name_type_activity) {
        this.name_type_activity = name_type_activity;
    }
}
