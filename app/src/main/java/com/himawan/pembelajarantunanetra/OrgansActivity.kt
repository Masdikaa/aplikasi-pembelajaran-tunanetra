package com.himawan.pembelajarantunanetra

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.himawan.pembelajarantunanetra.databinding.ActivityOrgansBinding

class OrgansActivity : AppCompatActivity() {
    //DataBinding
    private lateinit var binding: ActivityOrgansBinding

    //Variable organ
    private lateinit var listNamaOrgan: Array<String>
    private lateinit var listImageOrgan: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrgansBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataInitialize()
        var i = 0

        //Initiate 1st slide
        binding.tvNamaOrgan.text = listNamaOrgan[i]
        binding.imageOrgan.setImageResource(listImageOrgan[i])


        binding.btnNext.setOnClickListener {
            i++
            if (i > 5) {
                i = 0
            } else if (i < 0) {
                i = 5
            }
            Log.d("Index", i.toString())
            binding.tvNamaOrgan.text = listNamaOrgan[i]
            binding.imageOrgan.setImageResource(listImageOrgan[i])
        }

        binding.btnBack.setOnClickListener {
            i--
            if (i > 5) {
                i = 0
            } else if (i < 0) {
                i = 5
            }
            Log.d("Index", i.toString())
            binding.tvNamaOrgan.text = listNamaOrgan[i]
            binding.imageOrgan.setImageResource(listImageOrgan[i])
        }

    }

    private fun dataInitialize() {
        listNamaOrgan = arrayOf(
            getString(R.string.organ1),
            getString(R.string.organ2),
            getString(R.string.organ3),
            getString(R.string.organ4),
            getString(R.string.organ5),
            getString(R.string.organ6),
        )

        listImageOrgan = arrayOf(
            R.drawable.image_eye2,
            R.drawable.image_ear_3,
            R.drawable.image_lip,
            R.drawable.image_nose,
            R.drawable.image_hand,
            R.drawable.image_angkle
        )
    }
}
