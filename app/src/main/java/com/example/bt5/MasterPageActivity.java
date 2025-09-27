package com.example.bt5;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;
import androidx.appcompat.app.AppCompatActivity;
public class MasterPageActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private boolean running = false;
    private long pauseOffset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masterpage); // gắn layout masterpage

        chronometer = findViewById(R.id.chronometer);
        Button btnStart = findViewById(R.id.btnstart);
        Button btnStop = findViewById(R.id.btnstop);

        // Start
        btnStart.setOnClickListener(v -> {
            if (!running) {
                chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                chronometer.start();
                running = true;
            }
        });

        // Stop
        btnStop.setOnClickListener(v -> {
            if (running) {
                chronometer.stop();
                pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                running = false;
            }
        });
    }
}