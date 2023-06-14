package com.himawan.pembelajarantunanetra.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import com.himawan.pembelajarantunanetra.R
import com.himawan.pembelajarantunanetra.databinding.ActivityQuizBodyPartBinding
import com.himawan.pembelajarantunanetra.fragment.BodyPartQuizFragment

class QuizBodyPartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBodyPartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBodyPartBinding.inflate(layoutInflater)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) //Always LightTheme
        window.statusBarColor =
            ContextCompat.getColor(this, R.color.secondary_variant_1) //Set StatusBar Color
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            window.statusBarColor = ContextCompat.getColor(this, R.color.secondary_variant_1)
            binding.mainLayout.setBackgroundColor(255)
            // Inisiasi Menu Fragment
            supportFragmentManager.beginTransaction().replace(R.id.frame_ly, BodyPartQuizFragment())
                .commit()
            binding.imgStart.visibility = View.INVISIBLE
            binding.namakuis.text = " "
            binding.btnStart.visibility = View.INVISIBLE
        }
    }
}