package com.himawan.pembelajarantunanetra.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.himawan.pembelajarantunanetra.R
import com.himawan.pembelajarantunanetra.databinding.FragmentBodyPartQuizBinding

class BodyPartQuizFragment : Fragment() {

    private var _binding: FragmentBodyPartQuizBinding? = null
    private val binding get() = _binding!!

    //Pertanyaan dan jawaban
    private var mCurrentPosition: Int = 0
    private var poin: Int = 0

    @Suppress("DEPRECATION")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBodyPartQuizBinding.inflate(inflater, container, false)

        //1st views
        binding.questionNumber.text = "No 1"
        binding.questionField.text = "Organ tubuh manusia yang berfungsi untuk melihat adalah ?"
        binding.aOption.text = "Mata"
        binding.bOption.text = "Hidung"
        binding.cOption.text = "Kaki"
        binding.dOption.text = "Mulut"

        binding.btnNext.setOnClickListener {
            mCurrentPosition++
            Log.d("Posisi", "$mCurrentPosition")
            Log.d("Poin", "$poin")
            when (mCurrentPosition) {
                1 -> {
                    if (binding.aOption.isChecked) {
                        poin++
                    }
                    binding.radioGroup.clearCheck()
                    binding.questionNumber.text = "No 2"
                    binding.questionField.text =
                        "Organ tubuh manusia yang berfungsi untuk menghirup udara adalah ?"
                    binding.aOption.text = "Mata"
                    binding.bOption.text = "Telinga"
                    binding.cOption.text = "Hidung"
                    binding.dOption.text = "Tangan"
                }

                2 -> {
                    if (binding.cOption.isChecked) {
                        poin++
                    }
                    binding.radioGroup.clearCheck()
                    binding.questionNumber.text = "No 3"
                    binding.questionField.text =
                        "Kita dapat berjalan menggunakan organ manusia yang disebut ?"
                    binding.aOption.text = "Tangan"
                    binding.bOption.text = "Kaki"
                    binding.cOption.text = "Mulut"
                    binding.dOption.text = "Hidung"
                }

                3 -> {
                    if (binding.bOption.isChecked) {
                        poin++
                    }
                    binding.radioGroup.clearCheck()
                    binding.questionNumber.text = "No 4"
                    binding.questionField.text =
                        "Kita dapat mendengarkan suara orang lain menggunakan organ tubuh manusia yang disebut ?"
                    binding.aOption.text = "Telinga"
                    binding.bOption.text = "Mata"
                    binding.cOption.text = "Kepala"
                    binding.dOption.text = "Kaki"
                }

                4 -> {
                    if (binding.aOption.isChecked) {
                        poin++
                    }
                    binding.radioGroup.clearCheck()
                    binding.questionNumber.text = "No 5"
                    binding.questionField.text =
                        "Ketika kita sedang makan atau minum, organ tubuh manusia apakah yang digunakan pada saat itu ?"
                    binding.aOption.text = "Mulut"
                    binding.bOption.text = "Kaki"
                    binding.cOption.text = "Telinga"
                    binding.dOption.text = "Mata"
                }

                5 -> {
                    if (binding.aOption.isChecked) {
                        poin++
                    }
                    binding.radioGroup.clearCheck()
                    binding.questionNumber.text = "No 6"
                    binding.questionField.text =
                        "Kita dapat memegang benda atau orang lain menggunakan organ tubuh manusia yang bernama?"
                    binding.aOption.text = "Tangan"
                    binding.bOption.text = "Kaki"
                    binding.cOption.text = "Telinga"
                    binding.dOption.text = "Mata"
                    binding.btnNext.text = "Finish"
                }
                else -> {
                    if (binding.aOption.isChecked) {
                        poin++
                    }
                    Log.d("Poin", "$poin")
                    val stringPoin: String = poin.toString()
                    val bundle = Bundle()
                    bundle.putString("poin", stringPoin)
                    val fragment = FinishBodyPartFragment()
                    fragment.arguments = bundle
                    fragmentManager?.beginTransaction()?.replace(R.id.frame_ly, fragment)?.commit()
                }
            }
//            requireActivity().finish()
//            startActivity(Intent(context, QuizBodyPartActivity::class.java))
        }
        return binding.root
    }
}