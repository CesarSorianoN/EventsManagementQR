package com.ieee.daosImpl;

import com.ieee.conexion.BDConection;
import com.ieee.daos.ParticipantsDAO;
import com.ieee.entity.Participant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by soric on 21/10/2018.
 */

public class ParticipantDAOImpl implements ParticipantsDAO {

    BDConection conex = new BDConection();

    @Override
    public void registerParticipant(Participant participant) {
        try {
            Statement statement = conex.getConnection().createStatement();
            statement.executeUpdate("INSERT INTO participantes VALUES ('" + participant.getQR_code() + "','"  + participant.getMail() + "')");
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
    public ArrayList<Participant> listPartcipant() {
        ArrayList<Participant> participants = new ArrayList<Participant>();

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM participantes");
            ResultSet res = consult.executeQuery();
            while (res.next()) {
                int qr = res.getInt("codigo_QR");
                String mail = res.getString("correo");
                Participant participant = new Participant(qr,mail);
                participants.add(participant);
            }
            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de usuario\n" + e);
        }
        return participants;
    }

    @Override
    public Participant consultParticipant(int QR_code) {
        Participant participant = null;
        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("SELECT * FROM participantes WHERE codigo_QR = ? ");
            consult.setInt(1, QR_code);
            ResultSet res = consult.executeQuery();

            if (res.next()) {
                int qr = res.getInt("codigo_QR");
                String mail = res.getString("correo");
                participant = new Participant(qr,mail);
            }
            res.close();
            consult.close();
            conex.desconectar();

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "no se pudo consultar el registro de Usuario\n" + e);
        }
        return participant;

    }

    @Override
    public void updateParticipant(Participant participant) {

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("UPDATE participantes SET correo= ? WHERE codigo_QR= ?");
            consult.setString(1, participant.getMail());
            consult.setInt(3, participant.getQR_code());
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
    public void removeParticipant(int QR_code) {

        try {
            PreparedStatement consult = conex.getConnection().prepareStatement("DELETE FROM participantes WHERE codigo_QR = ?");
            consult.setInt(1, QR_code);
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
