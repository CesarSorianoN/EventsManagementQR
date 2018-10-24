package com.ieee.daosImpl;

import com.ieee.conexion.BDConection;
import com.ieee.daos.UserEventDAO;
import com.ieee.entity.UserEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by soric on 21/10/2018.
 */

public class UserEventDAOImpl implements UserEventDAO {

    BDConection conex = new BDConection();

    @Override
    public void registerUserEvent(UserEvent userEvent) {
        try {
            Statement statement = conex.getConnection().createStatement();
            statement.executeUpdate("INSERT INTO usu_eve VALUES ('" + userEvent.getId_user() + "','" + userEvent.getId_event()
                    + "', '" + userEvent.getId_rol() + "', '" + userEvent.getDate_registry() + "')");
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
    public ArrayList<UserEvent> listUserEvent() {
        ArrayList<UserEvent> userEvents = new ArrayList<UserEvent>();

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM usu_eve");
            ResultSet res = consult.executeQuery();
            while (res.next()) {
                int id_user = res.getInt("id_usuario");
                int id_event = res.getInt("id_evento");
                int id_rol = res.getInt("id_rol");
                Date date = res.getDate("fecha_registro");
                UserEvent usEv = new UserEvent(id_user,id_event,id_rol,date);
                userEvents.add(usEv);
            }
            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de usuario\n" + e);
        }
        return userEvents;
    }

    @Override
    public UserEvent consultUserEvent(int id_user, int id_event, int id_rol) {

        UserEvent usEv = null;

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM usu_eve WHERE id_usuario = ? AND id_evento = ? AND id_rol = ' ");
            consult.setInt(1, id_user);
            consult.setInt(2,id_event);
            consult.setInt(3,id_rol);
            ResultSet res = consult.executeQuery();

            if (res.next()) {
                Date date = res.getDate("fecha_registro");
                usEv = new UserEvent(id_user,id_event,id_rol,date);
            }
            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de Usuario\n" + e);
        }
        return usEv;

    }


    @Override
    public void removeUserEvent(int id_user, int id_event, int id_rol) {

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("DELETE FROM usu_eve WHERE id_usuario = ? AND id_evento = ? AND id_rol = ?");
            consult.setInt(1, id_user);
            consult.setInt(2, id_user);
            consult.setInt(3, id_user);
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
