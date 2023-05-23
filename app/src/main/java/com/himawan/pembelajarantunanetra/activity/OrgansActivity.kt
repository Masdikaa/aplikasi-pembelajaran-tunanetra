package com.himawan.pembelajarantunanetra.activity

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.himawan.pembelajarantunanetra.R
import com.himawan.pembelajarantunanetra.databinding.ActivityOrgansBinding

class OrgansActivity : AppCompatActivity() {
    //DataBinding
    private lateinit var binding: ActivityOrgansBinding

    //Variable organ
    private lateinit var listNamaOrgan: Array<String>
    private lateinit var listImageOrgan: Array<Int>
    private var soundVoiceOverOrgan: MediaPlayer? = null
    private var currentIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.secondary)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityOrgansBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataInitialize()
        setViewIndex()

        binding.btnNext.setOnClickListener {
            currentIndex++
            setCurrentIndex()
            setViewIndex()
            stopAudio(soundVoiceOverOrgan)
        }

        binding.btnBack.setOnClickListener {
            currentIndex--
            setCurrentIndex()
            setViewIndex()
            stopAudio(soundVoiceOverOrgan)
        }

        binding.btnPlayVoice.setOnClickListener {
            when (currentIndex) {
                0 -> {
                    audioManager(soundVoiceOverOrgan, R.raw.eyes_desc_voice_gttx)
                }
                1 -> {
                    audioManager(soundVoiceOverOrgan, R.raw.ear_desc_voice_gttx)
                }
                2 -> {
                    audioManager(soundVoiceOverOrgan, R.raw.lips_desc_voice_gttx)
                }
                3 -> {
                    audioManager(soundVoiceOverOrgan, R.raw.nose_desc_voice_gttx)
                }
                4 -> {
                    audioManager(soundVoiceOverOrgan, R.raw.hand_desc_voice_gttx)
                }
                5 -> {
                    audioManager(soundVoiceOverOrgan, R.raw.foot_desc_voice_gttx)
                }
            }
        }
    }

    private fun audioManager(mp: MediaPlayer?, res: Int) {
        try {
            stopAudio(mp)
            soundVoiceOverOrgan = MediaPlayer.create(this, res)
            soundVoiceOverOrgan?.start()
        } catch (e: Exception) {
            Log.e("Error", " E : $e")
        }
    }

    private fun stopAudio(mp1: MediaPlayer?) {
        mp1?.stop()
        mp1?.reset()
    }

    private fun setViewIndex() {
        binding.tvNamaOrgan.text = listNamaOrgan[currentIndex]
        binding.imageOrgan.setImageResource(listImageOrgan[currentIndex])
    }

    private fun setCurrentIndex() {
        if (currentIndex > 5) {
            currentIndex = 0
        } else if (currentIndex < 0) {
            currentIndex = 5
        }
    }

    private fun dataInitialize() {
        listNamaOrgan = arrayOf(
            getString(R.string.organ1),
            getString(R.string.organ2),
            getString(R.string.organ3),
            getString(R.string.organ4),
            getString(R.string.organ5),
            getString(R.string.organ6),
        )
        listImageOrgan = arrayOf(
            R.drawable.image_eye2,
            R.drawable.image_ear_3,
            R.drawable.image_lip,
            R.drawable.image_nose,
            R.drawable.image_hand,
            R.drawable.image_angkle
        )
    }

    override fun onPause() {
        super.onPause()
        soundVoiceOverOrgan?.stop()
        soundVoiceOverOrgan?.release()
    }
}
