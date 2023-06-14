package com.himawan.pembelajarantunanetra.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.himawan.pembelajarantunanetra.activity.QuizBodyPartActivity
import com.himawan.pembelajarantunanetra.databinding.FragmentBodyPartQuizBinding

class BodyPartQuizFragment : Fragment() {

    private var _binding: FragmentBodyPartQuizBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBodyPartQuizBinding.inflate(inflater, container, false)

        binding.btnNext.setOnClickListener {
            requireActivity().finish()
            startActivity(Intent(context, QuizBodyPartActivity::class.java))
        }
        return binding.root
    }
}