package com.lec.android.a008_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    PhonebookAdapter adapter; // Adapter 객체
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
        adapter = new PhonebookAdapter();

        initAdapter(adapter);

        rv.setAdapter(adapter); // RecyclerView 에 Adapter 장착

        Button btnInsert = findViewById(R.id.btnInsert);
        Button btnAppend = findViewById(R.id.btnAppend);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData(v);
            }
        });

        btnAppend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendData(v);
            }
        });

    }

    //샘플데이터 가져오기
    protected  void initAdapter(PhonebookAdapter adapter){
        for (int i = 0; i < 10; i++){
            int idx = D.next();
            adapter.addItem(new Phonebook(D.FACEID[idx],D.NAME[idx],D.PHONE[idx],D.EMAIL[idx]));
        }
    }


    protected void insertData(View v){
        int idx = D.next();

        // 리스트 맨 앞에 추가
        adapter.addItem(0,new Phonebook(D.FACEID[idx],D.NAME[idx],D.PHONE[idx],D.EMAIL[idx]));
        adapter.notifyDataSetChanged();
    }

    protected void appendData(View v){
        int idx = D.next();

        // 리스트 맨 뒤에 추가
        adapter.addItem(new Phonebook(D.FACEID[idx],D.NAME[idx],D.PHONE[idx],D.EMAIL[idx]));
        adapter.notifyDataSetChanged(); // 데이터 변경을 Adapter 에 알리고 리스트뷰에 반영

    }


}
