package com.example.crawford.teacherhelper;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Cody Crawford on 2018-04-14.
 */

public class TeacherTimer extends AppCompatActivity {
    private EditText minuteText;
    private EditText secondText;
    private Button startPause;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 0;
    private boolean timerRunning;

    private int origMinutes;
    private int origSeconds;

    MediaPlayer soundPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_timer);

        minuteText = (EditText)findViewById(R.id.countdown_time_minutes);
        secondText = (EditText)findViewById(R.id.countdown_time_seconds);
        startPause = (Button)findViewById(R.id.start_pause_button_timer);

        origMinutes = Integer.parseInt(minuteText.getText().toString());
        origSeconds = Integer.parseInt(secondText.getText().toString());

    }

    public void startPause_timer(View view){

        if(minuteText.getText().toString().equals("") || secondText.getText().toString().equals(""))
        {
            Toast.makeText(this, "Timer can not be empty.", Toast.LENGTH_LONG).show();
            return;
        }

        if(timerRunning)
        {
            pauseTimer();
        }
        else
            startTimer();
    }

    public void pauseTimer()
    {
        countDownTimer.cancel();
        startPause.setText("Start");
        timerRunning = false;
    }

    public void startTimer()
    {
        timeLeftInMilliseconds = (Integer.parseInt(minuteText.getText().toString()) * 60000)
                + (Integer.parseInt(secondText.getText().toString()) * 1000);

        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                secondText.setText("00");
                startPause.setText("Start");
                timerRunning = false;
                playSound();

            }
        }.start();
        startPause.setText("Pause");
        timerRunning = true;
    }

    public void updateTimer()
    {
        int minutes = (int) timeLeftInMilliseconds / 60000;
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;

        String minLeftText;
        String secLeftText;

        minLeftText = "" + minutes;
        secLeftText = "";
        if(seconds < 10) secLeftText += "0";
        secLeftText += seconds;

        minuteText.setText(minLeftText);
        secondText.setText(secLeftText);
    }

    public void resetTimer(View view)
    {
        minuteText.setText(Integer.toString(origMinutes));
        String sec = "";
        if(origSeconds < 10) sec += "0";
        sec += Integer.toString(origSeconds);
        secondText.setText(sec);

    }

    private void playSound()
    {
        //Sound file: License: Attribution 3.0 | Recorded by Daniel Simion
        soundPlayer = MediaPlayer.create(this, R.raw.analog_watch_alarm_daniel_simion);
        soundPlayer.start();
    }
}
