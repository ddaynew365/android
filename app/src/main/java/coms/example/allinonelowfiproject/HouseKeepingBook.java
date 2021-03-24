package coms.example.allinonelowfiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import coms.example.allinonelowfiproject.mainCalendar.MaterialCalendarView;

public class HouseKeepingBook extends AppCompatActivity {


    MaterialCalendarView materialCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_keeping_book);

        materialCalendarView = (MaterialCalendarView)findViewById(R.id.calendarView);


    }
    public void onButtonClick(View view) {
        finish();
    }
    public void onButtonClickCalender(View view){

    }
}