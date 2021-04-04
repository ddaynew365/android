package coms.example.allinonelowfiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.threeten.bp.DayOfWeek;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;

import coms.example.allinonelowfiproject.dashboard.DashboardRecyclerViewAdapter;
import coms.example.allinonelowfiproject.decorators.EventDecorator;
import coms.example.allinonelowfiproject.decorators.OneDayDecorator;
import coms.example.allinonelowfiproject.decorators.SaturdayDecorator;
import coms.example.allinonelowfiproject.decorators.SundayDecorator;
import coms.example.allinonelowfiproject.mainCalendar.CalendarDay;
import coms.example.allinonelowfiproject.mainCalendar.CalendarMode;
import coms.example.allinonelowfiproject.mainCalendar.MaterialCalendarView;
import coms.example.allinonelowfiproject.mainCalendar.OnDateSelectedListener;
import coms.example.allinonelowfiproject.objects.DashItem;
import coms.example.allinonelowfiproject.slidingRootNav.SlidingRootNavBuilder;

public class MainActivity extends AppCompatActivity {

    RecyclerView dashRecyclerView;
    DashboardRecyclerViewAdapter dashRecyclerAdapter;
    GridLayoutManager dashLayoutManager;

    private final OneDayDecorator oneDayDecorator = new OneDayDecorator();
    MaterialCalendarView materialCalendarView;

    ArrayList<DashItem> list = new ArrayList<DashItem>() {{
        add(new DashItem("1번 메인내용","1번 부가내용"));
        add(new DashItem("2번 메인내용","2번 부가내용"));
        add(new DashItem("3번 메인내용","3번 부가내용"));
        add(new DashItem("4번 메인내용","4번 부가내용"));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        Button button = findViewById(R.id.HKB_btn);
        setSupportActionBar(toolbar);

        new SlidingRootNavBuilder(this)
                .withMenuLayout(R.layout.main_sliding_menu)
                .withToolbarMenuToggle(toolbar)
                .inject();

        dashRecyclerView = (RecyclerView)findViewById(R.id.main_dashboard_recycler);
        dashRecyclerAdapter = new DashboardRecyclerViewAdapter(getApplicationContext(), list);

        dashLayoutManager = new GridLayoutManager(getApplicationContext(), 4);
        dashLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int gridPosition = position % 4;
                switch (gridPosition) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        return 2;
                }
                return 0;
            }
        });

        dashRecyclerView.setLayoutManager(dashLayoutManager);
        dashRecyclerView.setAdapter(dashRecyclerAdapter);

        materialCalendarView = (MaterialCalendarView)findViewById(R.id.calendarView);

        materialCalendarView.state().edit()
                .setFirstDayOfWeek(DayOfWeek.SUNDAY)
                .setMinimumDate(CalendarDay.from(2017, 1, 1)) // 달력의 시작
                .setMaximumDate(CalendarDay.from(2030, 12, 31)) // 달력의 끝
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

        materialCalendarView.addDecorators(
                new SundayDecorator(),
                new SaturdayDecorator(),
                oneDayDecorator);

        String[] result = {"2021,01,11","2021,02,11","2021,03,11","2021,04,11"};

        new ApiSimulator(result).executeOnExecutor(Executors.newSingleThreadExecutor());

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                int Year = date.getYear();
                int Month = date.getMonth();
                int Day = date.getDay();

                Log.i("Year test", Year + "");
                Log.i("Month test", Month + "");
                Log.i("Day test", Day + "");

                String shot_Day = Year + "," + Month + "," + Day;

                Log.i("shot_Day test", shot_Day + "");
                materialCalendarView.clearSelection();

                Toast.makeText(getApplicationContext(), shot_Day , Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void onButtonClick(View view){
        Intent newIntent = new Intent(getApplicationContext(),HouseKeepingBook.class);
        startActivity(newIntent);
    }

    private class ApiSimulator extends AsyncTask<Void, Void, List<CalendarDay>> {

        String[] Time_Result;

        ApiSimulator(String[] Time_Result){
            this.Time_Result = Time_Result;
        }

        @Override
        protected List<CalendarDay> doInBackground(@NonNull Void... voids) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Calendar calendar = Calendar.getInstance();
            ArrayList<CalendarDay> dates = new ArrayList<>();

            /*특정날짜 달력에 점표시해주는곳*/
            /*월은 0이 1월 년,일은 그대로*/
            //string 문자열인 Time_Result 을 받아와서 ,를 기준으로짜르고 string을 int 로 변환
            for(int i = 0 ; i < Time_Result.length ; i ++){
                CalendarDay day = CalendarDay.from(calendar);
                String[] time = Time_Result[i].split(",");
                int year = Integer.parseInt(time[0]);
                int month = Integer.parseInt(time[1]);
                int dayy = Integer.parseInt(time[2]);

                dates.add(day);
                calendar.set(year,month-1,dayy);
            }
            return dates;
        }

        @Override
        protected void onPostExecute(@NonNull List<CalendarDay> calendarDays) {
            super.onPostExecute(calendarDays);

            materialCalendarView.addDecorator(new EventDecorator(Color.GREEN, calendarDays,MainActivity.this));
        }
    }
}