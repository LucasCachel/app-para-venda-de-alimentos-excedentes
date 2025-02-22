package com.myapp.alimentoamigo.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import com.myapp.alimentoamigo.R
import com.myapp.alimentoamigo.activities.RegisterRestaurantActivity

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btConnnectRestaurant = view.findViewById<AppCompatButton>(R.id.btConnectRestaurant)
        btConnnectRestaurant.setOnClickListener {
            val intent = Intent(context, RegisterRestaurantActivity::class.java)
            startActivity(intent)
        }
    }


}