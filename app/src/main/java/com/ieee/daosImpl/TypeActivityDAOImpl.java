package com.ieee.daosImpl;

import com.ieee.conexion.BDConection;
import com.ieee.daos.TypeActivityDAO;
import com.ieee.entity.TypeActivity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by soric on 21/10/2018.
 */

public class TypeActivityDAOImpl implements TypeActivityDAO {
    BDConection conex = new BDConection();

    @Override
    public void registerTypeActivity(TypeActivity typeActivity) {
        try {
            Statement statement = conex.getConnection().createStatement();
            statement.executeUpdate("INSERT INTO tipo_actividad VALUES ('" + typeActivity.getId_type_activity() + "','" + typeActivity.getName_type_activity() + "')");
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
    public ArrayList<TypeActivity> listTipeActivity() {
        ArrayList<TypeActivity> typeActivities = new ArrayList<TypeActivity>();

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM tipo_actividad");
            ResultSet res = consult.executeQuery();
            while (res.next()) {
                int id = res.getInt("id_tipo_actividad");
                String name = res.getString("nom_tipo_actividad");
                TypeActivity typeActivity = new TypeActivity(id,name);
                typeActivities.add(typeActivity);
            }
            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de usuario\n" + e);
        }
        return typeActivities;
    }

    @Override
    public TypeActivity consultTypeActivity(int id_typeActivity) {

        TypeActivity typeActivity = null;

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM tipo_actividad WHERE id_tipo_activida = ? ");
            consult.setInt(1, id_typeActivity);
            ResultSet res = consult.executeQuery();

            if (res.next()) {
                int id = res.getInt("id_tipo_actividad");
                String name = res.getString("nom_tipo_actividad");
                typeActivity = new TypeActivity(id,name);
            }
            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de Usuario\n" + e);
        }
        return typeActivity;

    }

    @Override
    public void updateTypeActivity(TypeActivity typeActivity) {

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("UPDATE tipo_actividad SET nom_tipo_actividad= ? WHERE id_tipo_actividad= ?");
            consult.setString(1, typeActivity.getName_type_activity());
            consult.setInt(3, typeActivity.getId_type_activity());
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
    public void removeUser(int id_typeActivity) {

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("DELETE FROM tipo_actividad WHERE id_tipo_actividad = ?");
            consult.setInt(1, id_typeActivity);
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
