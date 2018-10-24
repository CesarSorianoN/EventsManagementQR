package com.ieee.daos;

import com.ieee.entity.TypeActivity;

import java.util.ArrayList;

/**
 * Created by soric on 21/10/2018.
 */

public interface TypeActivityDAO {
    void registerTypeActivity(TypeActivity typeActivity);

    ArrayList<TypeActivity> listTipeActivity();

    TypeActivity consultTypeActivity(int id_typeActivity);

    void updateTypeActivity(TypeActivity typeActivity);

    void removeUser(int id_typeActivity);

}
