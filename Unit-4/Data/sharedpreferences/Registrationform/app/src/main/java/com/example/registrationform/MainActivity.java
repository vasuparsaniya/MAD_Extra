package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_name,editText_email;
    Button button_submit;
    SharedPreferences sharedPreferences;
    //So Create a shared preferences name and also create key name
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       editText_name=findViewById(R.id.editext_name);
       editText_email=findViewById(R.id.editext_email);
       button_submit=findViewById(R.id.submit);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        //when open acitvity first check shared preferences data available or not

        String name = sharedPreferences.getString(KEY_NAME, null);

        if(name!=null){
            //if data is available so directly call on HomeActivity
            Intent intent=new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }

        button_submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //when click a button put data on shared preferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME,editText_name.getText().toString());
                editor.putString(KEY_EMAIL,editText_email.getText().toString());
                editor.apply();
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
            }
        });
    }
}