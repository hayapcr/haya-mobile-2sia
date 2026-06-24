package com.example.haya_sparkle.pertemuan10

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.haya_sparkle.Pertemuan10.TambahWargaActivity
import com.example.haya_sparkle.R
import com.example.haya_sparkle.adapter.WargaAdapter
import com.example.haya_sparkle.database.DatabaseProvider
import com.example.haya_sparkle.database.WargaEntity
import com.example.haya_sparkle.databinding.FragmentTabBBinding
import kotlinx.coroutines.launch

class TabBFragment : Fragment() {

    private var _binding: FragmentTabBBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTabBBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        insertDummyData()

        binding.fabTambah.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    TambahWargaActivity::class.java
                )
            )
        }
    }

    override fun onResume() {
        super.onResume()
        getDataRoom()
    }

    private fun insertDummyData() {

        lifecycleScope.launch {

            val dao = DatabaseProvider
                .getDatabase(requireContext())
                .wargaDao()

            if (dao.getAll().isEmpty()) {

                dao.insert(
                    WargaEntity(
                        nama = "Budi Santoso",
                        nik = "1471012345678901",
                        alamat = "Pekanbaru",
                        pekerjaan = "Petani",
                        kontak = "081234567890"
                    )
                )

                dao.insert(
                    WargaEntity(
                        nama = "Siti Aminah",
                        nik = "1471012345678902",
                        alamat = "Rumbai",
                        pekerjaan = "Pedagang",
                        kontak = "081298765432"
                    )
                )
            }

            getDataRoom()
        }
    }

    private fun getDataRoom() {

        lifecycleScope.launch {

            val dao = DatabaseProvider
                .getDatabase(requireContext())
                .wargaDao()

            val data = dao.getAll()

            binding.rvWarga.layoutManager =
                LinearLayoutManager(requireContext())

            binding.rvWarga.adapter =
                WargaAdapter(data) { item ->

                    lifecycleScope.launch {

                        DatabaseProvider
                            .getDatabase(requireContext())
                            .wargaDao()
                            .delete(item)

                        getDataRoom()
                    }
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}