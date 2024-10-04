package com.example.practice3_on_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.practice3_on_kotlin.databinding.Fragment2Binding

class Fragment2 : Fragment() {
    private lateinit var binding: Fragment2Binding
    private lateinit var viewModel: Fragment2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[Fragment2ViewModel::class.java]

        // Обновление текста на основе данных ViewModel
        viewModel.text.observe(viewLifecycleOwner, Observer { newText ->
            binding.textF2.text = newText
        })

        binding.buttonGotoScreen3.setOnClickListener {
            findNavController().navigate(R.id.fragment2_to_fragment3)
        }
        return binding.root
    }
}