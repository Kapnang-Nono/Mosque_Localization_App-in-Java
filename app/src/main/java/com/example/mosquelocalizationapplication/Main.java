package com.example.mosquelocalizationapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Main extends Activity {
    private EditText userSearchEditText;
    private Button searchButton;
    private DatabaseHelper dbHelper;
    private TextView sResult,  m2EditText, m3EditText, m4EditText, cityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userSearchEditText = findViewById(R.id.search_val);
        m2EditText = findViewById(R.id.m2);
        m3EditText = findViewById(R.id.m3);
        m4EditText = findViewById(R.id.m4);
//        cityText = findViewById(R.id.city);
        searchButton = findViewById(R.id.search_btn);
        dbHelper = new DatabaseHelper(this);
        sResult = (TextView) findViewById(R.id.s_result);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchInput = userSearchEditText.getText().toString();
                List<Mosque> res = dbHelper.getMosqueByName(searchInput);
                if(res.isEmpty())
                    Toast.makeText(Main.this, "Sorry mosque location info not found", Toast.LENGTH_SHORT).show();
                for (Mosque item: res){
                    sResult.setText("Address: " + item.getAddress());
                    m2EditText.setText("prayerTime " + item.getPrayerTime());
                    m3EditText.setText("Latitude " + item.getLatitude());
                    m4EditText.setText("Longitude " + item.getLongitude());
//                    cityText.setText("City: " + item.getCity());
                }
               userSearchEditText.setText("");
            }
        });
    }
}