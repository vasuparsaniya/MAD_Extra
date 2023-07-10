package com.example.fragment_whatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();    // This is fragment manager

        Button btnchat = findViewById(R.id.btnChat);
        btnchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView7, Chat.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // name can be null
                        .commit();

//                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView7, Status.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
            }
        });

        // code for Status Button to switch Fragment
        Button btnstatus = findViewById(R.id.btnStatus);
        btnstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView7, Status.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // name can be null
                        .commit();

//                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView7, Status.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
            }
        });

        // code for Call Button to switch Fragment
        Button btncall = findViewById(R.id.btnCall);
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView7, Call.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // name can be null
                        .commit();

//                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView7, Status.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
            }
        });
    }
}