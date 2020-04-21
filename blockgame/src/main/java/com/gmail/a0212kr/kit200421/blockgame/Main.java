package com.gmail.a0212kr.kit200421.blockgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnInfo = findViewById(R.id.btnInfo);
        Button btnHowto = findViewById(R.id.btnHowto);
        Button btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // 게임시작
                Intent intent = new Intent(getApplicationContext(),Start.class);
                startActivity(intent);
            }
        });

        btnHowto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // 게임방법 보기
                Intent intent = new Intent(getApplication(),HowToPlay.class);
                startActivity(intent);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // 게임 정보보기
                Intent intent = new Intent(getApplication(),Info.class);
                startActivity(intent);
            }
        });

    }
}
