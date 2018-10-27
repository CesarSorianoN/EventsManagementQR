package com.example.lenovo.eventsmanagementqr;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangePasswordActivity extends AppCompatActivity {

    private EditText txt_password;
    private EditText txt_confirm;
    private Button btn_change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        Intent intent = getIntent();

        final String email = intent.getStringExtra("email");

        txt_password = (EditText)findViewById(R.id.txt_pass);
        txt_confirm = (EditText)findViewById(R.id.txt_confirm);

        btn_change = (Button)findViewById(R.id.btn_change);

        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    changePassword(email, txt_password.getText().toString(), txt_confirm.getText().toString());
                    Intent intent = new Intent(ChangePasswordActivity.class, MainActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    Snackbar snack = Snackbar.make(findViewById(R.id.myCoordinatorLayout), e.getMessage(), Snackbar.LENGTH_INDEFINITE);
                    snack.show();
                }
            }
        });
    }

    public void changePassword(String email, String password, String confirm) throws Exception{
        User user = existsUser(email);

        if(!password.equals(confirm)) {
            throw new Exception("Revise su contraseña");
        }

        user.setPassword(password);
        user.setId_user_type(1);
    }

    public User existsUser(String email) {
        User user = null;
        return user;
    }
}
