package com.myapp.alimentoamigo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myapp.alimentoamigo.R
import com.myapp.alimentoamigo.databinding.ActivityMyRestaurantAddProductBinding

@Suppress("DEPRECATION")
class MyRestaurantAddProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyRestaurantAddProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyRestaurantAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()

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
}