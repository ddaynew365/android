package coms.example.allinonelowfiproject.dairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import coms.example.allinonelowfiproject.R;

public class dairy_write extends AppCompatActivity {

    private ImageButton save;
    private EditText et_dairy;
    private TextView day_text;
    private ImageView emotion;
    private Button photo_add;
    private ImageView photo_iv;
    private String user_enter;
    private Button photo_delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_write);

        save = (ImageButton)findViewById(R.id.save);
        et_dairy = (EditText)findViewById(R.id.et_dairy);
        day_text = (TextView)findViewById(R.id.day_text);
        photo_add = (Button)findViewById(R.id.photo_add);
        photo_iv = (ImageView)findViewById(R.id.photo_iv);
        photo_delete = (Button)findViewById(R.id.photo_delete);

        // 데이터 받는 부분
        Intent intent =getIntent();
        String day = intent.getStringExtra("day");
        day_text.setText(day);

        int image_data = intent.getIntExtra("image",1);

        emotion = findViewById(R.id.emotion);
        switch(image_data){
        case 2131230934:
            image_data = R.drawable.amazing_256;
            break;
        case 2131230935:
            image_data = R.drawable.expect_256;
            break;
        default:
            break;
        }

        emotion.setImageResource(image_data);

        // 사진 추가 버튼 클릭 시
        photo_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photo_iv.setVisibility(View.VISIBLE);
            }
        });

        // 사진 삭제 버튼 클릭 시
        photo_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photo_iv.setVisibility((View.GONE));
            }
        });
        
        // 저장 버튼 클릭 시
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_enter = et_dairy.getText().toString();
                Intent intent = new Intent(dairy_write.this, dairy_list.class);
                intent.putExtra("save",user_enter);
                startActivity(intent);
            }
        });


    }


}