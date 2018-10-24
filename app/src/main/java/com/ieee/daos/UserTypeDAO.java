package com.ieee.daos;

import com.ieee.entity.UserType;

import java.util.ArrayList;

/**
 * Created by soric on 21/10/2018.
 */

public interface UserTypeDAO {

    void registerUserType(UserType userType);

    ArrayList<UserType> listUserType();

    UserType consultUserType(int id_userType);

    void updateUserType(UserType userType);

    void removeUserType(int id_userType);

}
