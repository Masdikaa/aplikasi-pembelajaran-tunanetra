package com.himawan.pembelajarantunanetra.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.himawan.pembelajarantunanetra.R
import com.himawan.pembelajarantunanetra.activity.MainMenuActivity
import com.himawan.pembelajarantunanetra.databinding.FragmentFinishBodyPartBinding

class FinishBodyPartFragment : Fragment() {

    private var _binding: FragmentFinishBodyPartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFinishBodyPartBinding.inflate(inflater, container, false)

        val args = this.arguments
        val poin = args?.get("poin")
        binding.tvTruePoin.text = poin.toString()

        val stringPoin: String = poin.toString()
        val falsePoin: Int = 6 - stringPoin.toInt()
        binding.tvFalsePoin.text = falsePoin.toString()

        binding.btnMenu.setOnClickListener {
            val intent = Intent(context, MainMenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        binding.btnPlayAgain.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frame_ly, BodyPartQuizFragment())
            transaction?.commit()
        }

        return binding.root
    }

}