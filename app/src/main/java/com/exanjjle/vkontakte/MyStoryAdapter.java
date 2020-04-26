package com.exanjjle.vkontakte;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyStoryAdapter extends RecyclerView.Adapter<MyStoryAdapter.MyViewHolder>{

    String storyName[];
    int storyPic[];
    Context context;

    public MyStoryAdapter(Context context, String storyName[], int storyPic[]){
        this.context = context;
        this.storyName = storyName;
        this.storyPic = storyPic;
    }

    @NonNull
    @Override
    public MyStoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((context));
        View view = inflater.inflate(R.layout.stories, parent, false);
        return new MyStoryAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyStoryAdapter.MyViewHolder holder, final int position) {
        holder.storyPic.setImageResource(storyPic[position]);
        holder.storyName.setText(storyName[position]);
    }

    public int getItemCount() {
        return storyPic.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView storyName;
        ImageView storyPic;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            storyName = itemView.findViewById(R.id.storyName);
            storyPic = itemView.findViewById(R.id.storyPic);
        }

    }


}
