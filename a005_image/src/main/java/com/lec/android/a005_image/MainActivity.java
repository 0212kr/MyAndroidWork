package com.lec.android.a005_image;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// 안드로이드의 모든 리소스 로 사용하는 파일들은
// 파밍명 규칙
// - 대문자불가
// - 숫자 시작 불가
// - 공백,특수문자 불가
// - 특수문자는 언더바만 가능
public class MainActivity extends AppCompatActivity {

    int[] imagId = {R.drawable.logo,R.drawable.test};
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.iv1);

        // res/drawable 폴더에 있는 이미지로 세팅하기

        iv.setImageResource(R.drawable.logo);

        iv.setOnClickListener(new MyListener());


    }

    class MyListener implements View.OnClickListener {

        int i = 0;
        TextView tvResult = findViewById(R.id.tvResult);

        @Override
        public void onClick(View v) {
            i++;
            if (i == imagId.length) i = 0;
            iv.setImageResource(imagId[i]);
            tvResult.setText("이미지뷰: "+i);
        }
    }







}
