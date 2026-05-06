package com.example.haya_sparkle.Pertemuan3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

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

        // Tombol Login
        binding.btnLogin.setOnClickListener(v -> {

            String username =
                    binding.etEmail.getText().toString().trim();

            String password =
                    binding.etPassword.getText().toString().trim();

            // Ambil data SharedPreferences
            SharedPreferences sharedPref =
                    getSharedPreferences("DATA_USER", MODE_PRIVATE);

            String savedUsername =
                    sharedPref.getString("username", "");

            String savedPassword =
                    sharedPref.getString("password", "");

            // RULE 1
            // Username = Password
            if (username.equals(password)) {

                SharedPreferences loginPref =
                        getSharedPreferences("DATA_LOGIN", MODE_PRIVATE);

                SharedPreferences.Editor editor =
                        loginPref.edit();

                editor.putBoolean("isLogin", true);
                editor.apply();

                Intent intent =
                        new Intent(
                                WelcomeActivity.this,
                                DashboardActivity.class
                        );

                startActivity(intent);
                finish();
            }

            // RULE 2
            // Login dari data registrasi
            else if (
                    username.equals(savedUsername)
                            && password.equals(savedPassword)
            ) {

                SharedPreferences loginPref =
                        getSharedPreferences("DATA_LOGIN", MODE_PRIVATE);

                SharedPreferences.Editor editor =
                        loginPref.edit();

                editor.putBoolean("isLogin", true);
                editor.apply();

                Intent intent =
                        new Intent(
                                WelcomeActivity.this,
                                DashboardActivity.class
                        );

                startActivity(intent);
                finish();
            }

            // Jika gagal login
            else {

                binding.etEmail.setError("Username salah");
                binding.etPassword.setError("Password salah");

            }
        });

        // Register
        binding.tvRegister.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            WelcomeActivity.this,
                            RegisterActivity.class
                    );

            startActivity(intent);
        });
    }
}