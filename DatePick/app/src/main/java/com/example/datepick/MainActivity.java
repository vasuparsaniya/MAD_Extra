package com.example.datepick;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button dateformat;
    TextView tvdate;
    int year;
    int month;
    int day;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateformat =(Button) findViewById(R.id.date);
        tvdate = (TextView) findViewById(R.id.text);
        final Calendar calender = Calendar.getInstance();

        dateformat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                year = calender.get(Calendar.YEAR);
                month = calender.get(Calendar.MONTH)+1;    // we add 1 because Android SDK, start month index to 0. So
                day = calender.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
//                        dateformat.setText(SimpleDateFormat.getDateInstance().format(calender.getTime()));
                        String mydate=dayOfMonth+"/"+month+"/"+year;
                        tvdate.setText(mydate);
                    }
                }, year,month,day);
                datePickerDialog.show();
            }
        });
    }
}