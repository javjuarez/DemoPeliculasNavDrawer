package com.example.demopeliculasnavdrawer.ui.peliculas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.demopeliculasnavdrawer.databinding.ElementoListViewBinding

class PeliculaAdapter(private val context: Context?, val datos: ArrayList<Pelicula>) :
    BaseAdapter() {
    private val layoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return datos.size
    }

    override fun getItem(pos: Int): Any {
        return datos[pos]
    }

    override fun getItemId(pos: Int): Long {
        return datos[pos].id
    }

    override fun getView(pos: Int, view: View?, viewGroup: ViewGroup?): View {
        val binding = ElementoListViewBinding.inflate(layoutInflater)
        with(binding) {
            textViewTitulo.text = datos[pos].titulo
            textViewResumen.text = datos[pos].resumen
            textViewGeneros.text = datos[pos].generos
            imageViewPortada.setImageResource(datos[pos].imagen)
        }
        return binding.root
    }
}