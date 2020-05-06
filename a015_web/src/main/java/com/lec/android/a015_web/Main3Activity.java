package com.lec.android.a015_web;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class Main3Activity extends AppCompatActivity {

    TextView textView;
    EditText editText;

    Button btnXML;
    Button btnJSON;
    Button btnParse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnJSON = findViewById(R.id.btnJSON);
        btnXML = findViewById(R.id.btnXML);
        btnParse = findViewById(R.id.btnParse);

        final String API_KEY = "4d46796d7366726f3833774a774955";






    }

    public static void parseJSON(String jsonText) throws JSONException {
        JSONObject jobj = new JSONObject(jsonText);



    }
}
//========

