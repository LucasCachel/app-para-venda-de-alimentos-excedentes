package com.myapp.alimentoamigo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.myapp.alimentoamigo.R
import com.myapp.alimentoamigo.databinding.ActivityMyRestaurantBinding

@Suppress("DEPRECATION")
class MyRestaurantActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyRestaurantBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()

        binding.tvAddProduct.setOnClickListener {
            startActivity(Intent(this, MyRestaurantAddProductActivity::class.java))
        }

        binding.btListProducts.setOnClickListener {
            startActivity(Intent(this, MyRestaurantProductListActivity::class.java))
        }
    }

    private fun setToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_white)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_my_restaurant_menu, menu)
        return true
    }
}