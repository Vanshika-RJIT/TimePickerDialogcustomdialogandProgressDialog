package com.example.timepickerdialogandprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
      ImageButton i;
      Button b;
    ProgressDialog pd;

//      TextView t;
     /* TimePickerDialog.OnTimeSetListener tt=new TimePickerDialog.OnTimeSetListener() {
          @Override
          public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
              t.setText(hourOfDay+":"+minute);
          }
      };*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=findViewById(R.id.imageButton);
//        t=findViewById(R.id.textView);
        b=findViewById(R.id.button2);
        i.setOnClickListener(this);
      pd = new ProgressDialog(MainActivity.this);
        pd.setMessage("Files are being downloaded!!!!");
        pd.setCancelable(false);
        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i= new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
                pd.dismiss();
            }
        },2000);

    }

    @Override
    public void onClick(View v) {
    /*    Calendar c=Calendar.getInstance();
        new TimePickerDialog(MainActivity.this,tt,c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),true).show();

*/
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog);
//        dialog.setTitle("Hello");
        dialog.setCancelable(false);
        dialog.show();
        ImageButton i2=dialog.findViewById(R.id.imageButton2);
        final EditText t1=dialog.findViewById(R.id.text1);
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dialog.cancel();
                Log.e("Value",t1.getText().toString());
            }
        });

    }
    public void pd(View view) {
       /* ProgressDialog pd = new ProgressDialog(MainActivity.this);
        pd.setMessage("Files are being downloaded!!!!");
        pd.setCancelable(false);*/
//        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.show();
    }
}