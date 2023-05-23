package com.himawan.pembelajarantunanetra.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.himawan.pembelajarantunanetra.R
import com.himawan.pembelajarantunanetra.databinding.FragmentQuizBinding

class QuizFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!

    //Pertanyaan dan jawaban
    private var mCurrentPosition: Int = 0
    private var randomA: Int = 0
    private var randomB: Int = 0
    private var poin: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)

        randomA = (1..15).random()
        randomB = (1..15).random()
        val trueAnswer: Int = randomA + randomB
        binding.questionNumber.text = "No 1"
        binding.questionField.text = "$randomA + $randomB = ?"
        binding.aOption.text = "$trueAnswer"
        binding.bOption.text = "${generateNegatifAnswer(trueAnswer)}"
        binding.cOption.text = "${generatePositifAnswer(trueAnswer)}"

        binding.btnNext.setOnClickListener(this)

        return binding.root
    }

    @Suppress("DEPRECATION")
    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        mCurrentPosition++
        when (mCurrentPosition) {
            1 -> {
                if (binding.aOption.isChecked) {
                    poin++
                }
                binding.radioGroup.clearCheck()
                binding.questionNumber.text = "No 2"
                randomA = (1..15).random()
                randomB = (1..15).random()
                val trueAnswer: Int = randomA + randomB
                binding.questionField.text = "$randomA + $randomB = ?"
                binding.aOption.text = "${generateNegatifAnswer(trueAnswer)}"
                binding.bOption.text = "$trueAnswer"
                binding.cOption.text = "${generatePositifAnswer(trueAnswer)}"
            }
            2 -> {
                if (binding.bOption.isChecked) {
                    poin++
                }
                binding.radioGroup.clearCheck()
                binding.questionNumber.text = "No 3"
                randomA = (1..15).random()
                randomB = (1..15).random()
                val trueAnswer: Int = randomA + randomB
                binding.questionField.text = "$randomA + $randomB = ?"
                binding.aOption.text = "${generateNegatifAnswer(trueAnswer)}"
                binding.bOption.text = "${generatePositifAnswer(trueAnswer)}"
                binding.cOption.text = "$trueAnswer"
            }
            3 -> {
                if (binding.cOption.isChecked) {
                    poin++
                }
                binding.radioGroup.clearCheck()
                binding.questionNumber.text = "No 4"
                randomA = (15..49).random()
                randomB = (11..49).random()
                val trueAnswer: Int = randomA + randomB
                binding.questionField.text = "$randomA + $randomB = ?"
                binding.aOption.text = "${generateNegatifAnswer(trueAnswer)}"
                binding.bOption.text = "$trueAnswer"
                binding.cOption.text = "${generatePositifAnswer(trueAnswer)}"
            }
            4 -> {
                if (binding.bOption.isChecked) {
                    poin++
                }
                binding.radioGroup.clearCheck()
                binding.questionNumber.text = "No 5"
                randomA = (15..49).random()
                randomB = (11..49).random()
                val trueAnswer: Int = randomA + randomB
                binding.questionField.text = "$randomA + $randomB = ?"
                binding.aOption.text = "$trueAnswer"
                binding.bOption.text = "${generateNegatifAnswer(trueAnswer)}"
                binding.cOption.text = "${generatePositifAnswer(trueAnswer)}"
            }
            5 -> {
                if (binding.aOption.isChecked) {
                    poin++
                }
                binding.radioGroup.clearCheck()
                binding.questionNumber.text = "No 6"
                randomA = (1..99).random()
                randomB = (1..99).random()
                val trueAnswer: Int = randomA + randomB
                binding.questionField.text = "$randomA + $randomB = ?"
                binding.aOption.text = "${generateNegatifAnswer(trueAnswer)}"
                binding.bOption.text = "$trueAnswer"
                binding.cOption.text = "${generatePositifAnswer(trueAnswer)}"
            }
            6 -> {
                if (binding.bOption.isChecked) {
                    poin++
                }
                binding.radioGroup.clearCheck()
                binding.questionNumber.text = "No 7"
                randomA = (1..15).random()
                randomB = (1..15).random()
                if (randomA >= randomB) {
                    val trueAnswer: Int = randomA - randomB
                    binding.questionField.text = "$randomA - $randomB = ?"
                    binding.aOption.text = "${generateNegatifAnswer(trueAnswer)}"
                    binding.bOption.text = "$trueAnswer"
                    binding.cOption.text = "${generatePositifAnswer(trueAnswer)}"
                } else {
                    val trueAnswer: Int = randomB - randomA
                    binding.questionField.text = "$randomB - $randomA = ?"
                    binding.aOption.text = "${generateNegatifAnswer(trueAnswer)}"
                    binding.bOption.text = "$trueAnswer"
                    binding.cOption.text = "${generatePositifAnswer(trueAnswer)}"
                }
            }
            7 -> {
                if (binding.bOption.isChecked) {
                    poin++
                }
                binding.radioGroup.clearCheck()
                binding.questionNumber.text = "No 8"
                randomA = (1..30).random()
                randomB = (1..30).random()
                if (randomA >= randomB) {
                    val trueAnswer: Int = randomA - randomB
                    binding.questionField.text = "$randomA - $randomB = ?"
                    binding.aOption.text = "${generateNegatifAnswer(trueAnswer)}"
                    binding.bOption.text = "${generatePositifAnswer(trueAnswer)}"
                    binding.cOption.text = "$trueAnswer"
                } else {
                    val trueAnswer: Int = randomB - randomA
                    binding.questionField.text = "$randomB - $randomA = ?"
                    binding.aOption.text = "${generateNegatifAnswer(trueAnswer)}"
                    binding.bOption.text = "${generatePositifAnswer(trueAnswer)}"
                    binding.cOption.text = "$trueAnswer"
                }
            }
            8 -> {
                if (binding.cOption.isChecked) {
                    poin++
                }
                binding.radioGroup.clearCheck()
                binding.questionNumber.text = "No 9"
                randomA = (20..50).random()
                randomB = (20..50).random()
                if (randomA >= randomB) {
                    val trueAnswer: Int = randomA - randomB
                    binding.questionField.text = "$randomA - $randomB = ?"
                    binding.aOption.text = "${generatePositifAnswer(trueAnswer)}"
                    binding.bOption.text = "${generateNegatifAnswer(trueAnswer)}"
                    binding.cOption.text = "$trueAnswer"
                } else {
                    val trueAnswer: Int = randomB - randomA
                    binding.questionField.text = "$randomB - $randomA = ?"
                    binding.aOption.text = "${generatePositifAnswer(trueAnswer)}"
                    binding.bOption.text = "${generateNegatifAnswer(trueAnswer)}"
                    binding.cOption.text = "$trueAnswer"
                }
            }
            9 -> {
                if (binding.cOption.isChecked) {
                    poin++
                }
                binding.radioGroup.clearCheck()
                binding.questionNumber.text = "No 10"
                randomA = (20..70).random()
                randomB = (50..70).random()
                val trueAnswer: Int = randomA + randomB
                binding.questionField.text = "$randomA + $randomB = ?"
                binding.aOption.text = "$trueAnswer"
                binding.bOption.text = "${generateNegatifAnswer(trueAnswer)}"
                binding.cOption.text = "${generatePositifAnswer(trueAnswer)}"
            }
            else -> {
                if (binding.aOption.isChecked) {
                    poin++
                }

                val stringPoin: String = poin.toString()
                val bundle = Bundle()
                bundle.putString("poin", stringPoin)
                val fragment = FinishFragment()
                fragment.arguments = bundle
                fragmentManager?.beginTransaction()?.replace(R.id.frame_ly, fragment)?.commit()
                onStop()
            }
        }
    }

    private fun generateNegatifAnswer(answer: Int): Int {
        val randomNumber = (1..4).random()
        return answer - randomNumber
    }

    private fun generatePositifAnswer(answer: Int): Int {
        val randomNumber = (1..4).random()
        return answer + randomNumber
    }

}