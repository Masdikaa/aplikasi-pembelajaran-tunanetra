package com.himawan.pembelajarantunanetra

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.himawan.pembelajarantunanetra.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardHewan.setOnClickListener {
            Toast.makeText(this, "Hewan", Toast.LENGTH_SHORT).show()
        }

        binding.cardOrgan.setOnClickListener {
            Toast.makeText(this, "Organ Dalam", Toast.LENGTH_SHORT).show()
        }

        binding.cardMatematika.setOnClickListener {
            Toast.makeText(this, "Matematika", Toast.LENGTH_SHORT).show()
        }

        binding.cardBangunruang.setOnClickListener {
            Toast.makeText(this, "Bangun Ruang", Toast.LENGTH_SHORT).show()
        }

    }
}