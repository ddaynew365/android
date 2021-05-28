package coms.example.allinonelowfiproject.dairy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import java.lang.reflect.Type;
import android.view.View;
import android.widget.ImageButton;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import coms.example.allinonelowfiproject.R;

public class dairy_list extends AppCompatActivity {
    private ArrayList<MainData> arrayList;
    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ImageButton im_id_left;
    private int image_data;
    private String day;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dairy_list);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        im_id_left = (ImageButton)findViewById(R.id.im_id_left);


        // 데이터 받는 부분
        Intent intent = getIntent();
        String save = intent.getStringExtra("save");
        day = intent.getStringExtra("day");
        image_data = intent.getIntExtra("image",1);


        arrayList = new ArrayList<>();

        if(preferences.contains("dairy") == true){
            arrayList = ReadFriendsData();
        }

        MainData mainData = new MainData(image_data, R.drawable.test, save,day);
        arrayList.add(mainData);
        SaveFriendData(arrayList);

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



    private void SaveFriendData(ArrayList<MainData> friends) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        editor = preferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(friends);
        editor.putString("dairy", json);
        editor.commit();
    }

    private ArrayList<MainData> ReadFriendsData() {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Gson gson = new Gson();
        String json = sharedPrefs.getString("dairy", "EMPTY");
        Type type = new TypeToken<ArrayList<MainData>>() {
        }.getType();
        ArrayList<MainData> arrayList = gson.fromJson(json, type);
        return arrayList;
    }

}