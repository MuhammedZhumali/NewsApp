package com.example.newsapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsResObject {

    @Expose
    @SerializedName("status")//If the request was successful or not
    private String status;

    @Expose
    @SerializedName("totalResults")// The total number of results available for your request.
    private String totalResults;

    @Expose
    @SerializedName("articles")// The results of the request. array[]
    private ArrayList<NewsModel> articles;

    public NewsResObject(String status, String totalResults, ArrayList<NewsModel> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<NewsModel> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<NewsModel> articles) {
        this.articles = articles;
    }
}
