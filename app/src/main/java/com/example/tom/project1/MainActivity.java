package com.example.tom.project1;


import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonSm,buttonSrc,buttonX;
    RadioButton radioDark,radioLight;
    String url;
    ImageView imageNlu;
   //RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSm = (Button) findViewById(R.id.buttonSm);
        buttonSrc = (Button) findViewById(R.id.buttonSrc);
        buttonX = (Button) findViewById(R.id.buttonX);

        buttonSm.setOnClickListener(this);
        buttonSrc.setOnClickListener(this);
        buttonX.setOnClickListener(this);

        //radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioLight = (RadioButton) findViewById(R.id.radioLight);
        radioDark = (RadioButton) findViewById(R.id.radioDark);
        imageNlu = (ImageView)findViewById(R.id.imageNlu);
        imageNlu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://fit.hcmuaf.edu.vn"));
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v.findViewById(R.id.buttonSm)==buttonSm) {

            Intent i = new Intent(this,NewActivity.class);
            if(radioLight.isChecked()){
                i.putExtra("Light",true);
            }else if(radioDark.isChecked()){
                i.putExtra("Light",false);
            }
            else {
                i.putExtra("Light",true);
            }
            startActivity(i);

        }
        else if (v.findViewById(R.id.buttonSrc)==buttonSrc) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            url = "https://github.com/tantuoc/project1.git";
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        else if (v.findViewById(R.id.buttonX)==buttonX) {
            showAlertX();



        }
    }
    public AlertDialog showAlertX() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Notice");
        builder.setMessage("Do you want close application?");


        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
                System.exit(0);
            }
        });

        builder.setNegativeButton(R.string.cancel, null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();

        return dialog;
    }
    public void onBackPressed() {
        AlertDialog diaBox = showAlertX();
        diaBox.show();
    }



}
