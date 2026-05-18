package com.example.haya_sparkle.Pertemuan3

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.haya_sparkle.R
import com.example.haya_sparkle.databinding.ActivityRegisterBinding
import java.util.Calendar


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private val agama = arrayOf(
        "Islam",
        "Kristen",
        "Katolik",
        "Hindu",
        "Buddha",
        "Konghucu"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Dropdown agama
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            agama
        )

        binding.autoAgama.setAdapter(adapter)

        // DatePicker
        binding.etTanggal.setOnClickListener {

            val calendar = Calendar.getInstance()

            val tahun = calendar.get(Calendar.YEAR)
            val bulan = calendar.get(Calendar.MONTH)
            val hari = calendar.get(Calendar.DAY_OF_MONTH)

            val dialog = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->

                    val tanggal =
                        "$dayOfMonth/${month + 1}/$year"

                    binding.etTanggal.setText(tanggal)

                },
                tahun,
                bulan,
                hari
            )

            dialog.show()
        }

        // Button Register
        binding.btnRegister.setOnClickListener {

            val nama = binding.etNama.text.toString().trim()
            val tanggal = binding.etTanggal.text.toString().trim()
            val agama = binding.autoAgama.text.toString().trim()
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val confirmPassword =
                binding.etConfirmPassword.text.toString().trim()

            var gender = ""

            if (binding.rbLaki.isChecked) {
                gender = "Laki-laki"
            } else if (binding.rbPerempuan.isChecked) {
                gender = "Perempuan"
            }

            // Reset Error
            binding.etNama.error = null
            binding.etTanggal.error = null
            binding.autoAgama.error = null
            binding.etUsername.error = null
            binding.etPassword.error = null
            binding.etConfirmPassword.error = null

            var isValid = true

            // Validasi Nama
            if (nama.isEmpty()) {
                binding.etNama.error = "Nama wajib diisi"
                isValid = false
            }

            // Validasi Tanggal
            if (tanggal.isEmpty()) {
                binding.etTanggal.error = "Tanggal lahir wajib diisi"
                isValid = false
            }

            // Validasi Gender
            if (gender.isEmpty()) {

                binding.rbPerempuan.error = "Pilih jenis kelamin"
                isValid = false

            }

            // Validasi Agama
            if (agama.isEmpty()) {
                binding.autoAgama.error = "Agama wajib dipilih"
                isValid = false
            }

            // Validasi Username
            if (username.isEmpty()) {
                binding.etUsername.error = "Username wajib diisi"
                isValid = false
            }

            // Validasi Password
            if (password.isEmpty()) {
                binding.etPassword.error = "Password wajib diisi"
                isValid = false
            }

            // Validasi Confirm Password
            if (confirmPassword.isEmpty()) {
                binding.etConfirmPassword.error =
                    "Confirm Password wajib diisi"
                isValid = false
            }

            // Validasi Password Sama
            if (password != confirmPassword) {

                binding.etConfirmPassword.error =
                    "Password tidak sama"

                isValid = false
            }

            // Jika valid
            if (isValid) {

                // Simpan SharedPreferences
                val sharedPref =
                    getSharedPreferences("DATA_USER", MODE_PRIVATE)

                val editor = sharedPref.edit()

                editor.putString("nama", nama)
                editor.putString("tanggal", tanggal)
                editor.putString("gender", gender)
                editor.putString("agama", agama)
                editor.putString("username", username)
                editor.putString("password", password)

                editor.apply()

                Toast.makeText(
                    this,
                    "Registrasi Berhasil",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }
    }
}