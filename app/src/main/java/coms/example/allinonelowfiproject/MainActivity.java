package coms.example.allinonelowfiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;

import coms.example.allinonelowfiproject.dashboard.DashboardRecyclerViewAdapter;
import coms.example.allinonelowfiproject.objects.DashItem;
import coms.example.allinonelowfiproject.slidingRootNav.SlidingRootNavBuilder;

public class MainActivity extends AppCompatActivity {

    RecyclerView dashRecyclerView;
    DashboardRecyclerViewAdapter dashRecyclerAdapter;
    GridLayoutManager dashLayoutManager;

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
    }
}