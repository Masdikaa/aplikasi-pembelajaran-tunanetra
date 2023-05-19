package com.himawan.pembelajarantunanetra

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.himawan.pembelajarantunanetra.databinding.ActivityGeometryBinding

class GeometryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGeometryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGeometryBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}