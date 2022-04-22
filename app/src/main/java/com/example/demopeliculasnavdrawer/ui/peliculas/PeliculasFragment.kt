package com.example.demopeliculasnavdrawer.ui.peliculas

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.demopeliculasnavdrawer.TrailerActivity
import com.example.demopeliculasnavdrawer.databinding.FragmentPeliculasBinding

class PeliculasFragment : Fragment() {

    private var _binding: FragmentPeliculasBinding? = null
    private lateinit var datos: ArrayList<Pelicula>

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(PeliculasViewModel::class.java)

        _binding = FragmentPeliculasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        datos = Pelicula.generateData()

        val parametros = Bundle()
        binding.listViewPeliculas.adapter = PeliculaAdapter(context, datos)
        binding.listViewPeliculas.setOnItemClickListener { adapterView, view, position, l ->
            val peliculaSelect = adapterView.adapter.getItem(position) as Pelicula
            val intent = Intent(context, TrailerActivity::class.java)
            parametros.putString("titulo", peliculaSelect.titulo)
            parametros.putInt("trailerID", peliculaSelect.trailer)
            intent.putExtras(parametros)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}