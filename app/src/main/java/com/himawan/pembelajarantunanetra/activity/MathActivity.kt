package com.himawan.pembelajarantunanetra.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.himawan.pembelajarantunanetra.R
import com.himawan.pembelajarantunanetra.databinding.ActivityMathBinding

class MathActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMathBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.secondary_variant_1) //Set StatusBar Color
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) //Always LightTheme
        binding = ActivityMathBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
            finish()
        }
    }
}