package com.example.haya_sparkle.Pertemuan4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.haya_sparkle.Pertemuan3.WelcomeActivity;
import com.example.haya_sparkle.databinding.ActivityDashboardBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class DashboardActivity extends AppCompatActivity {

    private ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //  TOOLBAR
        setSupportActionBar(binding.toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Dashboard");
        }

        //  BUTTON WEBVIEW
        binding.btnWeb.setOnClickListener(v -> {
            startActivity(new Intent(DashboardActivity.this, WebViewActivity.class));
        });

        //  LOGOUT
        binding.btnLogout.setOnClickListener(v -> {
            new MaterialAlertDialogBuilder(DashboardActivity.this)
                    .setTitle("Konfirmasi Logout")
                    .setMessage("Apakah Anda yakin ingin logout?")
                    .setPositiveButton("Ya", (dialog, which) -> {

                        SharedPreferences sharedPref = getSharedPreferences("DATA_LOGIN", MODE_PRIVATE);
                        sharedPref.edit().clear().apply();

                        startActivity(new Intent(DashboardActivity.this, WelcomeActivity.class));
                        finish();
                    })
                    .setNegativeButton("Tidak", (dialog, which) -> {
                        Snackbar.make(binding.getRoot(),
                                "Logout dibatalkan",
                                Snackbar.LENGTH_SHORT).show();
                    })
                    .show();
        });
    }
}