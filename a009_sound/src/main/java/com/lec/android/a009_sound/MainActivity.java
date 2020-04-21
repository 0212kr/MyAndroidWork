package com.lec.android.a009_sound;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

public class Main2Activity extends AppCompatActivity {

    private ImageView btnPlay;
    private ImageView btnPause;
    private ImageView btnResume;
    private ImageView btnStop;
    SeekBar sb; // 음악 재생위치를 나타내는 시크바

    MediaPlayer mp; // 음악 재생을 위한 객체

    int pos; // 재생 위치
    boolean isTracking = false;

    class MyThread extends Thread{
        @Override
        public void run() {
            // SeekBar 가 음악 재생시, 움직이게 하기
            while(mp.isPlaying()){ // 현재 재생중이라면
                pos = mp.getCurrentPosition(); // 현재 재생중인 위치 ms (int)
                if(!isTracking)
                    sb.setProgress(pos); // SeekBar 이동 --> onProgressChanged() 호출함.
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnResume = findViewById(R.id.btnResume);
        btnStop = findViewById(R.id.btnStop);
        sb = findViewById(R.id.sb);

        btnPlay.setVisibility(View.VISIBLE);
        btnPause.setVisibility(View.INVISIBLE);
        btnResume.setVisibility(View.INVISIBLE);
        btnStop.setVisibility(View.INVISIBLE);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // sb 값 변경될때 마다 호출
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO
            }

            // 드래그 시작(트랙킹) 하면 호출
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO
            }

            // 드래그 마치면 (트랙킹 종료) 하면 호출
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MediaPlayer 개체 초기화, 재생
                mp = MediaPlayer.create(
                        getApplicationContext(), // 현재 화면 제어권자
                        R.raw.chacha // 음악 파일 리소스
                );
                mp.setLooping(false); // true : 무한반복

                // 재생이 끝나면 호출되는 callback 메소드
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Log.d("myapp", "연주종료" + mp.getCurrentPosition() + "/" + mp.getDuration()); // 현재 재생위치, 전체 길이
                        btnPlay.setVisibility(View.VISIBLE);
                        btnPause.setVisibility(View.INVISIBLE);
                        btnResume.setVisibility(View.INVISIBLE);
                        btnStop.setVisibility(View.INVISIBLE);
                    }
                });

                mp.start(); // 노래 재생 시작

                int duration = mp.getDuration(); // 음악의 재생시간 (ms)
                sb.setMax(duration);// SeekBar의 범위를 음악 재생시간으로 설정
                new MyThread().start();// SeekBar Thread 시작.

                btnPlay.setVisibility(View.INVISIBLE);
                btnPause.setVisibility(View.VISIBLE);
                btnStop.setVisibility(View.VISIBLE);
            }
        });

    } // onCreate()

    @Override
    protected void onPause() {
        super.onPause();
        if(mp != null) {
            mp.release(); // 자원 해제
        }

        btnPlay.setVisibility(View.VISIBLE);
        btnPause.setVisibility(View.INVISIBLE);
        btnResume.setVisibility(View.INVISIBLE);
        btnStop.setVisibility(View.INVISIBLE);

    }
} // Main2Activity