package com.example.progressbar2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button StartProgress;
    private ProgressBar progressBar;
    private int CurrentProgress=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StartProgress = findViewById(R.id.start);
        progressBar = findViewById(R.id.progressbar);

        final CountDownTimer countDownTimer = new CountDownTimer(11*1000,1000) {
            @Override
            public void onTick(long l) {
                CurrentProgress = CurrentProgress + 10;
                progressBar.setProgress(CurrentProgress);
                progressBar.setMax(100);
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Progress Finished", Toast.LENGTH_SHORT).show();
            }
        };

        StartProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                countDownTimer.start();
            }
        });
    }
}