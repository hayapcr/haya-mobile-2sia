package com.example.haya_sparkle.Pertemuan2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.haya_sparkle.R
import kotlin.math.PI

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Binding Persegi
        val etSisi = findViewById<EditText>(R.id.etSisi)

        // Binding Tabung
        val etJariJari = findViewById<EditText>(R.id.etJariJari)
        val etTinggiTabung = findViewById<EditText>(R.id.etTinggiTabung)

        val btnHitung = findViewById<Button>(R.id.btnHitung)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        btnHitung.setOnClickListener {
            val sisiStr = etSisi.text.toString()
            val jariStr = etJariJari.text.toString()
            val tinggiStr = etTinggiTabung.text.toString()

            if (sisiStr.isEmpty() || jariStr.isEmpty() || tinggiStr.isEmpty()) {
                tvHasil.text = "Semua input harus diisi!"
            } else {
                // Hitung Persegi
                val sisi = sisiStr.toDouble()
                val luasPersegi = sisi * sisi

                // Hitung Tabung (Volume = π * r² * t)
                val r = jariStr.toDouble()
                val t = tinggiStr.toDouble()
                val volumeTabung = PI * r * r * t

                // Format hasil agar tidak terlalu panjang desimalnya
                val hasilText = """
                    Luas Persegi: $luasPersegi
                    Volume Tabung: ${String.format("%.2f", volumeTabung)}
                """.trimIndent()

                tvHasil.text = hasilText
            }
        }
    }
}