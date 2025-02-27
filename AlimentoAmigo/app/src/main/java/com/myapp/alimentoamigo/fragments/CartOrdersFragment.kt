package com.myapp.alimentoamigo.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.myapp.alimentoamigo.R
import com.myapp.alimentoamigo.activities.CartDetailActivity

class CartOrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cart_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cvCartItem: CardView = view.findViewById(R.id.cvCartItem)
        cvCartItem.setOnClickListener {
            val intent = Intent(context, CartDetailActivity::class.java)
            startActivity(intent)
        }
    }
}