package com.ieee.entity;

/**
 * Created by soric on 21/10/2018.
 */

public class Career {

    private int id_career;
    private String name_career;

    public Career(int id_career, String name_career) {
        this.id_career = id_career;
        this.name_career = name_career;
    }

    public int getId_career() {
        return id_career;
    }

    public void setId_career(int id_career) {
        this.id_career = id_career;
    }

    public String getName_career() {
        return name_career;
    }

    public void setName_career(String name_career) {
        this.name_career = name_career;
    }
}
