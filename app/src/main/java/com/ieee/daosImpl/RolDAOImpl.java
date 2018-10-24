package com.ieee.daosImpl;

import com.ieee.conexion.BDConection;
import com.ieee.daos.RolDAO;
import com.ieee.entity.Rol;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by soric on 21/10/2018.
 */

public class RolDAOImpl implements RolDAO {

    BDConection conex = new BDConection();

    @Override
    public void registerRol(Rol rol) {
        try {
            Statement statement = conex.getConnection().createStatement();
            statement.executeUpdate("INSERT INTO rol VALUES ('" + rol.getId_rol() + "','" + rol.getName() + "')");
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
    public ArrayList<Rol> listRol() {
        ArrayList<Rol> roles = new ArrayList<Rol>();

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM rol");
            ResultSet res = consult.executeQuery();
            while (res.next()) {
                int id_rol = res.getInt("id_rol");
                String name = res.getString("nombre");
                Rol rol = new Rol(id_rol,name);
                roles.add(rol);
            }
            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de usuario\n" + e);
        }
        return roles;
    }

    @Override
    public Rol consultRol(int id_rol) {
        Rol rol = null;
        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM rol WHERE id_rol = ? ");
            consult.setInt(1, id_rol);
            ResultSet res = consult.executeQuery();

            if (res.next()) {
                String name = res.getString("nombre");
                rol = new Rol(id_rol,name);
            }
            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de Usuario\n" + e);
        }
        return rol;

    }

    @Override
    public void updateRol(Rol rol) {

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("UPDATE rol SET nombre = ? WHERE id_rol= ?");
            consult.setString(1, rol.getName());
            consult.setInt(3, rol.getId_rol());
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
    public void removeRol(int id_rol) {

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("DELETE FROM rol WHERE id_rol = ?");
            consult.setInt(1, id_rol);
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
