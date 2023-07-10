package com.example.button_background_change;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1, btn2, btn3;
        final LinearLayout linearlayout;

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        linearlayout = findViewById(R.id.linearlayout);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                linearlayout.setBackgroundColor(Color.RED);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                linearlayout.setBackgroundColor(Color.GREEN);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
             linearlayout.setBackgroundColor(Color.BLUE);
            }
        });
    }
}