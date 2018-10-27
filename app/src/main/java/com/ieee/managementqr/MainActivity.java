package com.ieee.managementqr;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ieee.daos.UserDAO;
import com.ieee.daosImpl.UserDAOimpl;
import com.ieee.entity.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


     /*
        Attributes
     */

    /*
      Represents the username of the user.
     */
    private EditText username;

    /*
      Represents the password of the user.
     */
    private EditText password;

    /*
        Represents the button to send the information
     */
    private Button btn_accept;

    /*
        Initializes the activity
        @param savedInstanceState Saves all the information and generates the activity
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        btn_accept = (Button) findViewById(R.id.accept);
        Log.d("D","entro");
        btn_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = validateUser(username.getText().toString(),password.getText().toString());
                if(user != null) {


                    Intent in = new Intent(getApplicationContext(), MostrarActivity.class);
                    in.putExtra("USERNAME", username.getText());
                    in.putExtra("PASSWORD", password.getText());
                    startActivity(in);
                }
            }
        });

    }

    public User validateUser(String userName,String password){
        User us = null;

        UserDAOimpl usd = new UserDAOimpl();
        ArrayList<User> a = usd.listUser();

        return null;
    }
     
     
      public Intent login(String email, String password) {
        User user = existsUser(email);
        Intent intent = null;
        if(user.getId_user_type() == 0) {
            if(user.getPassword().equals(password)) {
                intent = new Intent(LoginActivity.class, ChangePasswordActivity.class);
                intent.putExtra("email", email);
                sendEmailUserActivated(user.getName_user());
            }
        }

        return intent;
    }
}
