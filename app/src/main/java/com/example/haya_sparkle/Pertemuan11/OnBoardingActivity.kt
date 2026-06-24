package com.example.haya_sparkle.Pertemuan11

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.haya_sparkle.Pertemuan3.WelcomeActivity
import com.example.haya_sparkle.R
import com.example.haya_sparkle.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding
    private lateinit var dots: Array<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = OnBoardingAdapter(this)

        addDots(0)
        binding.btnAyoMulai.visibility = View.GONE

        binding.viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    addDots(position)
                    binding.btnAyoMulai.visibility =
                        if (position == 2) View.VISIBLE else View.GONE
                }
            }
        )

        binding.btnAyoMulai.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
            finish()
        }
    }

    private fun addDots(position: Int) {
        dots = Array(3) { TextView(this) }
        binding.layoutDots.removeAllViews()

        for (i in dots.indices) {
            dots[i].text = "●"
            dots[i].textSize = 15f
            dots[i].setTextColor(
                ContextCompat.getColor(this, android.R.color.darker_gray)
            )
            binding.layoutDots.addView(dots[i])
        }

        dots[position].setTextColor(
            ContextCompat.getColor(this, R.color.primaryGreen)
        )
    }
}