package com.ieee.entity;

/**
 * Created by soric on 21/10/2018.
 */

public class Participant {

    private int QR_code;

    private String mail;

    public Participant(int QR_code, String mail) {
        this.QR_code = QR_code;
        this.mail = mail;
    }

    public int getQR_code() {
        return QR_code;
    }

    public void setQR_code(int QR_code) {
        this.QR_code = QR_code;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
