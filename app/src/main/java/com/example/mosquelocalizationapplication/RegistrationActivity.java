package com.example.mosquelocalizationapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void onSubmit(View v){
        TextView nameInputId = findViewById(R.id.reg_name);
        TextView passwordInputId = findViewById(R.id.reg_pass);
        // getting registration input values
        String nameValue = nameInputId.getText().toString();
        String passwordValue = passwordInputId.getText().toString();
        User user = null;

         // navigating user back to login page
        if(nameValue.length() != 0 && passwordValue.length() != 0){
            user.setName(nameValue);
            user.setPassword(passwordValue);
            user.registerUser(user);
            user.getUsers();

            Toast.makeText(this, "Account created succesfully", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        if(nameValue.length() == 0 || passwordValue.length() == 0){
            Toast.makeText(this, "Empty fields unallowed", Toast.LENGTH_LONG).show();
        }
    }
}