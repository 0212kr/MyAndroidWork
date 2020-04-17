package com.lec.android.a005_image;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
/**
 *  인터넷 상의 이미지 보여주기
 *      1. 권한을 획득한다 (인터넷에 접근할수 있는 권한을 획득한다)  - 메니페스트 파일
 *      2. Thread 에서 웹의 이미지를 받아온다 - honeycomb(3.0) 버젼 부터 바뀜
 *      3. 외부쓰레드에서 메인 UI에 접근하려면 Handler 를 사용해야 한다.
 *
 *
 *
 */

public class Main4Activity extends AppCompatActivity {

    // 이미지 URL 반드시 https:// 이어야한다
    String imgUrl = "https://developer.android.com/studio/images/studio-icon-stable.png";

    ImageView iv1;
    TextView tvUrl;

    Handler handler = new Handler();    // 외부 쓰레드에서 메인 UI 화면에 그릴때 사용

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        iv1 = findViewById(R.id.iv1);
        tvUrl = findViewById(R.id.tvUrl);

        // Thread t = new Thread(Runnable);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                // Bitmap <- InputStream <- URL <- "url"
                try {
                    // Thread 없이 수행하면
                    // android.os.NetworkOnMainThreadException 발생
                    URL url = new URL(imgUrl);
                    InputStream in = url.openStream();
                    final Bitmap bm = BitmapFactory.decodeStream(in);

//                    iv1.setImageBitmap(bm);
                    // 핸들러 없이 사용하면 사-망(안된다)


                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            iv1.setImageBitmap(bm);
                            tvUrl.setText(imgUrl);
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();




    }
}
