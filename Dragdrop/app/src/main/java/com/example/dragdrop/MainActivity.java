package com.example.dragdrop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageview;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview=(ImageView)findViewById(R.id.img);
    }

    float x,y;
    float dx,dy;
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction()  == MotionEvent.ACTION_DOWN){
            x=event.getX();
            y=event.getY();
        }

        if(event.getAction() == MotionEvent.ACTION_MOVE){
            dx=event.getX() - x;
            dy=event.getY() - y;

            imageview.setX(imageview.getX() + dx);
            imageview.setY(imageview.getY() + dy);

            x=event.getX();
            y=event.getY();
        }

        return super.onTouchEvent(event);
    }
}