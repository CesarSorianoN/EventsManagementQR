package com.ieee.daos;

import com.ieee.entity.Participant;

import java.util.ArrayList;

/**
 * Created by soric on 21/10/2018.
 */

public interface ParticipantsDAO {
    void registerParticipant(Participant participant);

    ArrayList<Participant> listPartcipant();

    Participant consultParticipant(int QR_code);

    void updateParticipant(Participant participant);

    void removeParticipant(int QR_code);

}
