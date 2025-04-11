package com.example.pr3_kotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pr3_kotlin.R
import com.example.pr3_kotlin.databinding.Fragment1Binding
import com.example.pr3_kotlin.viewmodel.FirstFragmentViewModel

class FirstFragment : Fragment() {
    private lateinit var viewModel: FirstFragmentViewModel
    private lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(FirstFragmentViewModel::class.java)

        binding.imageView.setOnClickListener {
            viewModel.changeImage()
        }

        viewModel._currentImage.observe(viewLifecycleOwner,
            Observer { data ->
                binding.imageView.setImageResource(data)
            })

        // Ручное управление
        //        buttonNext.setOnClickListener {
        //            val fragment2 = Fragment2()
        //            parentFragmentManager.beginTransaction()
        //                .replace(R.id.fragment_container, fragment2)
        //                .addToBackStack(null)
        //                .commit()
        //        }

        // Навигация с помощью API
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_fragment1_to_fragment2)
        }
        return binding.root
    }

}