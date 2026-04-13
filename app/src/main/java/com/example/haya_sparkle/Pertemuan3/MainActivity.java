package com.example.haya_sparkle.Pertemuan3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.haya_sparkle.Pertemuan4.DashboardActivity;
import com.example.haya_sparkle.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(v -> {

            Snackbar.make(binding.getRoot(),
                            "Login berhasil",
                            Snackbar.LENGTH_SHORT)
                    .setAction("Tutup", view -> {
                        Log.e("Info Snackbar", "Snackbar ditutup");
                    })
                    .show();

            binding.getRoot().postDelayed(() -> {
                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(intent);
            }, 1500);

        });
    }
}