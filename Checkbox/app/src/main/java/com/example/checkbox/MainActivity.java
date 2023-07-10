package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox ch1,ch2,ch3;
    Button submit;
    TextView txt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ch1=findViewById(R.id.ch1);
        ch2=findViewById(R.id.ch2);
        ch3=findViewById(R.id.ch3);
        submit=findViewById(R.id.submit);
        txt = findViewById(R.id.txt);

        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String chkb1=ch1.getText().toString();
                String chkb2=ch2.getText().toString();
                String chkb3=ch3.getText().toString();

                if(ch1.isChecked() && ch2.isChecked() && ch3.isChecked())
                {
                    txt.setText("Selected : "+ chkb1 +" "+chkb2+" "+chkb3);
                }
                else if(ch1.isChecked() && ch2.isChecked())
                {
                    txt.setText("Selected : "+ chkb1 +" "+chkb2);
                }
                else if(ch2.isChecked() && ch3.isChecked())
                {
                    txt.setText("Selected : "+ chkb2+" "+chkb3);
                }
                else if(ch1.isChecked() && ch3.isChecked())
                {
                    txt.setText("Selected : "+ chkb1 +" "+chkb3);
                }
                else if(ch1.isChecked())
                {
                    txt.setText("selected : "+chkb1);
                }
                else if(ch2.isChecked())
                {
                    txt.setText("Selected : "+chkb2);

                }
                else if(ch3.isChecked())
                {
                    txt.setText("Selected : "+chkb3);

                }
                else {
                    txt.setText("Please Select");
                }
                }
        });

    }
}