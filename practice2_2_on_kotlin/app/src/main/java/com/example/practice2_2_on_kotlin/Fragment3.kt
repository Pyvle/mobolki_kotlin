package com.example.practice2_2_on_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.practice2_2_on_kotlin.databinding.Fragment1Binding
import com.example.practice2_2_on_kotlin.databinding.Fragment3Binding

class Fragment3 : Fragment() {
    private lateinit var binding: Fragment3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment3Binding.inflate(inflater, container, false)
        binding.buttonGotoScreen1.setOnClickListener {
            findNavController().navigate(R.id.fragment3_to_fragment1)
        }
        return binding.root
    }
}