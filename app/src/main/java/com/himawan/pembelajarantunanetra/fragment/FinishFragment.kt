package com.himawan.pembelajarantunanetra.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.himawan.pembelajarantunanetra.activity.MainMenuActivity
import com.himawan.pembelajarantunanetra.R
import com.himawan.pembelajarantunanetra.databinding.FragmentFinishBinding

private var _binding: FragmentFinishBinding? = null
private val binding get() = _binding!!

class FinishFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFinishBinding.inflate(inflater, container, false)

        val args = this.arguments
        val poin = args?.get("poin")
        binding.tvTruePoin.text = poin.toString()

        val stringPoin: String = poin.toString()
        val falsePoin: Int = 9 - stringPoin.toInt()
        binding.tvFalsePoin.text = falsePoin.toString()

        binding.btnMenu.setOnClickListener {
            startActivity(Intent(context, MainMenuActivity::class.java))
            onStop()
        }

        binding.btnPlayAgain.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_ly, QuizFragment())
            transaction?.commit()
        }

        return binding.root
    }
}