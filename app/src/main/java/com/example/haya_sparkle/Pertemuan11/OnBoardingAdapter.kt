package com.example.haya_sparkle.Pertemuan11

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnBoardingAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnBoardingOneFragment()
            1 -> OnBoardingTwoFragment()
            2 -> OnBoardingThreeFragment()
            else -> OnBoardingOneFragment()
        }
    }
}