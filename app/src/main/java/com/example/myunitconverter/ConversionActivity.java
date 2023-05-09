package com.example.myunitconverter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class ConversionActivity extends AppCompatActivity {
    private EditText txtValue;
    private Spinner spSelection ;
    private int function ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
        function = getIntent().getExtras().getInt("FUNCTION");
        txtValue = (EditText) findViewById(R.id.editValue);
        spSelection = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<UnitFunctions.SelectionOption> adp = null;   // spinner icindeki verileri olusturur
        List<UnitFunctions.SelectionOption> selectionOptions = new ArrayList<>();
        String [] dataStr = null;
        int [] dataInt = null;
        switch(function){
            case UnitFunctions.TEMP:
            dataStr= getResources().getStringArray(R.array.temperature) ;
            dataInt = getResources().getIntArray(R.array.iTemp);
            setTitle("Temperature Conversion");
            break;
            case UnitFunctions.MASS:
                dataStr = getResources().getStringArray(R.array.mass);
                dataInt = getResources().getIntArray(R.array.iMass);
                setTitle("Mass Conversion");
                break;
            case UnitFunctions.LENGTH:
                dataStr = getResources().getStringArray(R.array.length);
                dataInt = getResources().getIntArray(R.array.iLength);
                setTitle("Length Conversion");
                break;
        }
        for(int i = 0 ; i<dataStr.length; i++ ) {
            selectionOptions.add(new UnitFunctions().new SelectionOption(dataStr[i],dataInt[i])); // spinere aktarma icin olusturuyo
        }
        adp = new ArrayAdapter<UnitFunctions.SelectionOption>(this, android.R.layout.simple_spinner_dropdown_item, selectionOptions );
        spSelection.setAdapter(adp);

   }
   public void calculationClick(View v) {
        if(!txtValue.getText().equals("")) {
            UnitFunctions.SelectionOption option =(UnitFunctions.SelectionOption)spSelection.getSelectedItem();
            double result = UnitFunctions.makeGenericConversion(option.getFunction(), Double.valueOf(txtValue.getText().toString()));
            String resultText= option.getTitle();
            Intent i = new Intent(this, ResultActivity.class);
            i.putExtra("result",result);
            i.putExtra("resultText",resultText);
            startActivity(i);
        }
        else
            Toast.makeText(this,"Please enter value.",Toast.LENGTH_SHORT).show();


   }
}

