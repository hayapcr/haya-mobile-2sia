package com.example.haya_sparkle.Pertemuan4;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.haya_sparkle.Pertemuan2.SecondActivity;
import com.example.haya_sparkle.Pertemuan3.MainActivity;
import com.example.haya_sparkle.databinding.ActivityDashboardBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class DashboardActivity extends AppCompatActivity {

    private ActivityDashboardBinding binding;

    String judul = "Haya Sparkle";
    String deskripsi = "Halaman utama pertemuan 4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvJudul.setText(judul);
        binding.tvDesc.setText(deskripsi);

        // Tombol 1 -> Bangun Ruang
        binding.btnBangunRuang.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("judul", judul);
            intent.putExtra("deskripsi", deskripsi);
            startActivity(intent);
        });

        // Tombol 2 -> Custom 1
        binding.btnCustom1.setOnClickListener(v -> {
            Intent intent = new Intent(this, Custom1Activity.class);
            intent.putExtra("judul", judul);
            intent.putExtra("deskripsi", deskripsi);
            startActivity(intent);
        });

        // Tombol 3 -> Custom 2
        binding.btnCustom2.setOnClickListener(v -> {
            Intent intent = new Intent(this, Custom2Activity.class);
            intent.putExtra("judul", judul);
            intent.putExtra("deskripsi", deskripsi);
            startActivity(intent);
        });

        // Tombol 4 -> Logout
        binding.btnLogout.setOnClickListener(v -> {
            new MaterialAlertDialogBuilder(this)
                    .setTitle("Konfirmasi Logout")
                    .setMessage("Apakah Anda yakin ingin logout?")
                    .setPositiveButton("Ya", (dialog, which) -> {
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    })
                    .setNegativeButton("Tidak", (dialog, which) -> {
                        Snackbar.make(
                                binding.getRoot(),
                                "Logout dibatalkan",
                                Snackbar.LENGTH_SHORT
                        ).show();
                    })
                    .show();
        });

        // Tombol Kembali
        binding.btnKembali.setOnClickListener(v -> {
            finish();
        });
    }
}