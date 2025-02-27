package com.myapp.alimentoamigo.activities

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.myapp.alimentoamigo.R
import com.myapp.alimentoamigo.adaters.PagerRestaurantDetailAdapter
import com.myapp.alimentoamigo.databinding.ActivityRestaurantDetailBinding
import com.myapp.alimentoamigo.models.RestaurantData


@Suppress("DEPRECATION")
class RestaurantDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRestaurantDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()

        val restaurantData = intent.getParcelableExtra<RestaurantData>("OBJECT_INTENT")
        binding.tvRestaurantName.text = restaurantData!!.name
        binding.tvRestaurantHighlight.text = restaurantData.highlight
        binding.ivRestaurantImage.setImageResource(restaurantData.image)

        binding.viewPager.adapter = PagerRestaurantDetailAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, index ->
            tab.text = when (index) {
                0 -> { "Menu" }
                1 -> { "Sobre" }
                else -> { throw Resources.NotFoundException("Position not found")}
            }
        }.attach()

        binding.constraintOrderButton.setOnClickListener {
            val intent = Intent (this, CartDetailActivity::class.java)
            startActivity(intent)
        }

    }

    private fun setToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_new_24)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_restaurant_detail_menu, menu)
        return true
    }
}