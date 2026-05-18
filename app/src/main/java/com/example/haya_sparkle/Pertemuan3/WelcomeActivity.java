package com.example.haya_sparkle.Pertemuan3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.haya_sparkle.BaseActivity;
import com.example.haya_sparkle.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {

    private ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // BINDING YANG BENAR
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // BUTTON LOGIN
        binding.btnLogin.setOnClickListener(v -> {

            String username =
                    binding.etEmail.getText().toString().trim();

            String password =
                    binding.etPassword.getText().toString().trim();

            // AMBIL DATA DARI SHAREDPREFERENCES
            SharedPreferences sharedPref =
                    getSharedPreferences("DATA_USER", MODE_PRIVATE);

            String savedUsername =
                    sharedPref.getString("username", "");

            String savedPassword =
                    sharedPref.getString("password", "");

            // RULE 1
            // USERNAME = PASSWORD
            if (username.equals(password)) {

                SharedPreferences loginPref =
                        getSharedPreferences("DATA_LOGIN", MODE_PRIVATE);

                SharedPreferences.Editor editor =
                        loginPref.edit();

                editor.putBoolean("isLogin", true);
                editor.apply();

                // PINDAH KE BASEACTIVITY
                Intent intent =
                        new Intent(
                                WelcomeActivity.this,
                                BaseActivity.class
                        );

                startActivity(intent);
                finish();
            }

            // RULE 2
            // LOGIN DARI DATA REGISTER
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

                // PINDAH KE BASEACTIVITY
                Intent intent =
                        new Intent(
                                WelcomeActivity.this,
                                BaseActivity.class
                        );

                startActivity(intent);
                finish();
            }

            // LOGIN GAGAL
            else {

                binding.etEmail.setError("Username salah");
                binding.etPassword.setError("Password salah");
            }
        });

        // BUTTON REGISTER
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