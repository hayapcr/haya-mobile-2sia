package com.example.haya_sparkle.Pertemuan4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.haya_sparkle.databinding.ActivityCustom2Binding;

public class Custom2Activity extends AppCompatActivity {

    ActivityCustom2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCustom2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnKembali.setOnClickListener(v -> {
            finish();
        });
    }
}