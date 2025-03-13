package com.learning.talentprogramming.Ch_15_Model

data class StudentModel(
    val sName : String ,
    val sAddress : String,
    val sGender : Char,
    val sDOB : String,
    val sAge : Int,
    val sPhNo : String,
    val sFatherName : String,
    val sGrade : String
)

//Practice Using Model
val studentList = arrayListOf(
    StudentModel(
        "Myo Win",
        "Bangkok",
        'm',
        "11.3.1999",
        26,
        "0649481200",
        "U Tin Hlaing",
        "A")
)
