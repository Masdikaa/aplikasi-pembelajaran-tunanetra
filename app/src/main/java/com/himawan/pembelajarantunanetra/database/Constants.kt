package com.himawan.pembelajarantunanetra.database

object Constants {
    fun getQuestion(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val que1 =
            Question(
                1, generateEzRandomQustion(),
                generateEzRandomQustion(), generateNegatifAnswer(4), 5, generatePositifAnswer(5), 5
            )
        questionList.add(que1)
        return questionList
    }

    fun generateNegatifAnswer(answer: Int): Int {
        val randomNumber = (1..4).random()
        return answer - randomNumber
    }

    fun generatePositifAnswer(answer: Int): Int {
        val randomNumber = (1..4).random()
        return answer + randomNumber
    }

    fun generateEzRandomQustion() {
        var questionB = (1..17).random()
    }

    fun checkBigger(numb1: Int, numb2: Int): Int {
        if (numb1 > numb2) {
            return numb1
        } else if (numb2 > numb1) {
            return numb2
        } else {
            return numb1
        }
    }

}