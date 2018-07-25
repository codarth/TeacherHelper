package com.example.crawford.teacherhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Cody Crawford on 2018-04-14.
 */

public class RandomNumber extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_number);

    }

    public void pickANumber(View view)
    {
        EditText min = (EditText) findViewById(R.id.min_input);
        EditText max = (EditText) findViewById(R.id.max_input);
        TextView result = (TextView) findViewById(R.id.random_result);

        if(min.getText().toString().equals(""))
        {
            Toast.makeText(this, "Enter a number for the Minimum", Toast.LENGTH_LONG).show();
            return;
        }
        if(max.getText().toString().equals(""))
        {
            Toast.makeText(this, "Enter a number for the Maximum", Toast.LENGTH_LONG).show();
            return;
        }

        int minI = Integer.parseInt(min.getText().toString());
        int maxI = Integer.parseInt(max.getText().toString());

        if(minI > maxI){
            int temp = minI;
            minI = maxI;
            maxI = temp;
            Toast.makeText(this, "Swapped minimum and maximum", Toast.LENGTH_SHORT).show();
        }
        //int randomNum = ThreadLocalRandom.current().nextInt(minI, maxI + 1);
        Random r = new Random();
        int num = r.nextInt((maxI - minI) + 1) + minI;

        result.setText(Integer.toString(num));

    }

}
