package com.myapp.alimentoamigo.activities

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myapp.alimentoamigo.R
import com.myapp.alimentoamigo.databinding.ActivityMenuDetailBinding
import com.myapp.alimentoamigo.models.MenuData

@Suppress("DEPRECATION")
class MenuDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()

        val menuData = intent.getParcelableExtra<MenuData>("OBJECT_INTENT")
        binding.tvMenuTitle.text = menuData?.name
        binding.tvStockAmount.text = "${menuData?.stock} left"
        binding.tvPrice.text = "R$${menuData?.price}"
        binding.tvDescription.text = menuData?.description
        binding.tvPriceNormal.text = "R$${menuData?.normalPrice}"
        binding.tvPriceNormal.paintFlags = binding.tvPriceNormal.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG // set strike text
        binding.tvExpire.text = menuData?.expireDate
        binding.ivMenuImage.setImageResource(menuData!!.image)

        binding.btAdd.setOnClickListener {
            finish()
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
}