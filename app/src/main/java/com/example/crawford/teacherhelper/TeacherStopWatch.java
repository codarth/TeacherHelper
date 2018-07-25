package com.example.crawford.teacherhelper;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Cody Crawford on 2018-04-14.
 */

public class TeacherStopWatch extends AppCompatActivity {

    TextView swTime;
    Button startPauseButton, resetButton;

    long millisecondTime, startTime, timeBuff, updateTime = 0L;
    int minutes, seconds, milliseconds;
    boolean isRunning;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_stopwatch);

        swTime = (TextView) findViewById(R.id.stopwatch_time);
        startPauseButton = (Button) findViewById(R.id.start_pause_button_sw);
        resetButton = (Button) findViewById(R.id.reset_button_sw);

        millisecondTime = 0;
        minutes = 0;
        seconds = 0;
        milliseconds = 0;
        isRunning = false;

        handler = new Handler();
    }

    public void startPause_sw(View view)
    {

        if(isRunning)
        {
            timeBuff += millisecondTime;
            handler.removeCallbacks(runnable);
            startPauseButton.setText("Start");

            isRunning = false;
            resetButton.setEnabled(true);
        }
        else
        {
            startTime = SystemClock.uptimeMillis();
            handler.postDelayed(runnable, 0);
            startPauseButton.setText("Pause");

            isRunning = true;
            resetButton.setEnabled(false);
        }
    }


    public void resetSW(View view)
    {
        millisecondTime = 0;
        minutes = 0;
        seconds = 0;
        milliseconds = 0;

        swTime.setText("0:00:000");
    }

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            millisecondTime = SystemClock.uptimeMillis() - startTime;
            updateTime = timeBuff + millisecondTime;
            seconds = (int) (updateTime / 1000);
            minutes = seconds / 60;
            seconds = seconds % 60;
            milliseconds = (int) (updateTime % 1000);

            swTime.setText("" + minutes + ":"
                    + String.format("%02d", seconds) + ":"
                    + String.format("%03d", milliseconds));

            handler.postDelayed(this, 0);

        }
    };
}
