package com.example.mosquelocalizationapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
     private EditText username, password;
     private Button signin, signup;
     private DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.user_password);
        signin = (Button) findViewById(R.id.login_btn);
        signup = (Button) findViewById(R.id.reg_btn);
        dbHelper = new DatabaseHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(i);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              handleUserAuthentication();
            }
        });

    }

    public void handleUserAuthentication(){
        String user = username.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if(user.equals("") || pass.equals("")){
            Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        }else{
            Boolean checkUserPass = dbHelper.checkUsernamePassword(user, pass);
            if(checkUserPass == true){
                Toast.makeText(this, "Login successfull", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(this, Main.class);
                startActivity(myIntent);
            }else{
                Toast.makeText(this, "Invalid credentials! Try again", Toast.LENGTH_SHORT).show();
            }
        }
    }
}