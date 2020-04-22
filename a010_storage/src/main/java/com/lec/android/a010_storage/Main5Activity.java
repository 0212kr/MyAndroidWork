package com.lec.android.a010_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

// SharedPreferene
// key-value 쌍으로 데이터 저장
// 작은 데이터를 (세팅값들) 저장 용도로 활용

public class Main5Activity extends AppCompatActivity {

    EditText etInput;
    String sfName = "myFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        etInput = findViewById(R.id.etInput);

        // 저장되어 있던 값을 꺼내서 보여주기
        SharedPreferences sf = getSharedPreferences(sfName, MODE_PRIVATE);
        String str = sf.getString("name","");   // 키값으로 꺼냄
        String xx = sf.getString("xx","ABC");
        String yy = sf.getString("yy","zxc");

        etInput.setText(str);
        Log.d("myapp",str+"-"+xx+"-"+yy);



    }

    @Override
    protected void onPause() {
        super.onPause();

        // Activity 가 종료되기 전에 저장
        SharedPreferences sf = getSharedPreferences(sfName, MODE_PRIVATE);
        SharedPreferences.Editor editor = sf.edit(); // 저장하려면 Editor 객체 필요
        String str = etInput.getText().toString();  // 사용자가 입력한 값
        editor.putString("name",str);
        editor.putString("xx","가나다");
        editor.commit();    // 파일에 최종 파일형태로 저장. (반영함)

    }
}
