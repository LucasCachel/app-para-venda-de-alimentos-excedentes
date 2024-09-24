package com.myapp.alimentoamigo.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.myapp.alimentoamigo.R
import com.myapp.alimentoamigo.activities.OnGoingDetailActivity

class OnGoingOrdersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_on_going_orders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cvOnGoingItem: CardView = view.findViewById(R.id.cvOnGoingItem)
        cvOnGoingItem.setOnClickListener {
            val intent = Intent(context, OnGoingDetailActivity::class.java)
            startActivity(intent)
        }
    }
}