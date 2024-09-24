package com.myapp.alimentoamigo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.myapp.alimentoamigo.R
import com.myapp.alimentoamigo.adaters.PagerAdapter
import com.myapp.alimentoamigo.databinding.ActivityOnboardingBinding
import com.myapp.alimentoamigo.models.OnBoardingData

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding
    private var itemList = ArrayList<OnBoardingData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewPager()
    }

    private fun setUpViewPager() {
        itemList = getItems()
        binding.viewpager.adapter = PagerAdapter(itemList)
        binding.wormDot.attachTo(binding.viewpager)
        binding.viewpager.registerOnPageChangeCallback(pageChangeCallback)
    }

    private var pageChangeCallback: ViewPager2.OnPageChangeCallback = object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)

            if(position == itemList.size -1) {
                binding.tvNext.text = "Vamos salvar a comida"
            } else {
                binding.tvNext.text = "Avançar!"
            }
        }
    }

    private fun getItems(): ArrayList<OnBoardingData> {
        val items = ArrayList<OnBoardingData>()

        items.add(
            OnBoardingData(
                "Vamos juntos salvar o alimento",
                "Toda comida que é desperdiçada pode danificar\n" +
                        "O ambiente e nosso planeta\n" +
                        "Vamos juntos salvar o alimento",
                R.drawable.il_motherearthdaypana
            )
        )

        items.add(
            OnBoardingData(
                "Obtenha comida saborosa a um preço acessível!",
                "Esse app vai te ajudar a encontrar\n" +
                        "Comidas deliciosas por preços acessíveis enquanto\n" +
                        "protege o ambiente",
                R.drawable.il_shawarmapana
            )
        )

        items.add(
            OnBoardingData(
                "Encontre a melhor refeição perto de você",
                "Você pode encontrar a melhor refeição com as melhores ofertas\n" +
                        "perto de você, pague no aplicativo e\n" +
                        "pegue sua comida",
                R.drawable.il_orderfoodpana
            )
        )
        return items
    }

    fun onClick(v: View) {
        when (v) {
            binding.tvNext -> {
                val currentItemPosition = binding.viewpager.currentItem
                if (currentItemPosition == itemList.size - 1) {
                    val intent = Intent(this@OnboardingActivity, SigninActivity::class.java)
                    startActivity(intent)
                    return
                }
                binding.viewpager.setCurrentItem(currentItemPosition + 1, true)
            }
        }
    }
}