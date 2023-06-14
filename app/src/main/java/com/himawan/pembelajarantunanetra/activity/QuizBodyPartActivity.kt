package com.himawan.pembelajarantunanetra.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.himawan.pembelajarantunanetra.R
import com.himawan.pembelajarantunanetra.databinding.ActivityQuizBodyPartBinding

class QuizBodyPartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBodyPartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBodyPartBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) //Always LightTheme
        window.statusBarColor = ContextCompat.getColor(this, R.color.secondary_variant_1) //Set StatusBar Color
        setContentView(binding.root)


    }
}