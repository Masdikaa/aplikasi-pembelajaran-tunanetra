package com.himawan.pembelajarantunanetra.database

data class Question(
    val id: Int,
    val question: String,
    val optionOne: Int,
    val optionTwo: Int,
    val optionThree: Int,
    val correctAnswer: Int,
)