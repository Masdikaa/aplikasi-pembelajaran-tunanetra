package com.himawan.pembelajarantunanetra.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.himawan.pembelajarantunanetra.databinding.FragmentQuizBinding

private var _binding: FragmentQuizBinding? = null
private val binding get() = _binding!!

class QuizFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

}