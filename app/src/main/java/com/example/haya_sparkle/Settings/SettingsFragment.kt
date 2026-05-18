package com.example.haya_sparkle.Settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.haya_sparkle.Pertemuan3.WelcomeActivity
import com.example.haya_sparkle.R
import com.example.haya_sparkle.databinding.FragmentSettingsBinding
import com.google.android.material.chip.Chip

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    // DATA LISTVIEW
    private val dataListWithDesc = listOf(

        mapOf(
            "title" to "Privacy Policy",
            "desc" to "Kebijakan privasi aplikasi"
        ),

        mapOf(
            "title" to "Tentang Aplikasi",
            "desc" to "Informasi aplikasi SIBANSOS"
        ),

        mapOf(
            "title" to "Kontak Admin",
            "desc" to "Hubungi admin desa"
        ),

        mapOf(
            "title" to "FAQ",
            "desc" to "Pertanyaan yang sering ditanyakan"
        ),

        mapOf(
            "title" to "Versi Aplikasi",
            "desc" to "SIBANSOS versi 1.0"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // TOOLBAR
        (requireActivity() as AppCompatActivity)
            .setSupportActionBar(binding.toolbar)

        (requireActivity() as AppCompatActivity)
            .supportActionBar?.title = "Settings"

        // SIMPLE ADAPTER
        // SIMPLE ADAPTER
        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

// UBAH WARNA TEXT LISTVIEW
        adapter.setViewBinder { view, data, _ ->

            if (view is TextView) {

                view.text = data.toString()

                when (view.id) {

                    // TITLE
                    android.R.id.text1 -> {
                        view.setTextColor(
                            resources.getColor(android.R.color.black)
                        )

                        view.textSize = 17f
                    }

                    // DESCRIPTION
                    android.R.id.text2 -> {
                        view.setTextColor(
                            resources.getColor(R.color.primaryGreen)
                        )

                        view.textSize = 13f
                    }
                }
            }

            true
        }

        binding.listViewItems.adapter = adapter

        // CLICK LISTVIEW
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->

            val item = dataListWithDesc[position]

            Toast.makeText(
                requireContext(),
                "Kamu memilih: ${item["title"]}",
                Toast.LENGTH_SHORT
            ).show()
        }

        // CHIP GROUP
        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->

            val selectedChipId = checkedIds.firstOrNull()

            if (selectedChipId != null) {

                val chip = group.findViewById<Chip>(selectedChipId)

                Toast.makeText(
                    requireContext(),
                    "Filter: ${chip.text}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // BUTTON LOGOUT
        binding.btnLogout.setOnClickListener {

            Toast.makeText(
                requireContext(),
                "Berhasil Logout",
                Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(requireContext(), WelcomeActivity::class.java)

            startActivity(intent)

            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}