package com.example.haya_sparkle.Home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.haya_sparkle.Pertemuan2.SecondActivity
import com.example.haya_sparkle.Pertemuan4.Custom1Activity
import com.example.haya_sparkle.Pertemuan4.Custom2Activity
import com.example.haya_sparkle.Pertemuan4.WebViewActivity
import com.example.haya_sparkle.databinding.FragmentHomeBinding

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}