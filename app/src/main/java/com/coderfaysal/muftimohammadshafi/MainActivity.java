package com.coderfaysal.muftimohammadshafi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView it_recycle;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        it_recycle = findViewById(R.id.it_recycle);

        BOOK();

        MyAdapter myAdapter = new MyAdapter();
        it_recycle.setAdapter(myAdapter);
        it_recycle.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));




    }



    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.items, parent, false);


            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            hashMap = arrayList.get(position);

            String title = hashMap.get("title");
            String cover = hashMap.get("cover");
            String bookURL = hashMap.get("url");

            Picasso.get().load(cover).into(holder.it_cover);
            holder.it_title.setText(title);


            holder.book_click.setOnClickListener(view -> {

                WebView.BOOK_URL = bookURL;
                startActivity(new Intent(MainActivity.this, WebView.class));

            });



        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        private class MyViewHolder extends RecyclerView.ViewHolder{

            LinearLayout book_click;
            ImageView it_cover;
            TextView it_title;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                book_click = itemView.findViewById(R.id.book_click);
                it_cover = itemView.findViewById(R.id.it_cover);
                it_title = itemView.findViewById(R.id.it_title);


            }
        }

    }



    public void BOOK(){

        hashMap = new HashMap<>();
        hashMap.put("title", "আত্মশুদ্ধি");
        hashMap.put("cover", "https://i.ibb.co/bFGF4Tw/Screenshot-1.png");
        hashMap.put("url", "https://drive.google.com/file/d/1QLIQlklRMD0iER5R5rgX3rgk0aRlmczA/view?usp=sharing");
        arrayList.add(hashMap);



    }


}