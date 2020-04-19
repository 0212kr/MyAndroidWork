package com.lec.android.a003_widget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends Activity {

    private Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0;
    private Button buttonadd,buttondel,buttonmul,buttonsub,buttonresult,buttonclear;

    private TextView text;
    private EditText edit;

    private int a;
    private int where=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        button0 = (Button)findViewById(R.id.button0);
        buttonadd = (Button)findViewById(R.id.buttonadd);
        buttondel = (Button)findViewById(R.id.buttondel);
        buttonmul = (Button)findViewById(R.id.buttonmul);
        buttonsub = (Button)findViewById(R.id.buttonsub);
        buttonresult = (Button)findViewById(R.id.buttonresult);
        buttonclear = (Button)findViewById(R.id.buttonclear);

        //rrvb
        text = (TextView)findViewById(R.id.t1);

        //결과표시창
        edit = (EditText)findViewById(R.id.e1);



        OnClickListener cl = new OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(v==button1){
                    edit.setText(edit.getText().toString()+1);
                }
                else if(v==button2){
                    edit.setText(edit.getText().toString()+2);
                }
                else if(v==button3){
                    edit.setText(edit.getText().toString()+3);
                }
                else if(v==button4){
                    edit.setText(edit.getText().toString()+4);
                }
                else if(v==button5){
                    edit.setText(edit.getText().toString()+5);
                }
                else if(v==button6){
                    edit.setText(edit.getText().toString()+6);
                }
                else if(v==button7){
                    edit.setText(edit.getText().toString()+7);
                }
                else if(v==button8){
                    edit.setText(edit.getText().toString()+8);
                }
                else if(v==button9){
                    edit.setText(edit.getText().toString()+9);
                }
                else if(v==button0){
                    edit.setText(edit.getText().toString()+0);
                }

                else if(v==buttonadd){
                    // 더하기 부분
                    a = Integer.valueOf(edit.getText().toString().trim());
                    edit.setText("");
                    where =1;
                }

                else if(v==buttondel){
                    // 빼기 부분
                    a = Integer.valueOf(edit.getText().toString().trim());
                    edit.setText("");
                    where =2;
                }

                else if(v==buttonmul){
                    // 곱하기 부분
                    a = Integer.valueOf(edit.getText().toString().trim());
                    edit.setText("");
                    where =3;
                }

                else if(v==buttonsub){
                    // 나누기 부분
                    a = Integer.valueOf(edit.getText().toString().trim());
                    edit.setText("");
                    where =4;
                }

                //결과부분
                else if(v==buttonresult){

                    //더하기
                    if(where==1){
                        a = a + Integer.valueOf(edit.getText().toString().trim());
                        edit.setText(Integer.toString(a));
                    }
                    //빼기
                    else if(where==2){
                        a = a - Integer.valueOf(edit.getText().toString().trim());
                        edit.setText(Integer.toString(a));
                    }
                    //곱하기
                    else if(where==3){
                        a = a * Integer.valueOf(edit.getText().toString().trim());
                        edit.setText(Integer.toString(a));
                    }
                    //나누기
                    else if(where==4){
                        a = a / Integer.valueOf(edit.getText().toString().trim());
                        edit.setText(Integer.toString(a));
                    }

                }

                //edittext 클리어
                else if(v==buttonclear){
                    edit.setText("");
                }
            }
        };

        button1.setOnClickListener(cl);
        button2.setOnClickListener(cl);
        button3.setOnClickListener(cl);
        button4.setOnClickListener(cl);
        button5.setOnClickListener(cl);
        button6.setOnClickListener(cl);
        button7.setOnClickListener(cl);
        button8.setOnClickListener(cl);
        button9.setOnClickListener(cl);
        button0.setOnClickListener(cl);
        buttonadd.setOnClickListener(cl);
        buttondel.setOnClickListener(cl);
        buttonmul.setOnClickListener(cl);
        buttonsub.setOnClickListener(cl);
        buttonresult.setOnClickListener(cl);
        buttonclear.setOnClickListener(cl);

    }

}

