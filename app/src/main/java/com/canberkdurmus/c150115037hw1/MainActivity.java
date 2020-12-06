package com.canberkdurmus.c150115037hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edit_weight;
    EditText edit_height;
    Button calculate_bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        edit_weight = findViewById(R.id.edit_weight);
        edit_height = findViewById(R.id.edit_height);
        calculate_bmi = findViewById(R.id.calculate_button);

        calculate_bmi.setOnClickListener(
                view -> {
                    double weight = Double.parseDouble(edit_weight.getText().toString());
                    double height = Double.parseDouble(edit_height.getText().toString());
                    double bmi = calculate_bmi(weight, height);

                    Log.v("Weight ", edit_weight.getText().toString());
                    Log.v("Height ", edit_height.getText().toString());
                    Log.v("BMI ", String.valueOf(bmi));

                    Intent myIntent = new Intent(this, BmiActivity.class);
                    myIntent.putExtra("bmi", bmi);
                    myIntent.putExtra("bmi", bmi);
                    startActivity(myIntent);
                });
    }

    public double calculate_bmi(double w, double h) {
        return w / (h * h);
    }
}