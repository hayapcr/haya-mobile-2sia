package com.example.haya_sparkle.Pertemuan10

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.haya_sparkle.R
import com.example.haya_sparkle.databinding.ActivityTenthBinding
import com.example.haya_sparkle.utils.PermissionHelper
import com.google.android.material.tabs.TabLayoutMediator

class TenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTenthBinding

    // Permission Notification
    private val notificationPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->

            if (isGranted) {
                Toast.makeText(
                    this,
                    "Notifikasi diizinkan",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Notifikasi ditolak",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ===============================
        // Permission Notification Android 13+
        // ===============================
        if (PermissionHelper.isNotificationPermissionRequired()) {

            val permission = Manifest.permission.POST_NOTIFICATIONS

            if (!PermissionHelper.hasPermission(this, permission)) {

                PermissionHelper.requestPermission(
                    notificationPermissionLauncher,
                    permission
                )
            }
        }

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        // Toolbar
        setSupportActionBar(binding.toolbar)

        supportActionBar?.title = "Publikasi"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Tombol Back
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        // Adapter ViewPager
        val tabsAdapter = TenthTabsAdapter(this)
        binding.viewPager.adapter = tabsAdapter

        // Hubungkan TabLayout dengan ViewPager
        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        ) { tab, position ->

            when (position) {

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