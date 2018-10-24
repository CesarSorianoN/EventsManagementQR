package com.ieee.daos;

import com.ieee.entity.Event;

import java.util.ArrayList;

/**
 * Created by soric on 21/10/2018.
 */

public interface EventDAO {
    void registerEvent(Event event);

    ArrayList<Event> listEvent();

    Event consultEvent(int id_event);

    void updateEvent(Event event);

    void removeEvent(int id_Event);

}
