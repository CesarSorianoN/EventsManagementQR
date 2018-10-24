package com.ieee.daosImpl;

import com.ieee.conexion.BDConection;
import com.ieee.daos.EventDAO;
import com.ieee.entity.Event;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by soric on 21/10/2018.
 */

public class EventDAOImpl implements EventDAO {

    BDConection conex = new BDConection();

    @Override
    public void registerEvent(Event event) {
        try {
            Statement statement = conex.getConnection().createStatement();
            statement.executeUpdate("INSERT INTO evento VALUES ('" + event.getId_event() + "','" + event.getName()
                    + "', '" + event.getStart_date() + "', '" + event.getLocation() + "', '"
                    + event.getFinish_date() +  "')");
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
    public ArrayList<Event> listEvent() {
        ArrayList<Event> events = new ArrayList<Event>();

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM evento");
            ResultSet res = consult.executeQuery();
            while (res.next()) {
                int id_event = res.getInt("id_evento");
                String name = res.getString("nombre");
                Date startDate = res.getDate("fecha_inicio");
                Date finishDate = res.getDate("fechaFin");
                String location = res.getString("ubicacion");
                Event event = new Event(id_event,name,startDate,finishDate,location);
               events.add(event);
            }
            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de usuario\n" + e);
        }
        return events;
    }

    @Override
    public Event consultEvent(int id_event) {
        Event event = null;

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM evento WHERE id_evento = ? ");
            consult.setInt(1, id_event);
            ResultSet res = consult.executeQuery();

            if (res.next()) {
                String name = res.getString("nombre");
                Date startDate = res.getDate("fecha_inicio");
                Date finishDate = res.getDate("fechaFin");
                String location = res.getString("ubicacion");
                event = new Event(id_event,name,startDate,finishDate,location);
            }
            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de Usuario\n" + e);
        }
        return event;

    }

    @Override
    public void updateEvent(Event event) {

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("UPDATE evento SET nombre= ?,fecha_inicio = ?, ubicacion = ?," +
                    "fechaFin = ? WHERE id_evento= ?");
            consult.setString(1, event.getName());
            consult.setDate(2, (java.sql.Date) event.getStart_date());
            consult.setString(3, event.getLocation());
            consult.setDate(4, (java.sql.Date) event.getFinish_date());
            consult.setInt(5, event.getId_event());
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
    public void removeEvent(int id_Event) {

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("DELETE FROM evento WHERE id_evento = ?");
            consult.setInt(1, id_Event);
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
