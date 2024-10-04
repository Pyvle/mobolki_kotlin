package com.example.practice2_on_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class Fragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_2, container, false)

        view.findViewById<Button>(R.id.buttonGotoScreen3).setOnClickListener {
            val fragment3 = Fragment3()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment3)
                .addToBackStack(null)
                .commit()
        }
        return view
    }
}