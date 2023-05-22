package com.himawan.pembelajarantunanetra.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    private var mSelectedPosition: Int = 0
    private var mCorrectAnswer: Int = 0
    private var mCurrentPosition: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Mbinding = FragmentQuizBinding.inflate(inflater, container, false)

        //ArrayList dari class Question
        mQuestionList = Constants.getQuestion()

        //SetQuestion
        setQuestion()
        binding.btnNext.setOnClickListener(this)

        return binding.root
    }

    private fun setQuestion() {
        val question: Question = mQuestionList[mCurrentPosition - 1]
        binding.questionField.text = question.question
        binding.aOption.text = question.optionOne.toString()
        binding.bOption.text = question.optionTwo.toString()
        binding.cOption.text = question.optionThree.toString()
    }

    private fun setView(question: String, a: Int, b: Int, c: Int) {
        binding.questionField.text = question
        binding.aOption.text = a.toString()
        binding.bOption.text = b.toString()
        binding.cOption.text = c.toString()
    }

    override fun onClick(v: View?) {
        when (mCurrentPosition) {
            0 -> {
                val question: Question = mQuestionList[0]
                setView(
                    question.question,
                    question.optionOne,
                    question.optionTwo,
                    question.optionThree
                )
            }
            1 -> {
                val question: Question = mQuestionList[1]
                setView(
                    question.question,
                    question.optionOne,
                    question.optionTwo,
                    question.optionThree
                )
            }
            2 -> {
                val question: Question = mQuestionList[2]
                setView(
                    question.question,
                    question.optionOne,
                    question.optionTwo,
                    question.optionThree
                )
            }
            else -> {
                val transaction = activity?.supportFragmentManager?.beginTransaction()
                transaction?.replace(R.id.frame_ly, FinishFragment())
                transaction?.commit()
            }
        }
        mCurrentPosition++
    }

}