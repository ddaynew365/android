package coms.example.allinonelowfiproject.dairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import coms.example.allinonelowfiproject.R;

public class dairy_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_activity);


    }

    public void onClick(View view)
    {
        Intent intent = new Intent(this, dairy_emotion.class);
        startActivity(intent);
    }
}