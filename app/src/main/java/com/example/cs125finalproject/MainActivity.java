package com.example.cs125finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private String returnFinalGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.calculate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(MainActivity.this, Results.class);

                String currentGrade = ((EditText) findViewById(R.id.currentGrade)).getText().toString();
                String gradeDesired = ((EditText) findViewById(R.id.gradeDesired)).getText().toString();
                String finalWeight = ((EditText) findViewById(R.id.finalWeight)).getText().toString();
                returnFinalGrade = calculation(currentGrade, gradeDesired, finalWeight);

                startIntent.putExtra("result", returnFinalGrade);
                startActivity(startIntent);


//                TextView output = (TextView) findViewById(R.id.result_test);
//                output.setText(returnFinalGrade);
            }
        });


    }

    public String calculation(String cg, String gd, String fw) {
        double currentGrade = Double.parseDouble(cg);
        double gradeDesired = Double.parseDouble(gd);
        double finalWeight = Double.parseDouble(fw);
        double finalExamGrade = (gradeDesired - currentGrade * (1 - finalWeight / 100)) / (finalWeight / 100);
        DecimalFormat two = new DecimalFormat("0.00");
        return "You need a " + two.format(finalExamGrade) + "% on your final exam.";
    }
}
