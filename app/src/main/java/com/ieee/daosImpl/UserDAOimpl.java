package com.ieee.daosImpl;


import android.util.Log;

import com.ieee.conexion.BDConection;
import com.ieee.daos.UserDAO;
import com.ieee.entity.User;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by soric on 21/10/2018.
 */

public class UserDAOimpl implements UserDAO {
    BDConection conex = new BDConection();


    @Override
    public void registerUser(User user) {
        try {
            Statement statement = conex.getConnection().createStatement();
            statement.executeUpdate("INSERT INTO usuario VALUES ('" + user.getId_user() + "','" + user.getPassword()
                    + "', '" + user.getName_user() + "', '" + user.getId_user_type() + "', '"
                    + user.getMail() + "', '" + user.getId_career() + "')");
            //JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información",
                    //JOptionPane.INFORMATION_MESSAGE);
            Log.d("W","Se ha registrado Exitosamente");
            statement.close();
            conex.desconectar();

        } catch (SQLException e) {
            Log.d("E",e.getMessage());
            Log.d("E","No se Registró el usuario");
            //System.out.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "No se Registró el usuario");
        }

    }

    @Override
    public ArrayList<User> listUser() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM usuario");
            ResultSet res = consult.executeQuery();
            while (res.next()) {
                int id = res.getInt("id_usuario");
                String password = res.getString("contraseña");
                String name = res.getString("nom_usuario");
                int idTypeUser = res.getInt("id_tipo_usuario");
                String mail = res.getString("correo");
                int idCareer = res.getInt("id_carrera");
                User user = new User(id,name,password,idTypeUser,mail,idCareer);
                users.add(user);
            }
            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de usuario\n" + e);
            Log.d("E","no se pudo consultar el registro de usuario\n" + e);
        }
        return users;
    }

    @Override
    public User consultUser(String name) {
        User user = null;
        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM usuario WHERE nom_usuario = ? ");
            consult.setString(1, name);
            ResultSet res = consult.executeQuery();

            if (res.next()) {
                int id = res.getInt("id_usuario");
                String password = res.getString("contraseña");
                int idTypeUser = res.getInt("id_tipo_usuario");
                String mail = res.getString("correo");
                int idCareer = res.getInt("id_carrera");
                user = new User(id,name,password,idTypeUser,mail,idCareer);
            }
            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de Usuario\n" + e);
            Log.d("E","no se pudo consultar el registro de Usuario\n" + e);
        }
        return user;

    }

    @Override
    public void updateUser(User user) {

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("UPDATE usuario SET contraseña= ? WHERE id_usuario= ?");
            consult.setString(1, user.getPassword());
            consult.setInt(3, user.getId_user());
            int res = consult.executeUpdate();
            if(res>0)
                //JOptionPane.showMessageDialog(null, "Se ha Actualizado Exitosamente");
                Log.d("W","Se ha Actualizado Exitosamente");
            consult.close();
            conex.desconectar();
        } catch (SQLException e) {
           // System.out.println(e.getMessage());
            Log.d("W",e.getMessage());
            Log.d("W","No se Actualizó el usuario");

            //JOptionPane.showMessageDialog(null, "No se Actualizó el usuario");
        }

    }

    @Override
    public void removeUser(int id_user) {

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");
            consult.setInt(1, id_user);
            int res = consult.executeUpdate();
            if(res>0) {
                //JOptionPane.showMessageDialog(null, "El proceso fue exitoso");
                Log.d("W","El proceso fue exitoso");
            }
            consult.close();
            conex.desconectar();
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            Log.d("E",e.getMessage());
            Log.d("E","No se Actualizó el usuario");

            //JOptionPane.showMessageDialog(null, "No se Actualizó el usuario");
        }

    }
}
