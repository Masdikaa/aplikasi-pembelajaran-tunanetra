package com.himawan.pembelajarantunanetra

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.himawan.pembelajarantunanetra.databinding.ActivityQuizBinding
import com.himawan.pembelajarantunanetra.fragment.QuizFragment

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        window.statusBarColor = ContextCompat.getColor(this, R.color.secondary_variant_1) //Set StatusBar Color
        setContentView(binding.root)

        // Inisiasi Menu Fragment
        supportFragmentManager.beginTransaction().replace(R.id.frame_ly, QuizFragment()).commit()

    }
}