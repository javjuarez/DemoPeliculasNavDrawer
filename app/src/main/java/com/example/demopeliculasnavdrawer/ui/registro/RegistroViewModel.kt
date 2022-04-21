package com.example.demopeliculasnavdrawer.ui.registro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistroViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Ingrese sus datos para el registro"
    }
    val text: LiveData<String> = _text
}