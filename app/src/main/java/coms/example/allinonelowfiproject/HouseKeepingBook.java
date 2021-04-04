package coms.example.allinonelowfiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import coms.example.allinonelowfiproject.mainCalendar.MaterialCalendarView;

public class HouseKeepingBook extends AppCompatActivity {


    MaterialCalendarView materialCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_keeping_book);

        materialCalendarView = (MaterialCalendarView)findViewById(R.id.calendarView);

        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton2);
        MaterialCalendarView ClanV = (MaterialCalendarView) findViewById(R.id.CalenderForHKB);
        ClanV.setVisibility(View.INVISIBLE);
        FrameLayout FLOut = (FrameLayout) findViewById(R.id.FrameLayout1);
        FLOut.setVisibility(View.INVISIBLE);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClanV.setVisibility(View.VISIBLE);
                FLOut.setVisibility(View.INVISIBLE);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClanV.setVisibility(View.INVISIBLE);
                FLOut.setVisibility(View.VISIBLE);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClanV.setVisibility(View.INVISIBLE);
                FLOut.setVisibility(View.INVISIBLE);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }



    public void onButtonClick(View view) {
        finish();
    }
}