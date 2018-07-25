package com.example.crawford.teacherhelper;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Cody Crawford on 2018-04-14.
 */

public class NamePicker extends AppCompatActivity {

    LinearLayout name_list;

    int nameViewCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_picker);

        name_list = (LinearLayout) findViewById(R.id.nameList);

    }

    public void addName(View view)
    {
        EditText nameEntered = (EditText) findViewById(R.id.nameInput);
        String name = nameEntered.getText().toString();
        nameEntered.setText("");

        if(name.equals(""))
        {
            Toast.makeText(this, "Enter a name", Toast.LENGTH_LONG).show();
            return;
        }

        TextView nameItem = new TextView(this);
        nameItem.setText(name);
        nameItem.setId(nameViewCount);
        nameItem.setTextSize(32);

        name_list.addView(nameItem);

        nameViewCount++;

    }

//    public void removeName(View view)
//    {
//        EditText nameEntered = (EditText) findViewById(R.id.nameInput);
//        String name = nameEntered.getText().toString();
//        nameEntered.setText("");
//
//        for(int i = 0; i < name_list.getChildCount(); i++)
//        {
//            if(name_list.getChildAt(i).toString().equals(name))
//            {
//                name_list.removeView((View) view.getParent());
//                break;
//            }
//        }
//    }

    public void pickAName(View view)
    {
        LinearLayout layout = (LinearLayout) findViewById(R.id.nameList);
        TextView display = (TextView) findViewById(R.id.nameResult);
        Random random;
        random = new Random();

        if(layout.getChildCount() == 0)
        {
            Toast.makeText(this, "No names to pick from", Toast.LENGTH_LONG).show();
            return;
        }

        TextView name = (TextView) layout.getChildAt(random.nextInt(layout.getChildCount()));

        display.setText(name.getText());

    }
}
