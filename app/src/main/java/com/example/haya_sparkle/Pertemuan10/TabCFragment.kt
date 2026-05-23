package com.example.haya_sparkle.Pertemuan10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.haya_sparkle.R
import com.example.haya_sparkle.databinding.FragmentTabCBinding

class TabCFragment : Fragment() {

    private var _binding: FragmentTabCBinding? = null
    private val binding get() = _binding!!

    private val productList = listOf(

        ProductModel(
            "Program Beasiswa PCR",
            "B-001",
            "2025",
            "Rp234.000.000",
            "Program bantuan pendidikan mahasiswa kurang mampu.",
            "https://images.unsplash.com/photo-1524995997946-a1c2e315a42f"
        ),

        ProductModel(
            "Bantuan Sembako",
            "B-002",
            "2024",
            "Rp150.000.000",
            "Program bantuan sembako untuk masyarakat.",
            "https://images.unsplash.com/photo-1583258292688-d0213dc5a3a8"
        ),

        ProductModel(
            "Bantuan Lansia",
            "B-003",
            "2023",
            "Rp120.000.000",
            "Program bantuan warga lanjut usia.",
            "https://images.unsplash.com/photo-1516589091380-5d8e87df6999"
        ),

        ProductModel(
            "Bantuan Pendidikan",
            "B-004",
            "2025",
            "Rp300.000.000",
            "Program bantuan perlengkapan sekolah.",
            "https://images.unsplash.com/photo-1509062522246-3755977927d7"
        ),

        ProductModel(
            "Bantuan UMKM",
            "B-005",
            "2025",
            "Rp450.000.000",
            "Program bantuan modal usaha kecil.",
            "https://images.unsplash.com/photo-1556740749-887f6717d7e4"
        ),

        ProductModel(
            "Bantuan Kesehatan",
            "B-006",
            "2024",
            "Rp500.000.000",
            "Program bantuan layanan kesehatan masyarakat.",
            "https://images.unsplash.com/photo-1584515933487-779824d29309"
        ),

        ProductModel(
            "Rumah Layak Huni",
            "B-007",
            "2025",
            "Rp800.000.000",
            "Program renovasi rumah warga kurang mampu.",
            "https://images.unsplash.com/photo-1460317442991-0ec209397118"
        ),

        ProductModel(
            "Bantuan Anak Yatim",
            "B-008",
            "2023",
            "Rp210.000.000",
            "Program bantuan anak yatim piatu.",
            "https://images.unsplash.com/photo-1516627145497-ae6968895b74"
        ),

        ProductModel(
            "Bantuan Petani",
            "B-009",
            "2025",
            "Rp620.000.000",
            "Program bantuan alat pertanian.",
            "https://images.unsplash.com/photo-1501004318641-b39e6451bec6"
        ),

        ProductModel(
            "Bantuan Nelayan",
            "B-010",
            "2024",
            "Rp710.000.000",
            "Program bantuan perlengkapan nelayan.",
            "https://images.unsplash.com/photo-1507525428034-b723cf961d3e"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTabCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ProductAdapter(productList)

        binding.rvProducts.apply {

            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )

            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}