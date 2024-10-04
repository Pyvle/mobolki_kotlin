package com.example.practice3_on_kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Fragment2ViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Это 2 фрагмент"
    }
    val text: LiveData<String> = _text
}