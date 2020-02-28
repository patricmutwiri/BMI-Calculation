package com.mutwiri.bmicalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView entryName;
    public TextView entryHeight;
    public TextView entryWeight;
    public TextView results;
    public String msg = "BMI APP : ", name;
    public float height, weight, bmi,heightsq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Quit app
        final Button quit = findViewById(R.id.button2);
        try {
            quit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.v(msg,"Quiting application ");
                    finish();
                }
            });
        } catch (Exception e) {
            Log.v(msg,"Exception on quit. "+e.getMessage());
        }

        // calculate BMI
        final Button getBMI = findViewById(R.id.button1);
        try {
            getBMI.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.v(msg,"Calculating BMI");
                    entryHeight = findViewById(R.id.editText);
                    height = Float.parseFloat(entryHeight.getText().toString());

                    entryWeight = findViewById(R.id.editText2);
                    weight = Float.parseFloat(entryWeight.getText().toString());

                    entryName = findViewById(R.id.editText3);
                    name = entryName.getText().toString();

                    Log.v(msg,"Data :: Name "+name+"; Height "+height+"; Weight "+weight);

                    // formula
                    // bmi = kg/m2
                    heightsq = height*height;
                    bmi = weight/heightsq;
                    Log.v(msg,"Formula >> kg/m2: "+weight+"/"+height+" squared, ("+heightsq+") = "+bmi);
                    // display
                    String healthStatus;
                    if (bmi>=25){
                        healthStatus = "OVER WEIGHT";
                    } else if(bmi<=18.5){
                        healthStatus = "UNDER WEIGHT";
                    } else {
                        healthStatus = "NORMAL";
                    }
                    String outputStr = "Name\t: "+name+"\nHeight\t: "+height+"\nWeight\t: "+weight+"\n\nBMI\t: "+bmi+"\n\nHealth Status\t: "+healthStatus;

                    results = findViewById(R.id.textView2);
                    results.setText(outputStr);
                }
            });
        } catch (Exception e) {
            Log.v(msg,"Exception on BMI calcs "+e.getMessage());
        }
    }
}
