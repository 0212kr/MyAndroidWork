package com.lec.android.a008_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MyAdapter adapter; // Adapter 객체
    RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);

        // RecyclerView 를 사용하기 위해서는 LayoutManager 지정해주어야한다.
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2); // 2열종대해쳐모여
        rv.setLayoutManager(layoutManager);

        // Adapter 객체 생성
        adapter = new MyAdapter();

        initAdapter(adapter);

        rv.setAdapter(adapter); // RecyclerView 에 Adapter 장착

        Button btnInsert = findViewById(R.id.btnIn);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData(v);
            }
        });

    }

    private void initAdapter(MyAdapter adapter) {
    }


    protected void insertData(View v){
        int idx = 0;

        // 리스트 맨 앞에 추가
        adapter.getItem();
        adapter.notifyDataSetChanged();
        idx++;
    }


}
