package com.lec.android.a008_practice;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<My> items = new ArrayList<My>(); // 리스트로받습니다.

    static MyAdapter myAdapter; // 기본생성자

    public MyAdapter() {this.myAdapter = this;} // 자신을 가르키는것

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvAge, tvJuso;
        ImageButton btnDel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvJuso = itemView.findViewById(R.id.tvJuso);
            btnDel = itemView.findViewById(R.id.btnDel);


            btnDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myAdapter.removeItem(getAdapterPosition());
                    myAdapter.notifyDataSetChanged();
                }
            });



        }

        public void setItem(My item){
            tvName.setText(item.getName());
            tvAge.setText(item.getAge());
            tvJuso.setText(item.getJuso());
        }


    }

    private void removeItem(int ) { }
}
