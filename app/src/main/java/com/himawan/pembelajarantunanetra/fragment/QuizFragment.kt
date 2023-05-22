package com.himawan.pembelajarantunanetra.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.himawan.pembelajarantunanetra.R
import com.himawan.pembelajarantunanetra.database.Constants
import com.himawan.pembelajarantunanetra.database.Question
import com.himawan.pembelajarantunanetra.databinding.FragmentQuizBinding

private var Mbinding: FragmentQuizBinding? = null
private val binding get() = Mbinding!!

class QuizFragment : Fragment(), View.OnClickListener {

    //Pertanyaan dan jawaban
    private lateinit var mQuestionList: ArrayList<Question>
    private var mCurrentPosition: Int = 0

    private var randomA: Int = 0
    private var randomB: Int = 0
    private var poin: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Mbinding = FragmentQuizBinding.inflate(inflater, container, false)

        //ArrayList dari class Question
        mQuestionList = Constants.getQuestion()

        //SetQuestion
        randomA = (1..15).random()
        randomB = (1..15).random()
        val trueAnswer: Int = randomA + randomB
        binding.questionNumber.text = "No 1"
        binding.questionField.text = "${randomA} + ${randomB} = ?"
        binding.aOption.text = "${trueAnswer}"
        binding.bOption.text = "${generateNegatifAnswer(trueAnswer)}"
        binding.cOption.text = "${generatePositifAnswer(trueAnswer)}"

        binding.btnNext.setOnClickListener(this)

        return binding.root
    }

    override fun onClick(v: View?) {
        Log.d("ID", "${binding.radioGroup.checkedRadioButtonId}")
        Toast.makeText(context, "${poin}", Toast.LENGTH_SHORT).show()
        mCurrentPosition++
        when (mCurrentPosition) {
            1 -> {
                if (binding.aOption.isChecked){
                    poin++
                }

                binding.radioGroup.clearCheck()
                binding.questionNumber.text = "No 1"
                randomA = (1..15).random()
                randomB = (1..15).random()
                val trueAnswer: Int = randomA + randomB
                binding.questionField.text = "${randomA} + ${randomB} = ?"
                binding.aOption.text = "${generateNegatifAnswer(trueAnswer)}"
                binding.bOption.text = "${trueAnswer}"
                binding.cOption.text = "${generatePositifAnswer(trueAnswer)}"

            }
            2 -> {
                if (binding.bOption.isChecked) {
                    poin++
                }

                binding.radioGroup.clearCheck()
                binding.questionNumber.text = "No 2"
                randomA = (1..15).random()
                randomB = (1..15).random()
                val trueAnswer: Int = randomA + randomB
                binding.questionField.text = "${randomA} + ${randomB} = ?"
                binding.aOption.text = "${generateNegatifAnswer(trueAnswer)}"
                binding.bOption.text = "${generatePositifAnswer(trueAnswer)}"
                binding.cOption.text = "${trueAnswer}"

            }
            3 -> {
                if (binding.cOption.isChecked) {
                    poin++
                }

                binding.radioGroup.clearCheck()
                binding.questionNumber.text = "No 3"
                randomA = (15..49).random()
                randomB = (11..49).random()
                val trueAnswer: Int = randomA + randomB
                binding.questionField.text = "${randomA} + ${randomB} = ?"
                binding.aOption.text = "${generateNegatifAnswer(trueAnswer)}"
                binding.bOption.text = "${trueAnswer}"
                binding.cOption.text = "${generatePositifAnswer(trueAnswer)}"
            }
            4 -> {
                if (binding.bOption.isChecked) {
                    poin++
                }

                binding.radioGroup.clearCheck()
                binding.questionNumber.text = "No 4"
                randomA = (15..49).random()
                randomB = (11..49).random()
                val trueAnswer: Int = randomA + randomB
                binding.questionField.text = "${randomA} + ${randomB} = ?"
                binding.aOption.text = "${trueAnswer}"
                binding.bOption.text = "${generateNegatifAnswer(trueAnswer)}"
                binding.cOption.text = "${generatePositifAnswer(trueAnswer)}"
            }
            5 -> {
                if (binding.aOption.isChecked) {
                    poin++
                }

                binding.radioGroup.clearCheck()
                binding.questionNumber.text = "No 5"
                randomA = (1..99).random()
                randomB = (1..99).random()
                val trueAnswer: Int = randomA + randomB
                binding.questionField.text = "${randomA} + ${randomB} = ?"
                binding.aOption.text = "${generateNegatifAnswer(trueAnswer)}"
                binding.bOption.text = "${trueAnswer}"
                binding.cOption.text = "${generatePositifAnswer(trueAnswer)}"
            }
            6 -> {
                if (binding.bOption.isChecked) {
                    poin++
                }

                binding.radioGroup.clearCheck()
                binding.questionNumber.text = "No 6"
                randomA = (1..15).random()
                randomB = (1..15).random()
                if (randomA >= randomB) {
                    val trueAnswer: Int = randomA - randomB
                    binding.questionField.text = "${randomA} - ${randomB} = ?"
                    binding.aOption.text = "${generateNegatifAnswer(trueAnswer)}"
                    binding.bOption.text = "${trueAnswer}"
                    binding.cOption.text = "${generatePositifAnswer(trueAnswer)}"
                } else if (randomB >= randomA) {
                    val trueAnswer: Int = randomB - randomA
                    binding.questionField.text = "${randomB} - ${randomA} = ?"
                    binding.aOption.text = "${generateNegatifAnswer(trueAnswer)}"
                    binding.bOption.text = "${trueAnswer}"
                    binding.cOption.text = "${generatePositifAnswer(trueAnswer)}"
                }
            }
            7 -> {
                if (binding.bOption.isChecked) {
                    poin++
                }

                binding.radioGroup.clearCheck()
                binding.questionNumber.text = "No 7"
                randomA = (1..30).random()
                randomB = (1..30).random()
                if (randomA >= randomB) {
                    val trueAnswer: Int = randomA - randomB
                    binding.questionField.text = "${randomA} - ${randomB} = ?"
                    binding.aOption.text = "${generateNegatifAnswer(trueAnswer)}"
                    binding.bOption.text = "${generatePositifAnswer(trueAnswer)}"
                    binding.cOption.text = "${trueAnswer}"
                } else if (randomB >= randomA) {
                    val trueAnswer: Int = randomB - randomA
                    binding.questionField.text = "${randomB} - ${randomA} = ?"
                    binding.aOption.text = "${generateNegatifAnswer(trueAnswer)}"
                    binding.bOption.text = "${generatePositifAnswer(trueAnswer)}"
                    binding.cOption.text = "${trueAnswer}"
                }
            }
            8 -> {
                if (binding.cOption.isChecked) {
                    poin++
                }

                binding.radioGroup.clearCheck()
                binding.questionNumber.text = "No 8"
                randomA = (20..50).random()
                randomB = (20..50).random()
                if (randomA >= randomB) {
                    val trueAnswer: Int = randomA - randomB
                    binding.questionField.text = "${randomA} - ${randomB} = ?"
                    binding.aOption.text = "${generatePositifAnswer(trueAnswer)}"
                    binding.bOption.text = "${generateNegatifAnswer(trueAnswer)}"
                    binding.cOption.text = "${trueAnswer}"
                } else if (randomB >= randomA) {
                    val trueAnswer: Int = randomB - randomA
                    binding.questionField.text = "${randomA} - ${randomB} = ?"
                    binding.aOption.text = "${generatePositifAnswer(trueAnswer)}"
                    binding.bOption.text = "${generateNegatifAnswer(trueAnswer)}"
                    binding.cOption.text = "${trueAnswer}"
                }
            }
            else -> {
                if (binding.cOption.isChecked) {
                    poin++
                }
                val transaction = activity?.supportFragmentManager?.beginTransaction()
                transaction?.replace(R.id.frame_ly, FinishFragment())
                transaction?.commit()
                Log.d("Poin", poin.toString())
            }
        }
    }

    fun opstionCheckedB(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.b_option ->
                    if (checked) {
                        poin++
                        print(poin)
                    }
            }
        }
    }

    fun generateNegatifAnswer(answer: Int): Int {
        val randomNumber = (1..4).random()
        return answer - randomNumber
    }

    fun generatePositifAnswer(answer: Int): Int {
        val randomNumber = (1..4).random()
        return answer + randomNumber
    }

}