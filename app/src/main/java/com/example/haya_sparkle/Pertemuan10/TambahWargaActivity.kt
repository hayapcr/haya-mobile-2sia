package com.example.haya_sparkle.Pertemuan10

import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.haya_sparkle.database.DatabaseProvider
import com.example.haya_sparkle.database.WargaEntity
import com.example.haya_sparkle.databinding.ActivityTambahWargaBinding
import com.example.haya_sparkle.utils.NotificationHelper
import com.example.haya_sparkle.utils.ReminderHelper
import kotlinx.coroutines.launch

class TambahWargaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTambahWargaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTambahWargaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSimpan.setOnClickListener {

            lifecycleScope.launch {

                // Simpan data
                DatabaseProvider
                    .getDatabase(this@TambahWargaActivity)
                    .wargaDao()
                    .insert(
                        WargaEntity(
                            nama = binding.etNama.text.toString(),
                            nik = binding.etNik.text.toString(),
                            alamat = binding.etAlamat.text.toString(),
                            pekerjaan = binding.etPekerjaan.text.toString(),
                            kontak = binding.etKontak.text.toString()
                        )
                    )

                // Notifikasi langsung
                NotificationHelper.showNotification(
                    this@TambahWargaActivity,
                    "Bina Desa",
                    "Data warga berhasil ditambahkan",
                    Intent(
                        this@TambahWargaActivity,
                        TenthActivity::class.java
                    )
                )

                // Reminder 1 menit
                val calendar =
                    Calendar.getInstance().apply {
                        add(Calendar.MINUTE, 1)
                    }

                ReminderHelper.setReminder(
                    context = this@TambahWargaActivity,
                    hour = calendar.get(Calendar.HOUR_OF_DAY),
                    minute = calendar.get(Calendar.MINUTE),
                    title = "Bina Desa",
                    message = "Jangan lupa memperbarui data warga.",
                    targetActivity = TenthActivity::class.java
                )

                // Toast
                Toast.makeText(
                    this@TambahWargaActivity,
                    "Silakan tunggu 1 menit untuk menerima pengingat.",
                    Toast.LENGTH_SHORT
                ).show()

                // Tutup Activity
                finish()
            }
        }
    }
}