package com.lec.android.a003_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    EditText tvResult2;

    //과제 : 계산기 앱 만들기
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvResult2 = findViewById(R.id.tvResult2);
        final LinearLayout ll = findViewById(R.id.ll2);

        Button bt1 = findViewById(R.id.bt1);
        Button bt2 = findViewById(R.id.bt2);
        Button bt3 = findViewById(R.id.bt3);
        Button bt4 = findViewById(R.id.bt4);
        Button bt5 = findViewById(R.id.bt5);
        Button bt6 = findViewById(R.id.bt6);
        Button bt7 = findViewById(R.id.bt7);
        Button bt8 = findViewById(R.id.bt8);
        Button bt9 = findViewById(R.id.bt9);

        Button bt00 = findViewById(R.id.bt01);
        Button bt01 = findViewById(R.id.bt02);
        Button bt02 = findViewById(R.id.bt03);
        Button bt03 = findViewById(R.id.bt04);

        class MyListener implements View.OnClickListener{
            String name;

            public MyListener(String name) {this.name = name;}

            @Override
            public void onClick(View v) {
                String tag = (String)v.getTag();
                String text = (String)((Button)v).getText();
                String msg = String.format(name);
                Log.d("myapp",msg);
                tvResult2.setText(tvResult2.getText().append(name));
            }
        }

        bt1.setOnClickListener(new MyListener("안녕1"));
        bt2.setOnClickListener(new MyListener("안녕2"));
        bt3.setOnClickListener(new MyListener("안녕3"));
        bt4.setOnClickListener(new MyListener("안녕4"));
        bt5.setOnClickListener(new MyListener("안녕5"));
        bt6.setOnClickListener(new MyListener("안녕6"));
        bt7.setOnClickListener(new MyListener("안녕6"));
        bt8.setOnClickListener(new MyListener("안녕6"));
        bt9.setOnClickListener(new MyListener("안녕6"));


    }//onCreate en



}
