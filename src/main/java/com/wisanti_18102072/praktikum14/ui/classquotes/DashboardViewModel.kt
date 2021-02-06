package com.wisanti_18102072.praktikum14.ui.classquotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is classquotes Fragment"
    }
    val text: LiveData<String> = _text
}