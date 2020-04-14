package com.lec.android.a003_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    TextView tvResult;
    EditText et;

    // onCreate()
    // 엑티비티가 생성될때 호출되는 메소드
    // 엑티비티 초기화 하는 코드 작성.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btnInc1 = findViewById(R.id.btnInc);
        Button btnInc2 = findViewById(R.id.btnDec);


        tvResult = findViewById(R.id.tvResult);
        et = findViewById(R.id.et);
        final LinearLayout ll = findViewById(R.id.ll);

        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {   //클릭 되었을때 호출되는 메소드 (콜백 메소드 callback method)
                Log.d("myapp","버튼 2가 클릭 되었습니다.");
                tvResult.setText("버튼2 가 클릭됨");
                tvResult.setBackgroundColor(Color.YELLOW);

            }
        });

//        btn2.setOnLongClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) { // 롱클릭 발생시 수행하는 콜백 메소드
//                Log.d("myapp","버튼2가 롱클릭 되었습니다.");
//                tvResult.setText("버튼2가 롱클릭 되었습니다.");
//                tvResult.setBackgroundColor(Color.YELLOW);
//            }
//        });

        // 방법3 : Lambda - expression 사용하기
        // AndroidStudio 의 세팅 필요! ppt 참조!
        btn3.setOnClickListener((v) -> {    //onClick(View v)
            Log.d("myapp","버튼3 이 클릭 되었다.");
            tvResult.setText("버튼3 클릭됨");
            ll.setBackgroundColor(Color.rgb(164,198,57));
        });

        //방법4 : implement 한 클래스 사용
        Button btnA = findViewById(R.id.btnA);
        Button btnB = findViewById(R.id.btnB);
        Button btnC = findViewById(R.id.btnC);
        Button btnD = findViewById(R.id.btnD);
        Button btnE = findViewById(R.id.btnE);
        Button btnF = findViewById(R.id.btnF);

        class MyListener implements View.OnClickListener{
            String name;

            public MyListener(String name) {this.name = name;}

            @Override
            public void onClick(View v) {
                String tag = (String)v.getTag();
                String text = (String)((Button)v).getText();
                String msg = String.format("%s 버튼 %s 이 클릭[%s]",name,text,tag);
                Log.d("myapp",msg);
                tvResult.setText(msg);
                et.setText(et.getText().append(name));
            }
        }

        btnA.setOnClickListener(new MyListener("안녕1"));
        btnB.setOnClickListener(new MyListener("안녕2"));
        btnC.setOnClickListener(new MyListener("안녕3"));
        btnD.setOnClickListener(new MyListener("안녕4"));
        btnE.setOnClickListener(new MyListener("안녕5"));
        btnF.setOnClickListener(new MyListener("안녕6"));

        // 방법4 : 엑티비티가 implement
//        Button btnClear = findViewById(R.id.btnClear);
//        btnClear.setOnClickListener(this);
//        float a = tvResult.setTextSize();
//
//        btnInc1.setOnClickListener((v) -> {
//            Log.d("myapp","+된다");
//            tvResult.set
//
//        }); //TODO



    }



    // 방법1 : 레이아웃 sml 의 onXXX(click) 속성으로 지정
    public void changeText (View v){
        Log.d("myapp","버튼 1이 클릭되었습니다");
        tvResult.setText("버튼1 이 클릭 되었습니다.");
    }


    @Override
    public void onClick(View v) {
        Log.d("myapp", "Clear 버튼이 클릭되었습니다.");
        tvResult.setText("Clear 버튼이 클릭되었습니다");
        et.setText("");

        // 연습
        // +, - 버튼 누르면 tvResult 의 글씨가 점점 커지거나/작아지게 하기
        // 텍스트사이즈 앍 getTextSize() : fLoat 값 리턴


    }
}