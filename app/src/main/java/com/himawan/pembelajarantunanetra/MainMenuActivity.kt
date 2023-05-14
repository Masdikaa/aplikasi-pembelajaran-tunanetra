package com.himawan.pembelajarantunanetra

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.himawan.pembelajarantunanetra.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) //Always LightTheme
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardHewan.setOnClickListener(this)
        binding.cardMatematika.setOnClickListener(this)
        binding.cardOrgan.setOnClickListener(this)
        binding.cardBangunRuang.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.card_hewan -> {
                Toast.makeText(this, "Menu Hewan", Toast.LENGTH_SHORT).show()
            }
            R.id.card_matematika -> {
                Toast.makeText(this, "Menu Operasi Matematika", Toast.LENGTH_SHORT).show()
            }
            R.id.card_organ -> {
                Toast.makeText(this, "Menu Organ Dalam", Toast.LENGTH_SHORT).show()
            }
            R.id.card_bangun_ruang -> {
                Toast.makeText(this, "Menu Bangun Ruang", Toast.LENGTH_SHORT).show()
            }
        }
    }
}