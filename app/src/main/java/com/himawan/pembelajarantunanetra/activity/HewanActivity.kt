package com.himawan.pembelajarantunanetra.activity

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.himawan.pembelajarantunanetra.R
import com.himawan.pembelajarantunanetra.databinding.ActivityHewanBinding

class HewanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHewanBinding
    private var soundHewan: MediaPlayer? = null
    private var soundVoiceOverHewan: MediaPlayer? = null

    private lateinit var listNamaHewan: Array<String>
    private lateinit var listImageHewan: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor =
            ContextCompat.getColor(this, R.color.secondary) //Set StatusBar Color
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) //Always LightTheme
        binding = ActivityHewanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataInitialize()
        var i = 0

        //Initialize Variable
        binding.imageHewan.setImageResource(listImageHewan[i])
        binding.tvNamaHewan.text = listNamaHewan[i]

        binding.btnNext.setOnClickListener {
            i++
            soundHewan?.stop()
            soundHewan?.reset()
            soundVoiceOverHewan?.stop()
            soundVoiceOverHewan?.reset()
            if (i > 5) {
                i = 0
            } else if (i < 0) {
                i = 5
            }
            Log.d("Index", i.toString())
            binding.imageHewan.setImageResource(listImageHewan[i])
            binding.tvNamaHewan.text = listNamaHewan[i]
        }

        binding.btnBack.setOnClickListener {
            i--
            soundHewan?.stop()
            soundHewan?.reset()
            soundVoiceOverHewan?.stop()
            soundVoiceOverHewan?.reset()
            if (i > 5) {
                i = 0
            } else if (i < 0) {
                i = 5
            }
            Log.d("Index", i.toString())
            binding.imageHewan.setImageResource(listImageHewan[i])
            binding.tvNamaHewan.text = listNamaHewan[i]
        }

        binding.imageHewan.setOnClickListener {
            when (i) {
                0 -> {
                    soundVoiceOverHewan?.stop()
                    soundVoiceOverHewan?.reset()
                    soundHewan?.stop()
                    soundHewan?.reset()
                    soundHewan = MediaPlayer.create(this, R.raw.cat_sound)
                    soundHewan?.start()
                }
                1 -> {
                    soundVoiceOverHewan?.stop()
                    soundVoiceOverHewan?.reset()
                    soundHewan?.stop()
                    soundHewan?.reset()
                    soundHewan = MediaPlayer.create(this, R.raw.dog_sound)
                    soundHewan?.start()
                }
                2 -> {
                    soundVoiceOverHewan?.stop()
                    soundVoiceOverHewan?.reset()
                    soundHewan?.stop()
                    soundHewan?.reset()
                    soundHewan = MediaPlayer.create(this, R.raw.cow_sound)
                    soundHewan?.start()
                }
                3 -> {
                    soundVoiceOverHewan?.stop()
                    soundVoiceOverHewan?.reset()
                    soundHewan?.stop()
                    soundHewan?.reset()
                    soundHewan = MediaPlayer.create(this, R.raw.sheep_sound)
                    soundHewan?.start()
                }
                4 -> {
                    soundVoiceOverHewan?.stop()
                    soundVoiceOverHewan?.reset()
                    soundHewan?.stop()
                    soundHewan?.reset()
                    soundHewan = MediaPlayer.create(this, R.raw.horse_sound)
                    soundHewan?.start()
                }
                5 -> {
                    soundVoiceOverHewan?.stop()
                    soundVoiceOverHewan?.reset()
                    soundHewan?.stop()
                    soundHewan?.reset()
                    soundHewan = MediaPlayer.create(this, R.raw.chicken_sound)
                    soundHewan?.start()
                }
            }
        }

        binding.btnPlayVoice.setOnClickListener {
            when (i) {
                0 -> {
                    soundHewan?.stop()
                    soundHewan?.reset()
                    soundVoiceOverHewan?.stop()
                    soundVoiceOverHewan?.reset()
                    soundVoiceOverHewan = MediaPlayer.create(this, R.raw.cat_desc_voice_gttx)
                    soundVoiceOverHewan?.start()
                }
                1 -> {
                    soundHewan?.stop()
                    soundHewan?.reset()
                    soundVoiceOverHewan?.stop()
                    soundVoiceOverHewan?.reset()
                    soundVoiceOverHewan = MediaPlayer.create(this, R.raw.dog_desc_voice_gttx)
                    soundVoiceOverHewan?.start()
                }
                2 -> {
                    soundHewan?.stop()
                    soundHewan?.reset()
                    soundVoiceOverHewan?.stop()
                    soundVoiceOverHewan?.reset()
                    soundVoiceOverHewan = MediaPlayer.create(this, R.raw.cow_desc_voice_gttx)
                    soundVoiceOverHewan?.start()
                }
                3 -> {
                    soundHewan?.stop()
                    soundHewan?.reset()
                    soundVoiceOverHewan?.stop()
                    soundVoiceOverHewan?.reset()
                    soundVoiceOverHewan = MediaPlayer.create(this, R.raw.sheep_desc_voice_gttx)
                    soundVoiceOverHewan?.start()
                }
                4 -> {
                    soundHewan?.stop()
                    soundHewan?.reset()
                    soundVoiceOverHewan?.stop()
                    soundVoiceOverHewan?.reset()
                    soundVoiceOverHewan = MediaPlayer.create(this, R.raw.horse_desc_voice_gttx)
                    soundVoiceOverHewan?.start()
                }
                5 -> {
                    soundHewan?.stop()
                    soundHewan?.reset()
                    soundVoiceOverHewan?.stop()
                    soundVoiceOverHewan?.reset()
                    soundVoiceOverHewan = MediaPlayer.create(this, R.raw.chicken_desc_voice_gttx)
                    soundVoiceOverHewan?.start()
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        soundHewan?.stop()
        soundHewan?.release()
        soundVoiceOverHewan?.stop()
        soundVoiceOverHewan?.release()
    }

    private fun dataInitialize() {
        listNamaHewan = arrayOf(
            getString(R.string.hewan1),
            getString(R.string.hewan2),
            getString(R.string.hewan3),
            getString(R.string.hewan4),
            getString(R.string.hewan5),
            getString(R.string.hewan6),
        )

        listImageHewan = arrayOf(
            R.drawable.image_cat,
            R.drawable.image_dog,
            R.drawable.image_cow,
            R.drawable.image_sheep,
            R.drawable.horse_image,
            R.drawable.image_chicken
        )
    }
}