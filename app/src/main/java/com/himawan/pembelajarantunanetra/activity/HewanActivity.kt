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
    private var currentIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.secondary)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityHewanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataInitialize()
        setViewIndex()

        binding.btnNext.setOnClickListener {
            currentIndex++
            audioManager(soundHewan, soundVoiceOverHewan)
            setCurrenIndex()
            setViewIndex()
        }

        binding.btnBack.setOnClickListener {
            currentIndex--
            audioManager(soundHewan, soundVoiceOverHewan)
            setCurrenIndex()
            setViewIndex()
        }

        binding.imageHewan.setOnClickListener {
            when (currentIndex) {
                0 -> {
                    audioManager(soundVoiceOverHewan, soundHewan)
                    soundHewan = MediaPlayer.create(this, R.raw.cat_sound)
                    soundHewan?.start()
                }
                1 -> {
                    audioManager(soundVoiceOverHewan, soundHewan)
                    soundHewan = MediaPlayer.create(this, R.raw.dog_sound)
                    soundHewan?.start()
                }
                2 -> {
                    audioManager(soundVoiceOverHewan, soundHewan)
                    soundHewan = MediaPlayer.create(this, R.raw.cow_sound)
                    soundHewan?.start()
                }
                3 -> {
                    audioManager(soundVoiceOverHewan, soundHewan)
                    soundHewan = MediaPlayer.create(this, R.raw.sheep_sound)
                    soundHewan?.start()
                }
                4 -> {
                    audioManager(soundVoiceOverHewan, soundHewan)
                    soundHewan = MediaPlayer.create(this, R.raw.horse_sound)
                    soundHewan?.start()
                }
                5 -> {
                    audioManager(soundVoiceOverHewan, soundHewan)
                    soundHewan = MediaPlayer.create(this, R.raw.chicken_sound)
                    soundHewan?.start()
                }
            }
        }
        binding.btnPlayVoice.setOnClickListener {
            when (currentIndex) {
                0 -> {
                    audioManager(soundHewan, soundVoiceOverHewan)
                    setMediaPlayerResource(R.raw.cat_desc_voice_gttx)
                }
                1 -> {
                    audioManager(soundHewan, soundVoiceOverHewan)
                    setMediaPlayerResource(R.raw.dog_desc_voice_gttx)
                }
                2 -> {
                    audioManager(soundHewan, soundVoiceOverHewan)
                    setMediaPlayerResource(R.raw.cow_desc_voice_gttx)
                }
                3 -> {
                    audioManager(soundHewan, soundVoiceOverHewan)
                    setMediaPlayerResource(R.raw.sheep_desc_voice_gttx)
                }
                4 -> {
                    audioManager(soundHewan, soundVoiceOverHewan)
                    setMediaPlayerResource(R.raw.horse_desc_voice_gttx)
                }
                5 -> {
                    audioManager(soundHewan, soundVoiceOverHewan)
                    setMediaPlayerResource(R.raw.chicken_desc_voice_gttx)
                }
            }
        }
    }

    private fun audioManager(soundHewan: MediaPlayer?, voice: MediaPlayer?) {
        try {
            soundHewan?.stop()
            soundHewan?.reset()
            voice?.stop()
            voice?.reset()
        } catch (e: NullPointerException) {
            Log.e("Error", " E : $e")
        }
    }

    private fun setMediaPlayerResource(res: Int) {
        try {
            soundVoiceOverHewan = MediaPlayer.create(this, res)
            soundVoiceOverHewan?.start()
        } catch (e: Exception) {
            Log.e("Error", " E : $e")
        }
    }

    private fun setCurrenIndex() {
        if (currentIndex > 5) {
            currentIndex = 0
        } else if (currentIndex < 0) {
            currentIndex = 5
        }
    }

    private fun setViewIndex() {
        binding.imageHewan.setImageResource(listImageHewan[currentIndex])
        binding.tvNamaHewan.text = listNamaHewan[currentIndex]
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