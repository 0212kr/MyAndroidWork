package com.lec.android.a004_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.graphics.Color;
import android.hardware.TriggerEvent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    EditText op1, op2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        tvResult = findViewById(R.id.tvResult);

        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnMinus = findViewById(R.id.btnMinus);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnDiv = findViewById(R.id.btnDiv);


        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oper1 = op1.getText().toString();
                String oper2 = op2.getText().toString();

                int a, b;

                if(oper1 != null && !oper1.trim().equals("")){
                    a = Integer.parseInt(oper1);
                } else {
                    a = 0;
                }
                // "".equals(oper2)
                if(oper2 != null && !oper2.trim().equals("")){
                    b = Integer.parseInt(oper2);
                } else {
                    b = 0;
                }

                tvResult.setText((a + b) + "");
                //a + b


            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oper1 = op1.getText().toString();
                String oper2 = op2.getText().toString();

                int a, b;

                if(oper1 != null && !oper1.trim().equals("")){
                    a = Integer.parseInt(oper1);
                } else {
                    a = 0;
                }
                // "".equals(oper2)
                if(oper2 != null && !oper2.trim().equals("")){
                    b = Integer.parseInt(oper2);
                } else {
                    b = 0;
                }

                tvResult.setText((a - b) + "");
                //a - b
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oper1 = op1.getText().toString();
                String oper2 = op2.getText().toString();

                int a, b;

                if(oper1 != null && !oper1.trim().equals("")){
                    a = Integer.parseInt(oper1);
                } else {
                    a = 0;
                }
                // "".equals(oper2)
                if(oper2 != null && !oper2.trim().equals("")){
                    b = Integer.parseInt(oper2);
                } else {
                    b = 0;
                }

                tvResult.setText((a * b) + "");
                //a * b
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oper1 = op1.getText().toString();
                String oper2 = op2.getText().toString();

                int a, b;

                if(oper1 != null && !oper1.trim().equals("")){
                    a = Integer.parseInt(oper1);
                } else {
                    a = 0;
                }
                // "".equals(oper2)
                if(oper2 != null && !oper2.trim().equals("")){
                    b = Integer.parseInt(oper2);
                } else {
                    b = 0;
                }

                tvResult.setText((a / b) + "");
                //a / b
            }
        });


        op1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            // 포커스 변화가 발생했을때 호출되는 메소드
            // boolean 타입 두번째 매개변수 : 포커스 받은 상태이면 true, 잃은상태면 false
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){   // 포커스 받은 상태에선 yellow 로 배경색 변화
                    view.setBackgroundColor(Color.YELLOW);
                } else {
                    view.setBackgroundColor(Color.parseColor("#00000000"));
                }
            }
        });

        op1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            // 타이핑 완료 되었을때 호출되는 메소드
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                tvResult.setText("첫번째 숫자 입력완료");
                return false;
            }
        });




    } // end onCreate()
} // end Activity