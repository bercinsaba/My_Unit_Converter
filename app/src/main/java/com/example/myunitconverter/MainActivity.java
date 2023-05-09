package com.example.myunitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void   OnClick(View v) {
        Intent i = new Intent(this, ConversionActivity.class);
        switch (v.getTag().toString()) {
            case "L":
                i.putExtra("FUNCTION", UnitFunctions.LENGTH);
                break;
            case "M":
                i.putExtra("FUNCTION", UnitFunctions.MASS);
                break;
            case "T":
                i.putExtra("FUNCTION", UnitFunctions.TEMP);
                break;
        }
        startActivity(i);


        }
    }
