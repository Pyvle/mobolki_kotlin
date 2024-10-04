package com.example.practice3_on_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.practice3_on_kotlin.databinding.Fragment3Binding

class Fragment3 : Fragment() {
    private lateinit var binding: Fragment3Binding
    private lateinit var viewModel: Fragment3ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment3Binding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[Fragment3ViewModel::class.java]

        // Обновление текста на основе данных ViewModel
        viewModel.text.observe(viewLifecycleOwner, Observer { newText ->
            binding.textF3.text = newText
        })

        binding.buttonGotoScreen1.setOnClickListener {
            findNavController().navigate(R.id.fragment3_to_fragment1)
        }
        return binding.root
    }
}