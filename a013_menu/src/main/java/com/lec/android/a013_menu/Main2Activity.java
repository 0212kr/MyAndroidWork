package com.lec.android.a013_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/* ContextMenu - 뷰 객체를 롱클릭했을 때 나오는 메뉴
   PC 에서 마우스 우클릭으로 부가정보들을 제공하는 방법을
   스마트폰에서는 롱클릭의 ContextMenu 로 대체하여 구현한다
*/
public class Main2Activity extends AppCompatActivity {

    TextView tvCtxMenu;
    ImageView ivCtxMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvCtxMenu = findViewById(R.id.tvCtxMenu);
        ivCtxMenu = findViewById(R.id.ivCtxView);

        registerForContextMenu(tvCtxMenu);  // 뷰객체 (위젯 등..) 에 ContextMenu 를 등록함
        unregisterForContextMenu(tvCtxMenu);    // 뷰객체 (위젯 등..) 에 ContextMenu 를 제거함



    }   // END onCreate =================================================


    // onCreateContextMenu()
// 컨텍스트 메뉴가 생성될떄, 한번만 호출되는 콜백 메서드

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        Log.d("myapp","onCreateContextMenu()");
    }


// onContextItemSelected(MenuItem)
// ContextMenu 의 메뉴아이템 항목을 선택(클릭) 했을 때 호출


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
    }





    public void showInfo(MenuItem item){
        int id = item.getItemId();   // 옵션메뉴 아이템의 id 값
        String title = item.getTitle().toString();   // 옵션 메뉴의 title
        int groupId = item.getGroupId();   // 옵션 메뉴의 그룹아이디
        int order = item.getOrder();

        String msg = "id:" + id + " title:" + title + " groupid:" + groupId + " order:" + order;
        Log.d("myapp", msg);
        Toast.makeText(getApplicationContext(), title + " 메뉴 클릭", Toast.LENGTH_SHORT).show();
    }




}// END AT=======================================================
