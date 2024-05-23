package com.example.mosquelocalizationapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Main extends Activity {
    private EditText userSearcheditText;
    private Button seachButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userSearcheditText = findViewById(R.id.search_val);
        seachButton = findViewById(R.id.search_btn);
        dbHelper = new DatabaseHelper(this);


    }
}