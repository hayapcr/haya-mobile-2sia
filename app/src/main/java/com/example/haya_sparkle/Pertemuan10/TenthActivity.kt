package com.example.haya_sparkle.Pertemuan10

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.haya_sparkle.R
import com.example.haya_sparkle.databinding.ActivityTenthBinding

class TenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // TOOLBAR
        setSupportActionBar(binding.toolbar)

        supportActionBar?.title = "Publikasi"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // BUTTON BACK
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}