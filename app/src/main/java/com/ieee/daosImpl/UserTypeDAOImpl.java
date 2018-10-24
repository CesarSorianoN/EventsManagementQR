package com.ieee.daosImpl;

import com.ieee.conexion.BDConection;
import com.ieee.daos.UserTypeDAO;
import com.ieee.entity.UserType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by soric on 21/10/2018.
 */

public class UserTypeDAOImpl implements UserTypeDAO {

    BDConection conex = new BDConection();

    @Override
    public void registerUserType(UserType userType) {
        try {
            Statement statement = conex.getConnection().createStatement();
            statement.executeUpdate("INSERT INTO tipo_usuario VALUES ('" + userType.getId_user() + "','" + userType.getName_user_type() +  "')");
            //JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información",
            //JOptionPane.INFORMATION_MESSAGE);
            statement.close();
            conex.desconectar();

        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "No se Registró el usuario");
        }

    }

    @Override
    public ArrayList<UserType> listUserType() {
        ArrayList<UserType> userTypes = new ArrayList<UserType>();

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM tipo_usuario");
            ResultSet res = consult.executeQuery();
            while (res.next()) {
                int id = res.getInt("id_tipo_usuario");
                String name = res.getString("nom_tipo_usuario");
                UserType userType = new UserType(id,name);
                userTypes.add(userType);
            }
            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de usuario\n" + e);
        }
        return userTypes;
    }

    @Override
    public UserType consultUserType(int id_userType) {
        UserType userType = null;

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM tipo_usuario WHERE id_tipo_usuario = ? ");
            consult.setInt(1, id_userType);
            ResultSet res = consult.executeQuery();

            if (res.next()) {
                int id = res.getInt("id_tipo_usuario");
                String name = res.getString("nom_tipo_usuario");
                userType = new UserType(id,name);
            }
            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de Usuario\n" + e);
        }
        return userType;

    }

    @Override
    public void updateUserType(UserType userType) {

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("UPDATE tipo_usuario SET nom_tipo_usuario= ? WHERE id_tipo_usuario= ?");
            consult.setString(1, userType.getName_user_type());
            consult.setInt(3, userType.getId_user());
            int res = consult.executeUpdate();
            if(res>0)
                //JOptionPane.showMessageDialog(null, "Se ha Actualizado Exitosamente");
                consult.close();
            conex.desconectar();
        } catch (SQLException e) {
            // System.out.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "No se Actualizó el usuario");
        }

    }

    @Override
    public void removeUserType(int id_userType) {

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("DELETE FROM tipo_usuario WHERE id_tipo_usuario = ?");
            consult.setInt(2, id_userType);
            int res = consult.executeUpdate();
            if(res>0) {
                //JOptionPane.showMessageDialog(null, "El proceso fue exitoso");
            }
            consult.close();
            conex.desconectar();
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "No se Actualizó el usuario");
        }

    }
}
