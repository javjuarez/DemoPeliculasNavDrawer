package com.example.demopeliculasnavdrawer.ui.registro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.demopeliculasnavdrawer.databinding.FragmentRegistroBinding

class RegistroFragment : Fragment() {

    private var _binding: FragmentRegistroBinding? = null
    private val regexPassword = Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
    private val regexEmail = Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(RegistroViewModel::class.java)

        _binding = FragmentRegistroBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        with(binding) {
            textEditNombre.addTextChangedListener {
                textLayoutNombre.isErrorEnabled = false
                textLayoutNombre.error = null
            }
            textEditCorreo.addTextChangedListener {
                textLayoutCorreo.isErrorEnabled = false
                textLayoutCorreo.error = null
            }
            textEditPassword.addTextChangedListener {
                textLayoutPassword.isErrorEnabled = false
                textLayoutPassword.error = null
            }
            buttonRegistro.setOnClickListener {
                checkTextFields(this)
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun checkTextFields(binding: FragmentRegistroBinding) {
        var camposValidos = true
        with(binding) {
            // Nombre
            val nombreText = textEditNombre.text.toString()
            if (nombreText == "") {
                textLayoutNombre.error = "El nombre no puede estar vacío."
                camposValidos = false
            }
            // Email
            val emailText = textEditCorreo.text.toString()
            if (emailText == "") {
                textLayoutCorreo.error = "El correo no puede estar vacío."
                camposValidos = false
            }
            if (!regexEmail.matches(emailText)) {
                textLayoutCorreo.error = "Ingrese un correo válido"
                camposValidos = false
            }
            // Password
            val passwordText = textEditPassword.text.toString()
            if (!regexPassword.matches(passwordText)) {
                textLayoutPassword.error =
                    "La contraseña debe tener al menos 6 caracteres, una letra y un número"
                camposValidos = false
            }
        }
        if (camposValidos) {
            Toast.makeText(context, "Todos los campos son válidos", Toast.LENGTH_SHORT).show()
        }
    }
}