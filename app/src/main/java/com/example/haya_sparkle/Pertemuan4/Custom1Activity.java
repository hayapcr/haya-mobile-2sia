package com.example.haya_sparkle.Pertemuan4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.haya_sparkle.databinding.ActivityCustom1Binding;

public class Custom1Activity extends AppCompatActivity {

    ActivityCustom1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCustom1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnKembali.setOnClickListener(v -> {
            finish();
        });
    }
}