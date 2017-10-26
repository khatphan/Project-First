package com.example.tom.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChildActivity extends AppCompatActivity {
    EditText editText1;
    Button button1,buttoncancel;
    private static final int MY_REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        editText1=(EditText)findViewById(R.id.edit1);
        button1=(Button)findViewById(R.id.button1);
        buttoncancel = (Button) findViewById(R.id.buttoncancel);



        buttoncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent data = new Intent();
                setResult(RESULT_OK, data);

                finish();

            }
        });



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String message=editText1.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("MESSAGE",message);
                setResult(2,intent);
                finish();
            }
        });


    }


}

