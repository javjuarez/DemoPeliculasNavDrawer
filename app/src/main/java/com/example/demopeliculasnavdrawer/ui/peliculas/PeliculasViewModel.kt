package com.example.demopeliculasnavdrawer.ui.peliculas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PeliculasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Peliculas populares"
    }
    val text: LiveData<String> = _text
}