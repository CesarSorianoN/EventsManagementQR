package com.ieee.daos;

import com.ieee.entity.Activity;

import java.util.ArrayList;

/**
 * Created by soric on 21/10/2018.
 */

public interface ActivityDAO {

    void registerActivity(Activity activity);

    ArrayList<Activity> listActivity();

    Activity consultActivity(int id_activity);

    void updateActivity(Activity activity);

    void removeActivity(int id_activity);

}
