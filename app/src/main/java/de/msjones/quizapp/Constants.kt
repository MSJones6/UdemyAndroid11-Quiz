package de.msjones.quizapp

object Constants {
    const val USER_NAME: String = "user_name";

    fun getQuestions(): List<Question> {
        val questionList = ArrayList<Question>()

        val question1 = Question(1,
            "Zu welchem Land gehört diese Flagge",
            R.drawable.ic_flag_of_argentina,
            "Argentinien",
            "Armenien",
            "Australien",
            "Honduras",
            1)

        questionList.add(question1)

        val question2 = Question(2,
            "Zu welchem Land gehört diese Flagge",
            R.drawable.ic_flag_of_germany,
            "Dänemark",
            "Dschibuti",
            "Deutschland",
            "Dominikanische Republik",
            3)

        questionList.add(question2)

        return questionList
    }
}