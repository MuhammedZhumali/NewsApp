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

public class SportFragment extends Fragment {
    private String api = "5482b55591664ef088aa7e7548fd71c6";
    private ArrayList<NewsModel> news;
    private MyAdapter adapter;
    private RecyclerView rvSport;
    private String category = "sport";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sports, null);
        rvSport = view.findViewById(R.id.rvSport);
        news = new ArrayList<>();
        rvSport.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyAdapter(getContext(), news);
        rvSport.setAdapter(adapter);
        findSportNews();

        return view;
    }

    private void findSportNews() {
        NetworkService.getInstance().getCategoryNews(ctr, category, 100, api).enqueue(new Callback<NewsResObject>() {
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