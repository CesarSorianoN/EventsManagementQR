package com.ieee.daos;

import com.ieee.entity.Rol;

import java.util.ArrayList;

/**
 * Created by soric on 21/10/2018.
 */

public interface RolDAO {

    void registerRol(Rol rol);

    ArrayList<Rol> listRol();

    Rol consultRol(int id_rol);

    void updateRol(Rol rol);

    void removeRol(int id_rol);

}
