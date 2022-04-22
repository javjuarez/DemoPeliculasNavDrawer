package com.example.demopeliculasnavdrawer

import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.example.demopeliculasnavdrawer.databinding.ActivityTrailerBinding

class TrailerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrailerBinding
    private lateinit var bundle: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrailerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val video = binding.videoView1
        bundle = intent.extras!!
        binding.textView.text = getString(R.string.trailer_teaser, bundle.getString("titulo"))
        binding.videoView1.setVideoPath("android.resource://$packageName/${bundle.getInt("trailerID")}")
        val mediaController = MediaController(this)
        mediaController.setAnchorView(video)
        video.setMediaController(mediaController)
    }
}