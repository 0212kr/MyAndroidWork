package com.lec.android.a010_storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;
// SQLiteOpenHelper
// 안드로이드에서 SQLite3 데이터 베이스를 좀더 쉽게 사용할 수 있도록 제공되는 클래스

public class MySQLiteOpenHelper4 extends SQLiteOpenHelper {
    public MySQLiteOpenHelper4(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        Log.d("myapp","SQLiteOpenHelper 생성");
    }

    // 앱 설치이후 최초에 데이터 베이스가 "없는경우" 데이터 베이스 생성을 위해 호출되는 콜백
    // 주로 DDL 등 테이블 생성하는 코드 작성
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("myapp","SQLiteOpenHelper] onCreate() 호출");

        String sql = "Create Table student ("+
        "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
        "name TEXT, age INTEGER, address TEXT" +
        ")"
                ;

        db.execSQL(sql);
    }

    // 데이터베이스의 "버전"이 바뀌었을때 호출되는 콜백 메소드
    // '버전' 이 바뀌었을때 기존에 설치, 운영되던 데이터베이스를 어떻게 변경할 것인지 작성
    // 각 버저느 변경냐용을 버전마다 작성해야함.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("myapp","SQLiteOpenHelper] ouUpgrade호출"+oldVersion+newVersion);

        String sql = "DROP TABLE IF EXISTS mytable";
        db.execSQL(sql);
        onCreate(db);



    }
}
