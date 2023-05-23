package com.himawan.pembelajarantunanetra.activity

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.himawan.pembelajarantunanetra.R
import com.himawan.pembelajarantunanetra.databinding.ActivityGeometryBinding

class GeometryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGeometryBinding

    private lateinit var listNamaBangunRuang: Array<String>
    private lateinit var listImageBangunRuang: Array<Int>
    private var soundVoiceOverGeometry: MediaPlayer? = null
    private var currentIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.secondary)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityGeometryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataInitialize()
        setViewIndex()

        binding.btnNext.setOnClickListener {
            currentIndex++
            setCurrentIndex()
            stopAudio(soundVoiceOverGeometry)
            setViewIndex()
        }

        binding.btnBack.setOnClickListener {
            currentIndex--
            setCurrentIndex()
            stopAudio(soundVoiceOverGeometry)
            setViewIndex()
        }

        binding.btnPlayVoice.setOnClickListener {
            when (currentIndex) {
                0 -> {
                    audioManager(soundVoiceOverGeometry, R.raw.cube_desc_voice_gttx)
                }
                1 -> {
                    audioManager(soundVoiceOverGeometry, R.raw.cuboid_desc_voice_gttx)
                }
                2 -> {
                    audioManager(soundVoiceOverGeometry, R.raw.pyramid_desc_voice_gttx)
                }
                3 -> {
                    audioManager(soundVoiceOverGeometry, R.raw.triangular_desc_voice_gttx)
                }
                4 -> {
                    audioManager(soundVoiceOverGeometry, R.raw.sphere_desc_voice_gttx)
                }
                5 -> {
                    audioManager(soundVoiceOverGeometry, R.raw.cone_desc_voice_gttx)
                }
            }
        }
    }

    private fun setCurrentIndex() {
        if (currentIndex > 5) {
            currentIndex = 0
        } else if (currentIndex < 0) {
            currentIndex = 5
        }
    }

    private fun stopAudio(mp1: MediaPlayer?) {
        mp1?.stop()
        mp1?.reset()
    }

    private fun audioManager(mp: MediaPlayer?, res: Int) {
        try {
            stopAudio(mp)
            soundVoiceOverGeometry = MediaPlayer.create(this, res)
            soundVoiceOverGeometry?.start()
        } catch (e: Exception) {
            Log.e("Error", " E : $e")
        }
    }

    private fun setViewIndex() {
        binding.imageBangunRuang.setImageResource(listImageBangunRuang[currentIndex])
        binding.tvNamaBangunRuang.text = listNamaBangunRuang[currentIndex]
    }

    override fun onPause() {
        super.onPause()
        soundVoiceOverGeometry?.stop()
        soundVoiceOverGeometry?.release()
    }

    private fun dataInitialize() {
        listNamaBangunRuang = arrayOf(
            getString(R.string.bangun_ruang_1),
            getString(R.string.bangun_ruang_2),
            getString(R.string.bangun_ruang_3),
            getString(R.string.bangun_ruang_4),
            getString(R.string.bangun_ruang_5),
            getString(R.string.bangun_ruang_6),
            getString(R.string.bangun_ruang_7)
        )

        listImageBangunRuang = arrayOf(
            R.drawable.cube,
            R.drawable.cuboid,
            R.drawable.pyramid,
            R.drawable.triangular,
            R.drawable.sphere,
            R.drawable.cone,
            R.drawable.cylinder
        )
    }
}