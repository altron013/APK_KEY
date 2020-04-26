package com.exanjjle.vkontakte;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String data1[],data2[],data3[],like_state[];
    int images[];
    Context context;

    public MyAdapter(Context ct,String s1[],String s2[],String s3[],int log[],int img[],String like_state[]){
      context=ct;
      data1=s1;
      data2=s2;
      data3=s3;

      images=img;
        this.like_state = like_state;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.my_row, parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);
        holder.myHeading.setText(data3[position]);
        holder.like_state.setText(like_state[position]);


        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent (context,  SecondActivity.class);
                intent.putExtra ("data1",data1[position]);
                intent.putExtra ("data2",data2[position]);
                intent.putExtra ("myImage",images[position]);
                intent.putExtra ("data3",data3[position]);
                intent.putExtra("Like_state",like_state[position]);

                context.startActivity(intent);



            }
        });
    }


    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView myText1,myText2,myHeading;
        ImageView myImage,imageView;
        ConstraintLayout mainLayout;
        ImageButton like;
        TextView likes;
        TextView like_state;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            myText1=itemView.findViewById(R.id.MyText1);
            myText2=itemView.findViewById(R.id.MyText2);
            myImage=itemView.findViewById(R.id.MyImageView);
            myHeading=itemView.findViewById(R.id.tvHeading);
            imageView=itemView.findViewById(R.id.imageView);
            mainLayout=itemView.findViewById(R.id.mainLayout);
            like = itemView.findViewById(R.id.imageView);
            likes = itemView.findViewById(R.id.tvLikes);
            like_state = itemView.findViewById(R.id.tvViews); like.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    if(like_state.getText().toString().equals("0"))
                    {
                        Toast toast = Toast.makeText(context.getApplicationContext(), "liked", Toast.LENGTH_SHORT);
                        toast.show();
                        likes.setText("101");
                        like_state.setText("1");
                    }
                    else
                    {
                        Toast toast = Toast.makeText(context.getApplicationContext(), "unliked", Toast.LENGTH_SHORT);
                        toast.show();
                        likes.setText("100");
                        like_state.setText("0");
                    }
                }
            });


        }

    }
}
