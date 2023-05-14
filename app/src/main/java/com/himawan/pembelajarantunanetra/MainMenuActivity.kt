package com.himawan.pembelajarantunanetra

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.himawan.pembelajarantunanetra.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor =
            ContextCompat.getColor(this, R.color.secondary) //Set StatusBar Color
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) //Always LightTheme
        binding = ActivityMainMenuBinding.inflate(layoutInflater) // InflateBinding
        setContentView(binding.root)

        binding.cardHewan.setOnClickListener(this)
        binding.cardMatematika.setOnClickListener(this)
        binding.cardOrgan.setOnClickListener(this)
        binding.cardBangunRuang.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.card_hewan -> {
                startActivity(Intent(this, HewanActivity::class.java))
            }
            R.id.card_matematika -> {
                startActivity(Intent(this, MathActivity::class.java))
            }
            R.id.card_organ -> {
                startActivity(Intent(this, OrgansActivity::class.java))
            }
            R.id.card_bangun_ruang -> {
                startActivity(Intent(this, GeometryActivity::class.java))
            }
        }
    }
}