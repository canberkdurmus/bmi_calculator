package com.canberkdurmus.c150115037hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {

    TextView text_bmi;
    TextView text_health;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        getSupportActionBar().hide();

        text_bmi = findViewById(R.id.text_bmi);
        text_health = findViewById(R.id.text_health);

        Intent intent = getIntent();
        double bmi = intent.getDoubleExtra("bmi", 0);
        @SuppressLint("DefaultLocale") String s_bmi = String.format("%.1f", bmi);
        text_bmi.setText(s_bmi);
        text_health.setText(classify(bmi));
    }

    public String classify(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}