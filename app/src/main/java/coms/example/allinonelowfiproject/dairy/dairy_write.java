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
import android.widget.Toast;

import java.io.InputStream;

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
    private int image_data;
    private static final int REQUEST_CODE = 0;

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

        image_data = intent.getIntExtra("image",2131230934);

        // 감정 표현 나타내는 부분
        emotion = findViewById(R.id.emotion);
        switch(image_data){
        case 2131230934:
            image_data = R.drawable.amazing_256;
            break;
        case 2131230935:
            image_data = R.drawable.expect_256;
            break;
        case 2131230936:
            image_data = R.drawable.angry;
            break;
        case 2131230937:
            image_data = R.drawable.disappointed;
            break;
        case 2131230938:
            image_data = R.drawable.nauseated;
            break;
        case 2131230939:
            image_data = R.drawable.fearful;
            break;
        case 2131230940:
            image_data = R.drawable.blush;
            break;
        case 2131230941:
            image_data = R.drawable.love;
            break;
        default:
            break;
        }

        emotion.setImageResource(image_data);

        // 사진 추가 버튼 클릭 시
        photo_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE);
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
                intent.putExtra("day", day);
                intent.putExtra("image",image_data);
                startActivity(intent);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                try {
                    InputStream in = getContentResolver().openInputStream(data.getData());

                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();

                    photo_iv.setImageBitmap(img);
                } catch (Exception e) {

                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
            }
        }
    }


}