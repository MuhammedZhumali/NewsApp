package com.example.newsapp.fragments;

import static com.example.newsapp.MainActivity.ctr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.MyAdapter;
import com.example.newsapp.NetworkService;
import com.example.newsapp.NewsModel;
import com.example.newsapp.R;
import com.example.newsapp.NewsResObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScienceFragment extends Fragment {
    private String api = "5482b55591664ef088aa7e7548fd71c6";
    private ArrayList<NewsModel> news;
    private MyAdapter adapter;
    private RecyclerView rvScience;
    private String category = "science";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_science, null);
        rvScience = view.findViewById(R.id.rvScience);
        news = new ArrayList<>();
        rvScience.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyAdapter(getContext(), news);
        rvScience.setAdapter(adapter);

        findScienceNews();

        return view;
    }

    private void findScienceNews() {
        NetworkService.getInstance().getCategoryNews(ctr,category,100,api).enqueue(new Callback<NewsResObject>() {
            @Override
            public void onResponse(Call<NewsResObject> call, Response<NewsResObject> response) {
                if(response.isSuccessful()){
                    news.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<NewsResObject> call, Throwable t) {

            }
        });
    }
}