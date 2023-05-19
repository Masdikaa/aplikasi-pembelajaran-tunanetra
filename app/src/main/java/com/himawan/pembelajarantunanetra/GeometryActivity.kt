package com.himawan.pembelajarantunanetra

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.himawan.pembelajarantunanetra.databinding.ActivityGeometryBinding

class GeometryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGeometryBinding

    //Variable bangun ruang
    private lateinit var listNamaBangunRuang: Array<String>
    private lateinit var listImageBangunRuang: Array<Int>
    private var soundVoiceOverGeometry: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor =
            ContextCompat.getColor(this, R.color.secondary) //Set StatusBar Color
        binding = ActivityGeometryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisiasi data bangun ruang
        dataInitialize()
        var i = 0;

        //Initiate 1st layout
        binding.imageBangunRuang.setImageResource(listImageBangunRuang[i])
        binding.tvNamaBangunRuang.text = listNamaBangunRuang[i]

        binding.btnNext.setOnClickListener {
            i++
            if (i > 5) {
                i = 0
            } else if (i < 0) {
                i = 5
            }
            Log.d("Index", i.toString())
            soundVoiceOverGeometry?.stop()
            soundVoiceOverGeometry?.reset()
            binding.imageBangunRuang.setImageResource(listImageBangunRuang[i])
            binding.tvNamaBangunRuang.text = listNamaBangunRuang[i]
        }

        binding.btnBack.setOnClickListener {
            i--
            if (i > 5) {
                i = 0
            } else if (i < 0) {
                i = 5
            }
            Log.d("Index", i.toString())
            soundVoiceOverGeometry?.stop()
            soundVoiceOverGeometry?.reset()
            binding.imageBangunRuang.setImageResource(listImageBangunRuang[i])
            binding.tvNamaBangunRuang.text = listNamaBangunRuang[i]
        }

        binding.btnPlayVoice.setOnClickListener {
            when (i) {
                0 -> {
                    soundVoiceOverGeometry?.stop()
                    soundVoiceOverGeometry?.reset()
                    soundVoiceOverGeometry = MediaPlayer.create(this, R.raw.cube_desc_voice_gttx)
                    soundVoiceOverGeometry?.start()
                }
                1 -> {
                    soundVoiceOverGeometry?.stop()
                    soundVoiceOverGeometry?.reset()
                    soundVoiceOverGeometry = MediaPlayer.create(this, R.raw.cuboid_desc_voice_gttx)
                    soundVoiceOverGeometry?.start()
                }
                2 -> {
                    soundVoiceOverGeometry?.stop()
                    soundVoiceOverGeometry?.reset()
                    soundVoiceOverGeometry =
                        MediaPlayer.create(this, R.raw.pyramid_desc_voice_gttx)
                    soundVoiceOverGeometry?.start()
                }
                3 -> {
                    soundVoiceOverGeometry?.stop()
                    soundVoiceOverGeometry?.reset()
                    soundVoiceOverGeometry =
                        MediaPlayer.create(this, R.raw.triangular_desc_voice_gttx)
                    soundVoiceOverGeometry?.start()
                }
                4 -> {
                    soundVoiceOverGeometry?.stop()
                    soundVoiceOverGeometry?.reset()
                    soundVoiceOverGeometry = MediaPlayer.create(this, R.raw.sphere_desc_voice_gttx)
                    soundVoiceOverGeometry?.start()
                }
                5 -> {
                    soundVoiceOverGeometry?.stop()
                    soundVoiceOverGeometry?.reset()
                    soundVoiceOverGeometry = MediaPlayer.create(this, R.raw.cone_desc_voice_gttx)
                    soundVoiceOverGeometry?.start()
                }
            }
        }

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