package com.ieee.daosImpl;

import com.ieee.conexion.BDConection;
import com.ieee.daos.ActivityDAO;
import com.ieee.entity.Activity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by soric on 21/10/2018.
 */

public class ActivityDAOImpl implements ActivityDAO {

    BDConection conex = new BDConection();

    @Override
    public void registerActivity(Activity activity) {
        try {
            Statement statement = conex.getConnection().createStatement();
            statement.executeUpdate("INSERT INTO actividad VALUES ('" + activity.getId_activity() + "','" + activity.getId_event()
                    + "', '" + activity.getId_type_activity() + "', '" + activity.getQR_code() + "', '"
                    + activity.getStart_date() + "', '" + activity.getFinish_date() + "', '" + activity.getFinish_date()
                    + "', '" + activity.getLocation() +"', '" + activity.getSpeaker() +"', '" + activity.getDescription() + "')");

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
    public ArrayList<Activity> listActivity() {
        ArrayList<Activity> activities = new ArrayList<Activity>();

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM actividad");
            ResultSet res = consult.executeQuery();
            while (res.next()) {
                int id_activity = res.getInt("id_actividad");
                int id_event = res.getInt("id_evento");
                int id_type_activity = res.getInt("id_tipo_actividad");
                int qr = res.getInt("codigo_QR");
                Date dateStart = res.getDate("fechaInicio");
                Date dateFinish = res.getDate("fechaFin");
                String location = res.getString("ubicacion");
                String speaker = res.getString("nom_conferencista");
                String description = res.getString("descripcion");
                Activity activity = new Activity(id_activity,id_event,id_type_activity,qr,dateStart,dateFinish,location,speaker,description);
                activities.add(activity);
            }
            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de usuario\n" + e);
        }
        return activities;
    }

    @Override
    public Activity consultActivity(int id_activity) {
        Activity activity = null;
        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM actividad WHERE id_actividad = ? ");
            consult.setInt(1, id_activity);
            ResultSet res = consult.executeQuery();

            if (res.next()) {
                int id = res.getInt("id_actividad");
                int id_event = res.getInt("id_evento");
                int id_type_activity = res.getInt("id_tipo_actividad");
                int qr = res.getInt("codigo_QR");
                Date dateStart = res.getDate("fechaInicio");
                Date dateFinish = res.getDate("fechaFin");
                String location = res.getString("ubicacion");
                String speaker = res.getString("nom_conferencista");
                String description = res.getString("descripcion");
                activity = new Activity(id,id_event,id_type_activity,qr,dateStart,dateFinish,location,speaker,description);
            }
            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de Usuario\n" + e);
        }
        return activity;

    }

    @Override
    public void updateActivity(Activity activity) {

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("UPDATE actividad SET fechaInicio = ?,fechaFin = ?," +
                    " ubicacion = ?, nom_conferencista = ?, descripcion = ? WHERE id_actividad= ?");
            consult.setDate(1, (java.sql.Date) activity.getStart_date());
            consult.setDate(2,(java.sql.Date) activity.getFinish_date());
            consult.setString(3,activity.getLocation());
            consult.setString(4,activity.getSpeaker());
            consult.setString(5,activity.getDescription());
            consult.setInt(6, activity.getId_activity());
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
    public void removeActivity(int id_activity) {

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("DELETE FROM actividad WHERE id_actividad = ?");
            consult.setInt(1, id_activity);
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
