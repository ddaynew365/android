package coms.example.allinonelowfiproject.dairy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

import coms.example.allinonelowfiproject.R;

public class dairy_list extends AppCompatActivity {
    private ArrayList<MainData> arrayList;
    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ImageButton im_id_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_list);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        im_id_left = (ImageButton)findViewById(R.id.im_id_left);



        Intent intent = getIntent();
        String save = intent.getStringExtra("save");

        arrayList = new ArrayList<>();
        MainData mainData = new MainData(R.drawable.amazing_256, R.drawable.amazing_256, save);
        arrayList.add(mainData);

        mainAdapter = new MainAdapter(arrayList);
        recyclerView.setAdapter(mainAdapter);


        im_id_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dairy_list.this, dairy_activity.class);
                startActivity(intent);
            }
        });
    }
}