package com.example.myunitconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String resultText = getIntent().getExtras().getString("resultText");
        double result = getIntent().getExtras().getDouble("result");
        setTitle(resultText);
        txtResult = (TextView)findViewById(R.id.textResult) ;
        txtResult.setText(String.valueOf(result));
    }

    public  void restartClick(View v){

        Intent i = new Intent(this,MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);

    }
}

