package com.himawan.pembelajarantunanetra.database

object Constants {
    fun getQuestion(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val que1 =
            Question(1, "1 + 3 = ?", generateNegatifAnswer(4), 4, generateNegatifPositif(4), 4)
        val que2 =
            Question(1, "12 + 3 = ?", 15, generateNegatifPositif(15), generateNegatifAnswer(15), 15)
        val que3 =
            Question(
                1,
                "165 + 9 = ?",
                generateNegatifPositif(174),
                generateNegatifPositif(174),
                174,
                174
            )

        questionList.add(que1)
        questionList.add(que2)
        questionList.add(que3)
        return questionList
    }

    fun generateNegatifAnswer(answer: Int): Int {
        val randomNumber = (1..4).random()
        return answer - randomNumber
    }

    fun generateNegatifPositif(answer: Int): Int {
        val randomNumber = (1..4).random()
        return answer + randomNumber
    }
}