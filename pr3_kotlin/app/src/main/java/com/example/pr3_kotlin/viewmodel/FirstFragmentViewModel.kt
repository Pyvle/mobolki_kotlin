package com.example.pr3_kotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pr3_kotlin.R

class FirstFragmentViewModel: ViewModel() {
    val _currentImage = MutableLiveData<Int>(R.drawable.forza)
    private var imageChanged = false

    fun changeImage() {
        if (!imageChanged) {
            _currentImage.value = R.drawable.forza
            imageChanged = true
        } else {
            _currentImage.value = R.drawable.forza
            imageChanged = false
        }
    }
}