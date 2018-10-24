package com.ieee.managementqr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/*
@author: Victoria Núñez, César Soriano
Represents the page for the user to log in
 */
public class MostrarActivity extends AppCompatActivity {

    /*
        Attributes
     */

    /*
      Represents the username of the user.
     */
    private TextView username;

    /*
      Represents the password of the user.
     */
    private TextView password;

    /*
        Initializes the activity
        @param savedInstanceState Saves all the information and generates the activity
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        username = (TextView) findViewById(R.id.lb_user);
        password = (TextView) findViewById(R.id.lb_pass);

        Intent out = getIntent();
        String u = out.getExtras().get("USERNAME").toString();
        String c = out.getExtras().get("PASSWORD").toString();

        username.setText(u);
        password.setText(c);

    }
}
