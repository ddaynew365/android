package coms.example.allinonelowfiproject.dairy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;

import java.text.SimpleDateFormat;
import java.util.Date;

import coms.example.allinonelowfiproject.R;

public class dairy_activity extends AppCompatActivity {
    private ImageButton im_id_left;
    private ImageButton im_id_right;
    private ImageButton goto_emotion;
    private CalendarView calendarView;
    String day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_activity);
        im_id_left =(ImageButton)findViewById(R.id.im_id_left);
        im_id_right =(ImageButton)findViewById(R.id.im_id_right);
        goto_emotion =(ImageButton)findViewById(R.id.goto_emotion);
        calendarView = (CalendarView)findViewById(R.id.calendarView);

        // 캘린더뷰 오늘 날짜 데이터 가져오기
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
        long today = calendarView.getDate();
        Date timeInDate = new Date(today);
        day = sdf.format(timeInDate);

        // 뒤록 가기 버튼
        im_id_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        // 화살표 버튼 : 날짜 데이터 전달
        goto_emotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dairy_activity.this , dairy_emotion.class);
                intent.putExtra("day",day);
                startActivity(intent);
            }
        });

        // 캘린더뷰 날짜 변경 시 해당 날짜 데이터 저장
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                // todo
                dairy_activity.this.day = Integer.toString(year)+"년 " + Integer.toString(month) + "월 "+ Integer.toString(dayOfMonth)+ "일";
            }
        });
    }


}