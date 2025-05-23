package com.example.pr3_kotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pr3_kotlin.R

class ThirdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_3, container, false)

        // Ручное управление
        val buttonBack: Button = view.findViewById(R.id.btn_back)

//        buttonBack.setOnClickListener {
//            parentFragmentManager.popBackStack()
//        }

        // API
        buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }

        return view
    }
}