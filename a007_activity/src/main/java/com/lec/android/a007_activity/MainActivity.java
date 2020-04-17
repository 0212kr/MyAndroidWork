    package com.lec.android.a007_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

    /**
     * 액티비티 (Activity) :
     *      안드로이드의 4대 컴포넌트중 하나인 '화면' UI 객체
     *      앱에서 사용하는 액티비티는 반.드.시 메니페스트 에 등록되어야 함.
     *
     * 액티비티의 라이프 사이클
     *      onCreate() : 액티비티가 생성될때 호출, 사용자 인터페이스 초기화에 사용
     *          onStart() : 액티비티가 사용자에게 보여지기 바로 직전에 호출됨
     *              onResume() : 액티비티가 동작, 즉 사용자와 상호작용. (포커스를 갖기시작) 할때 호출
     *              onPause() : 다른 액티비티가 보여질때 (혹은 다른 액티비티에 의해 가려지기 시작할때) 호출됨
     *          onStop() : 액티비티가 더이상 안보여질때 호출되는 메소드.
     *      onDestory() : 액티비티 소멸될때 호출.
     *      onRestart() : onStop -> onStart 전환될때 호출됨.
     *
     *      [공식] : CTRL+클릭 !
     *      https://developer.android.com/guide/components/activities/activity-lifecycle
     *      https://developer.android.com/reference/android/app/Activity
     *
     *
     * 액티비티의 상태정보(state) 저장및 복원
     *      onRestoreInstanceState() :  onStart 직후에 호출됨.
     *      onSaveInstanceState() : 액티비티 소멸전에 호출된다.
     *
     *  ※ AVD/안드로이드폰 테스트시:  '화면 회전' 옵션을 켜주세요.
     */



    public class MainActivity extends AppCompatActivity {

        EditText et1, et2;
        TextView tvResult;
        Button btnAction;

        //액티비티가 새성될때 호출
        // 사용자 인터페이스 초기화에 주로 사용된다 
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//            Log.d(savedInstanceState)
//            setContentView(R.layout.activity_main);
//
//            et1 = findViewById(R.id.et1);
//            et2 = findViewById(R.id.et2);
//            tvResult = findViewById(R.id.tvResult);
//            btnAction = findViewById(R.id.btnAction);
//
//            btnAction.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int a = Integer.parseInt(et1.getText().toString().trim());
//                    int b = Integer.parseInt(et2.getText().toString().trim());
//                    tvResult.setText(""+ (a+b));
//                }
//            });

        }
}
