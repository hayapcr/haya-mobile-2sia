package com.example.haya_sparkle.Pertemuan10

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.haya_sparkle.R
import com.example.haya_sparkle.database.DatabaseProvider
import com.example.haya_sparkle.database.WargaEntity
import com.example.haya_sparkle.databinding.ActivityTambahWargaBinding
import kotlinx.coroutines.launch

class TambahWargaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTambahWargaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            ActivityTambahWargaBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnSimpan.setOnClickListener {

            lifecycleScope.launch {

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

                finish()
            }
        }
    }
}