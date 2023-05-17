package com.himawan.pembelajarantunanetra

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.himawan.pembelajarantunanetra.databinding.ActivityHewanBinding

class HewanActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHewanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor =
            ContextCompat.getColor(this, R.color.white) //Set StatusBar Color
        binding = ActivityHewanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Initialize Variable
        binding.imageHewan.setImageResource(R.drawable.cat_image)
        binding.tvNamaHewan.text = "Kucing"
        val clickSound: MediaPlayer = MediaPlayer.create(this, R.raw.mouse_click)

        binding.btnBack.setOnClickListener {
            clickSound.start()
            if (!clickSound.isPlaying) {
                clickSound.release()
            }
            binding.imageHewan.setImageResource(R.drawable.cat_image)
            binding.tvNamaHewan.text = "Kucing"
        }
        binding.btnNext.setOnClickListener {
            clickSound.start() //Play clicksound
            if (!clickSound.isPlaying) {
                clickSound.release()
            }
            binding.imageHewan.setImageResource(R.drawable.dog_image)
            binding.tvNamaHewan.text = "Anjing"
        }
        binding.btnPlayVoice.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        when (v.id) {
            R.id.btn_play_voice -> {
                Toast.makeText(this, "Menjalankan Suara!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}