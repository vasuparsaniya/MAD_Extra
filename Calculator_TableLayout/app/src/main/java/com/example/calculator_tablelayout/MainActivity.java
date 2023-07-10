package com.example.calculator_tablelayout;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView ed;
    boolean newvalue=true;
    String operatorused="+";
    String Number="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed=findViewById(R.id.edittext);
    }
    public void numberclick(View view)
    {
        if(newvalue)
        {
            ed.setText("");
        }
        newvalue=false;
        String input= ed.getText().toString();
        switch (view.getId())
        {
            case R.id.btn1:
                input=input+"9";
                break;
            case R.id.btn2:
                input=input+"8";
                break;
            case R.id.btn3:
                input=input+"7";
                break;
            case R.id.btn5:
                input=input+"6";
                break;
            case R.id.btn6:
                input=input+"5";
                break;
            case R.id.btn7:
                input=input+"4";
                break;
            case R.id.btn9:
                input=input+"3";
                break;
            case R.id.btn10:
                input=input+"2";
                break;
            case R.id.btn11:
                input=input+"1";
                break;
            case R.id.btn14:
                input=input+"0";
                break;
            case R.id.btn15:
                input=input+".";
                break;
            case R.id.btn13:
                input="-"+input;
                break;
        }
        ed.setText(input);
    }
    public void arithmetic(View view)
    {
        newvalue=true;
        Number=ed.getText().toString();
        switch(view.getId())
        {
            case R.id.btn4: operatorused ="+"; break;
            case R.id.btn8: operatorused="-"; break;
            case R.id.btn19: operatorused="/"; break;
            case R.id.btn20: operatorused="X"; break;
        }
    }
    public void equalevent(View view)
    {
        String anotherNumber=ed.getText().toString();
        double answer=0.0;
        switch (operatorused)
        {
            case "+": answer=Double.parseDouble(Number)+Double.parseDouble(anotherNumber); break;
            case "-": answer=Double.parseDouble(Number)-Double.parseDouble(anotherNumber); break;
            case "/": answer=Double.parseDouble(Number)/Double.parseDouble(anotherNumber); break;
            case "X": answer=Double.parseDouble(Number)*Double.parseDouble(anotherNumber); break;
        }
        ed.setText(answer+"");
    }
    public void clear(View view)
    {
        ed.setText("0");
        newvalue=true;
    }
}