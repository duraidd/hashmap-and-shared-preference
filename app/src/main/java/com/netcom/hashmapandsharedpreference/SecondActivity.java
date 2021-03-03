package com.netcom.hashmapandsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txt1 = findViewById(R.id.name);
        SharedPreferences sharedPreferences = getSharedPreferences("user_name", MODE_PRIVATE);
        String stdname = sharedPreferences.getString("student_name","");
        txt1.setText(stdname);
    }
}