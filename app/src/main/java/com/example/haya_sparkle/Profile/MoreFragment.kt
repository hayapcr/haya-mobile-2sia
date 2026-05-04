package com.example.haya_sparkle.Profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.haya_sparkle.R
import com.example.haya_sparkle.databinding.FragmentMoreBinding


class MoreFragment : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnLinkedin.setOnClickListener {
            openLink("https://www.linkedin.com/in/haya-nur-rizky-9a2a42331/")
        }

        binding.btnGithub.setOnClickListener {
            openLink("https://github.com/hayapcr/haya-space.git")
        }

        binding.btnInstagram.setOnClickListener {
            openLink("https://www.instagram.com/hayanr_25")
        }
    }

    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}