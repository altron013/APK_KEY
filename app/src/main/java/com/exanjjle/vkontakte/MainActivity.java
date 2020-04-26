package com.exanjjle.vkontakte;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

      RecyclerView recyclerView,recyclerStories;

    String s1[],s2[],s3[];
    int images[]={R.drawable.tokaev,R.drawable.be,R.drawable.korona,
            R.drawable.putin,R.drawable.gul,R.drawable.book,
            R.drawable.eggs,R.drawable.traveller,
            R.drawable.tokaev,R.drawable.shisha};
    int logo[]={R.drawable.be,R.drawable.tokaev,R.drawable.book,
            R.drawable.eggs,R.drawable.gul,R.drawable.korona,
            R.drawable.putin,R.drawable.shisha,
            R.drawable.tokaev,R.drawable.traveller};
    String like_state[] ={};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.rec);
        recyclerStories = findViewById(R.id.stor);
        s1=getResources().getStringArray(R.array.news);
        s2=getResources().getStringArray(R.array.description);
        s3=getResources().getStringArray(R.array.text);
        like_state=getResources().getStringArray(R.array.like_state);


        MyAdapter myAdapter=new MyAdapter(this, s1, s2,s3,logo, images,like_state);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyStoryAdapter myStoryAdapter = new MyStoryAdapter(this,s1,images);
        recyclerStories.setAdapter(myStoryAdapter);
        recyclerStories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }
}
