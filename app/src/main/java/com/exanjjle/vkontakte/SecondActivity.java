package com.exanjjle.vkontakte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
        ImageView mainImageView,myHeading;
        TextView title,description,text,detail_like_state, detail_like_count;;
        String data1,data2,data3,like_state;
        int myImage,MyLogo;
        ImageButton detail_like;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView=findViewById(R.id.mainImageView);

        title=findViewById(R.id.title);
        description=findViewById(R.id.description);
        detail_like_state = findViewById(R.id.tvViews);
        detail_like = findViewById(R.id.iblike);
        detail_like_count = findViewById(R.id.tvLikes);

        getData();
        setData();

    }
    private void getData(){
      if(getIntent().hasExtra("myImage")&& getIntent().hasExtra("data1")&&
              getIntent().hasExtra("data2")){



          data1=getIntent().getStringExtra("data1");
          data2=getIntent().getStringExtra("data2");
          myImage=getIntent().getIntExtra("myImage",1);
          like_state = getIntent().getStringExtra("like_state");

      }else {
          Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
      }
    }
    private void setData(){
        title.setText(data1);
        description.setText(data2);
        mainImageView.setImageResource(myImage);
        detail_like_state.setText(like_state);
        detail_like.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(detail_like_state.getText().toString().equals("0"))
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Like", Toast.LENGTH_SHORT);
                    toast.show();
                    detail_like_count.setText("101");
                    detail_like_state.setText("1");
                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Unlike", Toast.LENGTH_SHORT);
                    toast.show();
                    detail_like_count.setText("100");
                    detail_like_state.setText("0");
                }
            }
        });

    }
}
