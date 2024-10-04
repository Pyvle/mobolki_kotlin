package com.example.practice2_on_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class Fragment1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_1, container, false)

        view.findViewById<Button>(R.id.buttonGotoScreen2).setOnClickListener {
            val fragment2 = Fragment2()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment2)
                .addToBackStack(null)
                .commit()
        }
        return view
    }
}