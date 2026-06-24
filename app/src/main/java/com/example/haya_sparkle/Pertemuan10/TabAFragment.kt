package com.example.haya_sparkle.Pertemuan10

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.haya_sparkle.R
import com.example.haya_sparkle.adapter.PenerimaAdapter
import com.example.haya_sparkle.database.DatabaseProvider
import com.example.haya_sparkle.database.PenerimaEntity
import com.example.haya_sparkle.databinding.FragmentTabABinding
import kotlinx.coroutines.launch

class TabAFragment : Fragment() {

    private var _binding: FragmentTabABinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTabABinding.inflate(
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
        getDataRoom()

        binding.fabTambah.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    TambahPenerimaActivity::class.java
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
                .penerimaDao()

            if (dao.getAll().isEmpty()) {

                dao.insert(
                    PenerimaEntity(
                        nama = "Wilda Yuniar",
                        bantuan = "Rumah Layak Huni",
                        keterangan = "Bantuan renovasi rumah"
                    )
                )

                dao.insert(
                    PenerimaEntity(
                        nama = "Salwa Surtini",
                        bantuan = "Bantuan Lansia",
                        keterangan = "Program lansia"
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
                .penerimaDao()

            val data = dao.getAll()

            binding.rvPenerima.layoutManager =
                LinearLayoutManager(requireContext())

            binding.rvPenerima.adapter =
                PenerimaAdapter(data) { item ->

                    lifecycleScope.launch {

                        DatabaseProvider
                            .getDatabase(requireContext())
                            .penerimaDao()
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