package com.example.haya_sparkle.Pertemuan10

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.haya_sparkle.R
import com.example.haya_sparkle.database.DatabaseProvider
import com.example.haya_sparkle.database.PenerimaEntity
import com.example.haya_sparkle.databinding.ActivityTambahPenerimaBinding
import kotlinx.coroutines.launch

class TambahPenerimaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTambahPenerimaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            ActivityTambahPenerimaBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnSimpan.setOnClickListener {

            lifecycleScope.launch {

                DatabaseProvider
                    .getDatabase(this@TambahPenerimaActivity)
                    .penerimaDao()
                    .insert(
                        PenerimaEntity(
                            nama = binding.etNama.text.toString(),
                            bantuan = binding.etBantuan.text.toString(),
                            keterangan = binding.etKeterangan.text.toString()
                        )
                    )

                finish()
            }
        }
    }
}