package com.example.haya_sparkle.Pertemuan4;

import android.os.Bundle;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.haya_sparkle.databinding.ActivityWebviewBinding;

public class WebViewActivity extends AppCompatActivity {

    private ActivityWebviewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWebviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //  Toolbar
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("Web Bina Desa");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.toolbar.setNavigationOnClickListener(v -> finish());

        //  WebView
        binding.webview.setWebViewClient(new WebViewClient());
        binding.webview.getSettings().setJavaScriptEnabled(true);

        //  URL WEBSITE KAMU
        binding.webview.loadUrl("https://haya-bansosguest.alwaysdata.net/dashboard");
    }
}