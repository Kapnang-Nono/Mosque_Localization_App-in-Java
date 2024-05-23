package com.example.mosquelocalizationapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends Activity {
    private DatabaseHelper dbHelper;
    private EditText userNameEditText;
    private EditText userPasswordEditText;
    private EditText passAgainEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        userNameEditText = findViewById(R.id.reg_name);
        userPasswordEditText = findViewById(R.id.reg_pass);
        passAgainEditText = (EditText) findViewById(R.id.pass_again);
        dbHelper = new DatabaseHelper(this);
        Button regBtn = (Button) findViewById(R.id.reg_btn);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSubmit();
            }
        });
    }

    public void handleSubmit(){
        String username = userNameEditText.getText().toString().trim();
        String password = userPasswordEditText.getText().toString().trim();
        String confirmPass = passAgainEditText.getText().toString().trim();

        if(username.equals("") || password.equals("") || confirmPass.equals("")){
            Toast.makeText(this, "Please all fields are required", Toast.LENGTH_LONG).show();
        }else{
            if(password.equals(confirmPass)){
                Boolean checkuser = dbHelper.checkUserName(username);
                if(checkuser == false){ // if not old user we insert
                    Boolean insert = dbHelper.insertUser(username, password);
                    if(insert == true){
                        Toast.makeText(this, "Registered Successfully", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(this, "Registration failed", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(this, "Username already exist please sign in", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(this, "Password does not match", Toast.LENGTH_LONG).show();
            }
        }
    }
}