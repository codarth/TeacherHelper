package com.example.crawford.teacherhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void namePicker(View view)
    {
        Intent intent = new Intent(this, NamePicker.class);
        startActivity(intent);
    }

    public void randomNumber(View view)
    {
        Intent intent = new Intent(this, RandomNumber.class);
        startActivity(intent);
    }

    public void teacherTimer(View view)
    {
        Intent intent = new Intent(this, TeacherTimer.class);
        startActivity(intent);
    }

    public void teacherStopWatch(View view)
    {
        Intent intent = new Intent(this, TeacherStopWatch.class);
        startActivity(intent);
    }
}
