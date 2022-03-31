package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    TextView kosong;
    RecyclerView rvHistory;
    static ArrayList<Historys> historyList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initView();

        if(historyList.isEmpty()) {
            kosong.setVisibility(View.VISIBLE);
        }
        else {
            kosong.setVisibility(View.INVISIBLE);
            HistoryAdapter historyAdapter = new HistoryAdapter(this, historyList);
            rvHistory.setAdapter(historyAdapter);
            LinearLayoutManager manager = new LinearLayoutManager(this);
            rvHistory.setLayoutManager(manager);
        }
    }
    void initView() {
        rvHistory = findViewById(R.id.rvHistory);
        kosong = findViewById(R.id.kosong);
    }
}