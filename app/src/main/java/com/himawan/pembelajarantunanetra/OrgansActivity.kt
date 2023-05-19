package com.himawan.pembelajarantunanetra

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.himawan.pembelajarantunanetra.databinding.ActivityOrgansBinding

class OrgansActivity : AppCompatActivity() {
    //DataBinding
    private lateinit var binding: ActivityOrgansBinding

    //Variable organ
    private lateinit var listNamaOrgan: Array<String>
    private lateinit var listImageOrgan: Array<Int>
    private var soundVoiceOverOrgan: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor =
            ContextCompat.getColor(this, R.color.secondary) //Set StatusBar Color
        binding = ActivityOrgansBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataInitialize()
        var i = 0

        //Initiate 1st slide
        binding.tvNamaOrgan.text = listNamaOrgan[i]
        binding.imageOrgan.setImageResource(listImageOrgan[i])


        binding.btnNext.setOnClickListener {
            i++
            if (i > 5) {
                i = 0
            } else if (i < 0) {
                i = 5
            }
            Log.d("Index", i.toString())
            binding.tvNamaOrgan.text = listNamaOrgan[i]
            binding.imageOrgan.setImageResource(listImageOrgan[i])
            soundVoiceOverOrgan?.stop()
            soundVoiceOverOrgan?.reset()
        }

        binding.btnBack.setOnClickListener {
            i--
            if (i > 5) {
                i = 0
            } else if (i < 0) {
                i = 5
            }
            Log.d("Index", i.toString())
            binding.tvNamaOrgan.text = listNamaOrgan[i]
            binding.imageOrgan.setImageResource(listImageOrgan[i])
            soundVoiceOverOrgan?.stop()
            soundVoiceOverOrgan?.reset()
        }

        binding.btnPlayVoice.setOnClickListener {
            when (i) {
                0 -> {
                    soundVoiceOverOrgan?.stop()
                    soundVoiceOverOrgan?.reset()
                    soundVoiceOverOrgan = MediaPlayer.create(this, R.raw.eyes_desc_voice_gttx)
                    soundVoiceOverOrgan?.start()
                }
                1 -> {
                    soundVoiceOverOrgan?.stop()
                    soundVoiceOverOrgan?.reset()
                    soundVoiceOverOrgan = MediaPlayer.create(this, R.raw.ear_desc_voice_gttx)
                    soundVoiceOverOrgan?.start()
                }
                2 -> {
                    soundVoiceOverOrgan?.stop()
                    soundVoiceOverOrgan?.reset()
                    soundVoiceOverOrgan = MediaPlayer.create(this, R.raw.lips_desc_voice_gttx)
                    soundVoiceOverOrgan?.start()
                }
                3 -> {
                    soundVoiceOverOrgan?.stop()
                    soundVoiceOverOrgan?.reset()
                    soundVoiceOverOrgan = MediaPlayer.create(this, R.raw.nose_desc_voice_gttx)
                    soundVoiceOverOrgan?.start()
                }
                4 -> {
                    soundVoiceOverOrgan?.stop()
                    soundVoiceOverOrgan?.reset()
                    soundVoiceOverOrgan = MediaPlayer.create(this, R.raw.hand_desc_voice_gttx)
                    soundVoiceOverOrgan?.start()
                }
                5 -> {
                    soundVoiceOverOrgan?.stop()
                    soundVoiceOverOrgan?.reset()
                    soundVoiceOverOrgan = MediaPlayer.create(this, R.raw.foot_desc_voice_gttx)
                    soundVoiceOverOrgan?.start()
                }
            }
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
