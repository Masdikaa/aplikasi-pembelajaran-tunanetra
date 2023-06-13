package com.himawan.pembelajarantunanetra.activity

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.himawan.pembelajarantunanetra.R
import com.himawan.pembelajarantunanetra.databinding.ActivitySingGamesBinding

class SingGamesActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingGamesBinding

    // FOR VIDEOVIEW
    private var mediaController: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivitySingGamesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoView = binding.videoView
        val videoUrl = Uri.parse("android.resource://$packageName/${R.raw.video_asset}")

        binding.btnPlayPause.setOnClickListener {
//            mediaController = MediaController(this)
//            mediaController!!.setAnchorView(binding.videoView)
//            binding.videoView.setMediaController(mediaController)
            videoView.setVideoURI(videoUrl)
            videoView.requestFocus()
            videoView.start()

        }

    }
}