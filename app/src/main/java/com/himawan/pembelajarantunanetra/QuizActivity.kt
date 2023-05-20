package com.himawan.pembelajarantunanetra

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.himawan.pembelajarantunanetra.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}