package com.ieee.daos;

import com.ieee.entity.User;

import java.util.ArrayList;

/**
 * Created by soric on 21/10/2018.
 */

public interface UserDAO {

    void registerUser(User user);

     ArrayList<User> listUser();

     User consultUser(String name);

     void updateUser(User user);

     void removeUser(int id_user);

}
