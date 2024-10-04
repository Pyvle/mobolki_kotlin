package com.example.practice3_on_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.practice3_on_kotlin.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    private lateinit var binding: Fragment1Binding
    private lateinit var viewModel: Fragment1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[Fragment1ViewModel::class.java]

        // Обновление текста на основе данных ViewModel
        viewModel.text.observe(viewLifecycleOwner, Observer { newText ->
            binding.textF1.text = newText
        })

        binding.buttonGotoScreen2.setOnClickListener {
            findNavController().navigate(R.id.fragment1_to_fragment2)
        }
        return binding.root
    }
}