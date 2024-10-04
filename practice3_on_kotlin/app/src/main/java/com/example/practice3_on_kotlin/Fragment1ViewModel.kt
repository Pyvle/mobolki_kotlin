package com.example.practice3_on_kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Fragment1ViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Это 1 фрагмент"
    }
    val text: LiveData<String> = _text
}