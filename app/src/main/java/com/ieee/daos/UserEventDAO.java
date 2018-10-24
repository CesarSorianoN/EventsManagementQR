package com.ieee.daos;

import com.ieee.entity.UserEvent;

import java.util.ArrayList;

/**
 * Created by soric on 21/10/2018.
 */

public interface UserEventDAO {
    void registerUserEvent(UserEvent userEvent);

    ArrayList<UserEvent> listUserEvent();

    UserEvent consultUserEvent(int id_user, int id_event, int id_rol);

    void removeUserEvent(int id_user, int id_event, int id_rol);

}
