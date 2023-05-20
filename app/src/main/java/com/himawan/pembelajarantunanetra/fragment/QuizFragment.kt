package com.himawan.pembelajarantunanetra.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.himawan.pembelajarantunanetra.databinding.FragmentQuizBinding

private var Mbinding: FragmentQuizBinding? = null
private val binding get() = Mbinding!!

private lateinit var questionListPos: Array<String>
private lateinit var questionListNeg: Array<String>
private lateinit var AnswerList: Array<String>

class QuizFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Mbinding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            Toast.makeText(context, "BTNNN", Toast.LENGTH_SHORT).show()
        }

    }

    private fun dataInitialize() {
        questionListPos = arrayOf(
            "1 + 1 = ?",
            "3 + 4 = ?",
            "9 + 7 = ?",
            "18 + 30 = ?",
            "65 + 17 = ?",
            "34 + 71 = ?",
            "13 + 21 = ?",
            "25 + 7 = ?"
        )
    }

}