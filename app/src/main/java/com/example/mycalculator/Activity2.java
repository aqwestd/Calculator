package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        setTitle("Activity2");

        Intent intent =getIntent();
        int number1= intent.getIntExtra("number1",0);
        int number2= intent.getIntExtra("number2",0);
        TextView textViewNumbers=findViewById(R.id.text_view_numbers);
        textViewNumbers.setText("Numbers:  "+number1+" "+number2);


        Button buttonAdd=findViewById(R.id.add);
        Button buttonSub=findViewById(R.id.subtract);
        Button buttonmul=findViewById(R.id.multiplication);
        Button buttondiv=findViewById(R.id.division);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result=number1+number2;

                Intent resultIntent =new Intent();
                resultIntent.putExtra("result",result);

                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result=number1-number2;

                Intent resultIntent =new Intent();
                resultIntent.putExtra("result",result);

                setResult(RESULT_OK,resultIntent);
                finish();

            }
        });

        buttonmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result=number1*number2;

                Intent resultIntent =new Intent();
                resultIntent.putExtra("result",result);

                setResult(RESULT_OK,resultIntent);
                finish();

            }
        });
        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result=number1/number2;

                Intent resultIntent =new Intent();
                resultIntent.putExtra("result",result);

                setResult(RESULT_OK,resultIntent);
                finish();

            }
        });






    }
}