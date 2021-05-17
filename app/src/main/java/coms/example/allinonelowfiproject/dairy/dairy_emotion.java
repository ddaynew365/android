package coms.example.allinonelowfiproject.dairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.ByteArrayOutputStream;

import coms.example.allinonelowfiproject.R;

public class dairy_emotion extends AppCompatActivity {

    private ImageButton ib_back;
    private ImageButton select_emotion;
    private byte[] image_data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_emotion);

        ib_back = (ImageButton)findViewById(R.id.ib_back);
        select_emotion = (ImageButton)findViewById(R.id.select_emotion);


        Intent intent =getIntent();
        String day = intent.getStringExtra("day");


        ib_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        select_emotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(dairy_emotion.this, dairy_write.class);
                intent2.putExtra("day",day);
                intent2.putExtra("image",image_data);
                startActivity(intent2);
           }
    });



    }

    public void onClick(View v){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.expect_256);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        this.image_data = byteArray;
    }
}