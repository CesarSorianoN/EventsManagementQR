package com.example.lenovo.eventsmanagementqr;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import com.example.lenovo.email.GMailSender;

import java.util.UUID;

public class RegisterActivity extends AppCompatActivity {

    private Spinner majors;
    private EditText txt_name;
    private EditText txt_email;
    private EditText txt_userID;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        majors = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.schools, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        majors.setAdapter(adapter);

        txt_name = (EditText)findViewById(R.id.txt_name);
        txt_userID = (EditText)findViewById(R.id.txt_userID);
        txt_email = (EditText)findViewById(R.id.txt_email);

        btnRegister = (Button)findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = txt_name.getText().toString();
                String email = txt_email.getText().toString();
                int userID = Integer.parseInt(txt_userID.getText().toString());
                int major = (int) majors.getSelectedItemId();
                try {
                    registerUser(name, userID, email, major);
                } catch (Exception e) {
                    Snackbar snack = Snackbar.make(findViewById(R.id.myCoordinatorLayout), e.getMessage(), Snackbar.LENGTH_INDEFINITE);
                    snack.show();
                }
            }
        });
    }

    public void registerUser(String name, int userID, String email, int id_career) throws Exception{

        if(name.equals("") || email.equals("")) {
            throw new Exception("Datos incompletos");
        }

        if(existsUser(userID) || existsUser(email) == null) {
            throw new Exception("Ya existe el usuario");
        }


        String password = UUID.randomUUID().toString();

        User u = new User(userID, name, password, 0, email, id_career);
        sendEmailActivation(name, password, email);
    }

    public boolean existsUser(int userID) {
        boolean exists = false;

        return  exists;
    }

    public User existsUser(String email) {
        User user = null;
        return user;
    }

    public void sendEmailActivation(String name, String password, String email) {
        String subject = "Bienvenido a EventsManagementQR!";
        String description = "Bienvenido, " + name + "/n" + "   para empezar a utilizar la aplicación, por favor ingrese"
                + "con la contraseña: " + password;
        try{
            GMailSender sender = new GMailSender("eventsmanagementqr", "QReventsIEEE1918");
            sender.sendMail(subject, description, "eventsmanagementqr@gmail.com", email);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(new RegisterActivity(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
        } catch(Exception e) {
            Log.e("SendMail", e.getMessage(), e);
        }
    }

    public void sendEmailUserActivated(String name) {
        String subject = "Un usuario se ha activado en EventsManagementQR!";
        String description = "El usuario " + name + " se ha activado en EventsManagementQR.\n Con cariño, los del proyecto móvil.";
        try{
            GMailSender sender = new GMailSender("eventsmanagementqr", "QReventsIEEE1918");
            sender.sendMail(subject, description, "eventsmanagementqr@gmail.com", "falfonso@unbosque.edu.co");
        } catch (ActivityNotFoundException e) {
            Toast.makeText(new RegisterActivity(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
        } catch(Exception e) {
            Log.e("SendMail", e.getMessage(), e);
        }
    }
}
