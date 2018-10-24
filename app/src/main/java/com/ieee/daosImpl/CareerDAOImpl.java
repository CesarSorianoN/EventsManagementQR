package com.ieee.daosImpl;

import com.ieee.conexion.BDConection;
import com.ieee.daos.CareerDAO;
import com.ieee.entity.Career;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by soric on 21/10/2018.
 */

public class CareerDAOImpl implements CareerDAO {

    BDConection conex = new BDConection();

    @Override
    public void registerCareer(Career career) {
        try {
            Statement statement = conex.getConnection().createStatement();
            statement.executeUpdate("INSERT INTO carrera VALUES ('" + career.getId_career() + "','" + career.getName_career() + "')");
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
    public ArrayList<Career> listCareer() {
        ArrayList<Career> careers = new ArrayList<Career>();

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM carrera");
            ResultSet res = consult.executeQuery();
            while (res.next()) {
                int id_career = res.getInt("id_carrera");
                String name_career = res.getString("nom_carrera");
                Career career = new Career(id_career,name_career);
                careers.add(career);
            }
            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de usuario\n" + e);
        }
        return careers;
    }

    @Override
    public Career consultCareer(int id_career) {
      Career career = null;
        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM carrera WHERE id_carrera = ? ");
            consult.setInt(1, id_career);
            ResultSet res = consult.executeQuery();

            if (res.next()) {
                int id = res.getInt("id_carrera");
                String name_career = res.getString("nom_carrera");
                career = new Career(id,name_career);
            }

            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de Usuario\n" + e);
        }
        return career;

    }

    @Override
    public void updateCareer(Career career) {

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("UPDATE carrera SET nom_carrera= ? WHERE id_carrera= ?");
            consult.setString(1, career.getName_career());
            consult.setInt(3, career.getId_career());
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
    public void removeCareer(int id_career) {

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("DELETE FROM carrera WHERE id_carrera = ?");
            consult.setInt(1, id_career);
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
