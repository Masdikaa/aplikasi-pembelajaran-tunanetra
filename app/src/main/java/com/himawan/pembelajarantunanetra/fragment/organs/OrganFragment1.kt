package com.himawan.pembelajarantunanetra.fragment.organs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.himawan.pembelajarantunanetra.databinding.FragmentOrgan1Binding

private var _binding: FragmentOrgan1Binding? = null
private val binding get() = _binding!!

class OrganFragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrgan1Binding.inflate(inflater, container, false)
        return binding.root
    }
}