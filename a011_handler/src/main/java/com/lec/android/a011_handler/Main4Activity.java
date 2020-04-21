package com.lec.android.a011_handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


// Value1
// 1~10 까지 1초 단위로 증가시키기
// 10초에 도달하면 멈추어서 Toast 띄우기
// Message 사용

// Value2
// 1 ~ 20 까지 1초 단위로 증가시키기
// 20초에 도달하면 멈추어서 Toast 띄우기
// Handler 사용

public class Main4Activity extends AppCompatActivity {

    int mainValue = 0;
    int backValue1 = 0;

    TextView tvMainValue;
    TextView tvResult1, tvResult2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tvMainValue = findViewById(R.id.tvMainValue);
        tvResult1 = findViewById(R.id.tvResult1);
        tvResult2 = findViewById(R.id.tvResult2);

        BackThread99 thread99 = new BackThread99();
        thread99.setDaemon(true);
        thread99.start();


// 방법 #3
// 핸들러를 사용하지 않고도 일정시간마다 (혹은 후에) 코스를 수행할수 있도록
// CountDownTimer 클래스가 제공된다.
// '총시간'  과 '인터벌(간격)' 을 주면 매 간격마다 onTick 메소드를 수행한다.

        new CountDownTimer(15*1000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
//                value4++;
//                tvResult4.setText("Value4 = " + value4 );
            }

            @Override
            public void onFinish() {    // 종료시 수행하는 코드
                Toast.makeText(getApplicationContext(),"Value4 종료",Toast.LENGTH_LONG).show();
            }
        }.start();  //타이머 시작


    }// END onCreate





    class BackThread99 extends Thread{
        int a = 0;
        @Override
        public void run() {
            while(true){

                backValue1++;
                a++;
                mhandler.sendEmptyMessage(1);
                if (a == 10) break;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    Handler mhandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            // 1-3
            doUpload(msg.what);
        }
    };

    void doUpload(int n){
        Toast.makeText(getApplicationContext(),n+":업로드를 완료했습니다",Toast.LENGTH_SHORT).show();
    }

    public void mOnClick (View v){
        mhandler.sendEmptyMessageAtTime(1,10000);
    }







}


