package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private ArrayList<NewsModel> news;

    public MyAdapter(Context context, ArrayList<NewsModel> news) {
        this.context = context;
        this.news = news;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.cvNews.setOnClickListener(view -> {
            Intent intent = new Intent(context, NewsDetail.class);
            intent.putExtra("src", news.get(position).getSource());
            context.startActivity(intent);
        });

        holder.tvAuthor.setText(news.get(position).getAuthor());
        holder.tvTitle.setText(news.get(position).getTitle());
        holder.tvContent.setText(news.get(position).getDescription());
        holder.tvDate.setText(news.get(position).getCreatedAt());
        //holder.ivNews.setImageResource(R.drawable.pngegg);
        Glide.with(context).load(news.get(position).getImageUrl()).into(holder.ivNews);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvAuthor,tvTitle,tvContent,tvDate;
        CardView cvNews;
        ImageView ivNews;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvContent = itemView.findViewById(R.id.tvContent);
            tvDate = itemView.findViewById(R.id.tvDate);
            cvNews = itemView.findViewById(R.id.cvNews);
            ivNews = itemView.findViewById(R.id.ivNews);
        }
    }
}
