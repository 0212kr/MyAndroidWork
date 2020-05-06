package com.lec.android.a016_sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.textView1);

        //센서 장치 목록 확인하기

        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> list = sm.getSensorList(Sensor.TYPE_ALL);
        String str = "<센서목록>\n센서 총 개수 : "+ list.size();

        for (int i = 0 ; i < list.size(); i++){
            Sensor s = list.get(i);

            str += "\n\n"+ i + ", 센서이름 : "+ s.getName()
                    +"\n"+"센서전원 : "+s.getPower()
                    +"\n"+"resolution: "+s.getResolution()
                    +"\n"+"range: "+s.getMaximumRange()
                    ;
        }
        tv.setText(str);
        Log.d("myapp",str);
    }
}
