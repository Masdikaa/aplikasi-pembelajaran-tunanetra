package com.himawan.pembelajarantunanetra.activity

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.himawan.pembelajarantunanetra.R
import com.himawan.pembelajarantunanetra.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainMenuBinding

    private var mp: MediaPlayer? = null
    private var backsoundHome: MutableList<Int> = mutableListOf(R.raw.backsound_home_menu)
    private var backPress: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.secondary)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardHewan.setOnClickListener(this)
        binding.cardMatematika.setOnClickListener(this)
        binding.cardOrgan.setOnClickListener(this)
        binding.cardBangunRuang.setOnClickListener(this)
        binding.cardBernyanyi.setOnClickListener(this)
        binding.cardKuisTubuh.setOnClickListener(this)

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

            R.id.card_bernyanyi -> {
                clickSound.start()
                startActivity(Intent(this, SingGamesActivity::class.java))
            }

            R.id.card_kuis_tubuh -> {
                clickSound.start()
                startActivity(Intent(this, QuizBodyPartActivity::class.java))
            }
        }
    }

    private fun playSound(id: Int) {
        try {
            if (mp == null) {
                mp = MediaPlayer.create(this, id)
                Log.d("MainMenuActivity", "ID = ${mp!!.audioSessionId}")
            }
            mp?.start()
            mp?.isLooping = true
        } catch (e: java.lang.NullPointerException) {
            Log.e("Error", " E : $e")
        }
    }

    override fun onStart() {
        super.onStart()
        playSound(this.backsoundHome[0])
    }

    override fun onPause() {
        super.onPause()
        try {
            if (mp !== null) mp?.pause()
        } catch (e: java.lang.NullPointerException) {
            Log.e("Error", " E : $e")
        }
    }

    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        if (backPress + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
            return
        } else {
            Toast.makeText(baseContext, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show()
        }
        System.currentTimeMillis().also { backPress = it }
    }

}