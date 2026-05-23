package com.example.haya_sparkle.Pertemuan10

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.haya_sparkle.R
import com.example.haya_sparkle.databinding.ActivityTenthBinding
import com.google.android.material.tabs.TabLayoutMediator

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

        // 1. Adapter
        val tabsAdapter = TenthTabsAdapter(this)

        // 2. ViewPager Adapter
        binding.viewPager.adapter = tabsAdapter

        // 3. Hubungkan TabLayout + ViewPager
        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        ) { tab, position ->

            when(position) {

                0 -> {

                    tab.text = "Penerima Bantuan"

                    tab.icon = ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_penerima
                    )

                    val badge = tab.getOrCreateBadge()

                    badge.isVisible = true
                }

                1 -> {

                    tab.text = "Data Warga"

                    tab.icon = ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_warga
                    )

                    val badge = tab.getOrCreateBadge()

                    badge.isVisible = true

                    badge.number = 5
                }

                2 -> {

                    tab.text = "Program Bantuan"

                    tab.icon = ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_program
                    )
                }
            }
        }.attach()
    }
}