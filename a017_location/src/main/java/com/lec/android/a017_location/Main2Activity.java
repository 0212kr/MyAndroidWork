package com.lec.android.a017_location;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

/** 현재 위치 정보 가져오기 : GPS (Global Positioning System)
 *  1. AndroidManifest.xml 위치정보 권한획득 선언  (API23 이전 버젼은 이걸로 충분)
 *          android.permission.ACCESS_FINE_LOCATION
 *          android.permission.ACCESS_COARSE_LOCATION
 *
 *    1-2 API23+ 에서는 (마시멜로): 새로운 권한 획득 방법 사용.
 *          Run-time 에 onRequestPermissionsResult() 사용 해야 한다!!!
 *          https://developer.android.com/training/permissions/requesting.html
 *  2. LocationManager 획득
 *  3. LocationProvider 지정
 *     이전에 사용한 Provider 있는지 여부, 없으면 새로
 *
 *     ※ GPS 는 에뮬레이터에서는 기본적으로 동작하지 않는다
 *     ※ 실내에서는 GPS_PROVIDER 를 요청해도 응답이 없거나 느리다. 특별한 처리를 안하면 아무리 시간이 지나도 응답이 없으면
 *         해결방법은
 *          ① 타이머를 설정하여 GPS_PROVIDER 에서
 *              일정시간 응답이 없는 경우 NETWORK_PROVIDER로 전환
 *         ② 혹은, 둘다 한꺼번헤 호출하여 우선 들어오는 값을 사용하는 방식.
 *
 *      ※ 폰에 GPS 를 꺼놔도, LocationManager 가 최초 위치 정보 확인할때 GPS 켜지면서 초기화됨.
 *
 *  4. LocationListener 생성 : onLocationChanged() 에서 위치정보 (Location) 확인
 *
 *
 *  안드로이드 좌표계:  경도(longitude), 위도(latitude) 사용
 *        대한민국은 위도 36~38도,   경도 126~128도 사이 위치
 *      ex) 서울시청 : 37.566767, 126.978370       <-- 구글맵 등에서 위치 좌표 제공
 * */
public class Main2Activity extends AppCompatActivity {

    TextView tvResult;
    ToggleButton btnLocate;

    String [] permissions = {Manifest.permission.ACCESS_FINE_LOCATION};
    final int REQUEST_CODE = 101;

    LocationManager manager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvResult = findViewById(R.id.tvResult);
        btnLocate = findViewById(R.id.btnLocate);

        // 위험권한 획득
        if (Build.VERSION.SDK_INT >= 23){
            if (checkCallingOrSelfPermission(String.valueOf(permissions)) == PackageManager.PERMISSION_DENIED{

            }
        }
    }

    class  MyListener implements LocationListener {

        // 위치가 변경(확인) 되었을때 호출
        // 위치값은 loaction 형태로 전달.

        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override   // 위치 제공자 가용하게 될때
        public void onProviderEnabled(String provider) {

        }

        @Override   // 위치 제공자 가용하지 못하게 될때
        public void onProviderDisabled(String provider) {

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        
        switch (requestCode){
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "위치권한획득", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "권환획득 실패", Toast.LENGTH_SHORT).show();
                }
        }
    }

    
    


}
