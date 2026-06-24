package com.example.haya_sparkle.Home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.haya_sparkle.Pertemuan10.TenthActivity
import com.example.haya_sparkle.Pertemuan2.SecondActivity
import com.example.haya_sparkle.Pertemuan4.Custom1Activity
import com.example.haya_sparkle.Pertemuan4.Custom2Activity
import com.example.haya_sparkle.Pertemuan4.WebViewActivity
import com.example.haya_sparkle.data.api.RetrofitClient
//import com.example.haya_sparkle.data.model.NewsModel
import com.example.haya_sparkle.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // TOOLBAR
        (requireActivity() as AppCompatActivity)
            .setSupportActionBar(binding.toolbar)

        (requireActivity() as AppCompatActivity)
            .supportActionBar?.title = "Home"

        binding.rvNews.layoutManager =
            LinearLayoutManager(requireContext())

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val response =
                    RetrofitClient.apiService.getNews()

                if (response.isSuccessful) {

                    val newsList =
                        response.body()?.take(6) ?: emptyList()

                    binding.rvNews.adapter =
                        NewsAdapter(newsList)

                } else {
                    Toast.makeText(
                        requireContext(),
                        "Gagal ambil berita: ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            } catch (e: Exception) {
                Toast.makeText(
                    requireContext(),
                    "Error: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        // CUSTOM 1
        binding.btnCustom1.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    Custom1Activity::class.java
                )
            )
        }

        // CUSTOM 2
        binding.btnCustom2.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    Custom2Activity::class.java
                )
            )
        }

        // RUMUS
        binding.btnRumus.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    SecondActivity::class.java
                )
            )
        }

        // WEBVIEW
        binding.btnWebview.setOnClickListener {

            startActivity(
                Intent(
                    requireContext(),
                    WebViewActivity::class.java
                )
            )
        }

        // Publikasi
        binding.btnPertemuan10.setOnClickListener {

            startActivity(
                Intent(requireContext(), TenthActivity::class.java)
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}