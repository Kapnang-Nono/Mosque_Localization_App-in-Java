package com.example.mosquelocalizationapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    // we can also make MainActivity class extends AppCompactActivity
    // (which is the recommended way

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView errorId = findViewById(R.id.error);
        errorId.setVisibility(View.GONE);
    }

    public void launchRegistrationActivity(View v){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void handleLogin(View v){
        TextView nameId = findViewById(R.id.user_name);
        TextView passId = findViewById(R.id.user_password);
        TextView errorId = findViewById(R.id.error);

        String name = nameId.getText().toString();
        String pass = passId.getText().toString();

        if(name.length() == 0 || pass.length() == 0){
            errorId.setVisibility(View.VISIBLE);
            errorId.setText("Sorry empty fields are not allowed");
            Toast.makeText(this, "re-rendering Login", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, MainActivity.class);
            // startActivity(i);
        }
        if(name.length() != 0 && pass.length() != 0){
            Intent i = new Intent(this, Main.class);
            startActivity(i);
            nameId.setText("");
            passId.setText("");
            errorId.setText("");
        }

    }
}