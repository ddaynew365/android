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
    private int image_data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_emotion);

        ib_back = (ImageButton)findViewById(R.id.ib_back);
        select_emotion = (ImageButton)findViewById(R.id.select_emotion);
        
        //이미지뷰 동그랗게 만드는 코드
        //ImageView.setBackground(new ShapeDrawable(new OvalShape()));
        //ImageView.setClipToOutline(true);


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
        this.image_data = v.getId();
    }
}
