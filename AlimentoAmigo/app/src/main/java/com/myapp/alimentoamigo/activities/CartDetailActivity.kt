package com.myapp.alimentoamigo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myapp.alimentoamigo.R
import com.myapp.alimentoamigo.databinding.ActivityCartDetailBinding

@Suppress("DEPRECATION")
class CartDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()

        binding.btBuyNow.setOnClickListener {
            val intent = Intent(this, OnGoingDetailActivity::class.java)
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
}