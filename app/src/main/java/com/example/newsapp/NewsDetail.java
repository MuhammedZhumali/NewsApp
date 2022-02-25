package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsDetail extends AppCompatActivity {
    private WebView wvNewsDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        wvNewsDetail = findViewById(R.id.wvNewsDetail);

        wvNewsDetail.setWebViewClient(new WebViewClient());
        String url = getIntent().getStringExtra("src");
        wvNewsDetail.loadUrl(url);
    }
}