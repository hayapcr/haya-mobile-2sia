package com.example.haya_sparkle.Pertemuan14

import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.haya_sparkle.Pertemuan10.TenthActivity
import com.example.haya_sparkle.databinding.ActivityReminderBinding
import com.example.haya_sparkle.utils.ReminderHelper

class ReminderActivity : AppCompatActivity() {

    private lateinit var binding:
            ActivityReminderBinding

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)

        binding =
            ActivityReminderBinding.inflate(
                layoutInflater
            )

        setContentView(binding.root)

        binding.btnSetReminder.setOnClickListener {

            val menit =
                binding.etMenit.text.toString()
                    .toIntOrNull()

            if (menit == null) {
                Toast.makeText(
                    this,
                    "Masukkan jumlah menit",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val calendar =
                Calendar.getInstance().apply {
                    add(Calendar.MINUTE, menit)
                }

            ReminderHelper.setReminder(
                context = this,
                hour = calendar.get(
                    Calendar.HOUR_OF_DAY
                ),
                minute = calendar.get(
                    Calendar.MINUTE
                ),
                title = "SIBANSOS",
                message = "Jangan lupa memperbarui data warga",
            )

            Toast.makeText(
                this,
                "Reminder berhasil dibuat",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}