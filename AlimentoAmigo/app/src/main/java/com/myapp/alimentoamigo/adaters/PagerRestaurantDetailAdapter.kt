package com.myapp.alimentoamigo.adaters

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.myapp.alimentoamigo.fragments.AboutRestaurantFragment
import com.myapp.alimentoamigo.fragments.MenuRestaurantFragment

class PagerRestaurantDetailAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> { MenuRestaurantFragment() }
            1 -> { AboutRestaurantFragment() }
            else -> { throw  Resources.NotFoundException("Position not found")}
        }
    }

}