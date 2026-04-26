package com.example.haya_sparkle.Pertemuan3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.haya_sparkle.Pertemuan4.DashboardActivity;
import com.example.haya_sparkle.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {

    private ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 🔘 Tombol Login
        binding.btnLogin.setOnClickListener(v -> {

            SharedPreferences sharedPref = getSharedPreferences("DATA_LOGIN", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();

            editor.putBoolean("isLogin", true);
            editor.apply();

            Intent intent = new Intent(WelcomeActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        });
    }
}