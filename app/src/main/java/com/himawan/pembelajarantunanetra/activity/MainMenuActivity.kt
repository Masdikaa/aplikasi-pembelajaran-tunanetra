package com.himawan.pembelajarantunanetra.activity

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.himawan.pembelajarantunanetra.*
import com.himawan.pembelajarantunanetra.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainMenuBinding

    private var mp: MediaPlayer? = null
    private var backsoundHome: MutableList<Int> = mutableListOf(R.raw.backsound_home_menu)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor =
            ContextCompat.getColor(this, R.color.secondary) //Set StatusBar Color
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) //Always LightTheme
        binding = ActivityMainMenuBinding.inflate(layoutInflater) // InflateBinding
        setContentView(binding.root)

        binding.cardHewan.setOnClickListener(this)
        binding.cardMatematika.setOnClickListener(this)
        binding.cardOrgan.setOnClickListener(this)
        binding.cardBangunRuang.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        val clickSound: MediaPlayer = MediaPlayer.create(this, R.raw.mouse_click)
        when (v.id) {
            R.id.card_hewan -> {
                clickSound.start()
                startActivity(Intent(this, HewanActivity::class.java))
            }
            R.id.card_matematika -> {
                clickSound.start()
                startActivity(Intent(this, MathActivity::class.java))
            }
            R.id.card_organ -> {
                clickSound.start()
                startActivity(Intent(this, OrgansActivity::class.java))
            }
            R.id.card_bangun_ruang -> {
                clickSound.start()
                startActivity(Intent(this, GeometryActivity::class.java))
            }
        }
    }

    override fun onStart() {
        super.onStart()
        playSound(this.backsoundHome[0])
    }

    override fun onPause() {
        super.onPause()
        if (mp !== null) mp?.pause()
    }

    private fun playSound(id: Int) {
        if (mp == null) {
            mp = MediaPlayer.create(this, id)
            Log.d("MainMenuActivity", "ID = ${mp!!.audioSessionId}")
        }
        mp?.start()
        mp?.isLooping = true
    }
}
