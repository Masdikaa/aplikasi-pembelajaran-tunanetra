package com.himawan.pembelajarantunanetra.database

object Constants {
    fun getQuestion(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val que1 =
            Question(1, "2 + 3 = ?", generateNegatifAnswer(4), 5, generatePositifAnswer(5), 5)
        val que2 =
            Question(2, "12 + 3 = ?", 15, generatePositifAnswer(15), generateNegatifAnswer(15), 15)
        val que3 =
            Question(
                3,
                "165 + 40 = ?",
                generateNegatifAnswer(195),
                generatePositifAnswer(195),
                195,
                195
            )
        val que4 = Question(
            4, "291 + 107 = ?", generatePositifAnswer(398), 398,
            generateNegatifAnswer(398), 398
        )

        val que5 = Question(
            5, "481 - 249 = ?", 232, generateNegatifAnswer(232),
            generateNegatifAnswer(232), 232
        )

        val que6 = Question(
            6, "31 - 18 = ?", generatePositifAnswer(13), generateNegatifAnswer(13), 13, 13
        )

        val que7 = Question(
            7, "367 - 142 = ?", 225, generatePositifAnswer(225),
            generateNegatifAnswer(225), 225
        )
        val que8 = Question(
            8, "543 - 322 = ?", generatePositifAnswer(221), 221, generateNegatifAnswer(221), 221
        )

        questionList.add(que1)
        questionList.add(que2)
        questionList.add(que3)
        questionList.add(que4)
        questionList.add(que5)
        questionList.add(que6)
        questionList.add(que7)
        questionList.add(que8)
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
}