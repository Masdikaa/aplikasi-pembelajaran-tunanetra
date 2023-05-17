package com.himawan.pembelajarantunanetra

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.himawan.pembelajarantunanetra.databinding.ActivityHewanBinding

class HewanActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHewanBinding
    //private lateinit var listHewan: ArrayList<DataHewan>

    private lateinit var listNamaHewan: Array<String>
    private lateinit var listImageHewan: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor =
            ContextCompat.getColor(this, R.color.white) //Set StatusBar Color
        binding = ActivityHewanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataInitialize()
        var i = 0

        //Initialize Variable
        binding.imageHewan.setImageResource(listImageHewan[5])
        binding.tvNamaHewan.text = listNamaHewan[5]
        val clickSound: MediaPlayer = MediaPlayer.create(this, R.raw.mouse_click)


        binding.btnNext.setOnClickListener {
            i++
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
            if (i > 5) {
                i = 0
            } else if (i < 0) {
                i = 5
            }
            Log.d("Index", i.toString())
            binding.imageHewan.setImageResource(listImageHewan[i])
            binding.tvNamaHewan.text = listNamaHewan[i]
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

    private fun dataInitialize() {
        listNamaHewan = arrayOf(
            "Kucing",
            "Anjing",
            "Sapi",
            "Domba",
            "Kuda",
            "Ayam"
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