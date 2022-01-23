package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity<requestCode> extends AppCompatActivity {
    private TextView mTextViewResult;
    private EditText mEditText_number1;
    private EditText mEditText_number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText_number1 = (EditText) findViewById(R.id.edit_text_num1);
        mEditText_number2= (EditText) findViewById(R.id.edit_text_num2);
        mTextViewResult = (TextView) findViewById(R.id.text_view_result);

        Button buttonOpenActivity2 = findViewById(R.id.next);
        buttonOpenActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( mEditText_number1.getText().toString().equals("")
                        || mEditText_number2.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Please insert a numbers",Toast.LENGTH_SHORT).show();
                }else{
                    int number1 = Integer.parseInt( mEditText_number1.getText().toString());
                    int number2 = Integer.parseInt( mEditText_number2.getText().toString());

                    Intent intent = new Intent(MainActivity.this,Activity2.class);
                    intent.putExtra("number1", number1);
                    intent.putExtra("number2", number2);
                    startActivityForResult(intent, 1);

                }
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent date) {
        super.onActivityResult(requestCode, resultCode, date);

        if(requestCode==1){
            if( resultCode== RESULT_OK){
                int result= date.getIntExtra("result",0);
                mTextViewResult.setText(""+ result);
            }
            if(resultCode==RESULT_CANCELED){
                mTextViewResult.setText("Nothing");
            }
        }



    }
     


}