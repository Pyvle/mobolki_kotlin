package com.example.practice2_2_on_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.practice2_2_on_kotlin.databinding.Fragment1Binding
import com.example.practice2_2_on_kotlin.databinding.Fragment2Binding

class Fragment2 : Fragment() {
    private lateinit var binding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater, container, false)
        binding.buttonGotoScreen3.setOnClickListener {
            findNavController().navigate(R.id.fragment2_to_fragment3)
        }
        return binding.root
    }
}