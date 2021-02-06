package com.wisanti_18102072.praktikum14.ui.myquotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is globalquotes Fragment"
    }
    val text: LiveData<String> = _text
}