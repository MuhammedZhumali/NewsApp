package com.example.newsapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsModel {
    @SerializedName("author")
    @Expose
    private String author;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("description")
    private String description;

    @Expose
    @SerializedName("url")
    private String source;

    @Expose
    @SerializedName("urlToImage")
    private String imageUrl;

    @Expose
    @SerializedName("publishedAt")//The date and time that the article was published, in UTC (+000)
    private String createdAt;

    public NewsModel(String author, String title, String description, String source, String imageUrl, String createdAt) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.source = source;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
