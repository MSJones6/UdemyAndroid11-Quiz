package de.msjones.quizapp

object Constants {
    const val USER_NAME: String = "user_name";
    const val CORRECT_ANSWERS = "correct_answers"
    const val TOTAL_QUESTIONS = "total_questions"

    fun getQuestions(): List<Question> {
        val questionList = ArrayList<Question>()

        val question1 = Question(
            1,
            "Zu welchem Land gehört diese Flagge?",
            R.drawable.ic_flag_of_india,
            "Indien",
            "Kuwait",
            "Australien",
            "Belgien",
            1
        )
        questionList.add(question1)


        val question2 = Question(
            2,
            "Zu welchem Land gehört diese Flagge?",
            R.drawable.ic_flag_of_germany,
            "Belgien",
            "Deutschland",
            "Dänemark",
            "Brasilien",
            2
        )
        questionList.add(question2)

        val question3 = Question(
            3,
            "Zu welchem Land gehört diese Flagge?",
            R.drawable.ic_flag_of_brazil,
            "Australien",
            "Brasilien",
            "Fidschi",
            "Argentinien",
            2
        )
        questionList.add(question3)

        val question4 = Question(
            4,
            "Zu welchem Land gehört diese Flagge?",
            R.drawable.ic_flag_of_denmark,
            "Deutschland",
            "Belgien",
            "Dänemark",
            "Neuseeland",
            3
        )
        questionList.add(question4)

        val question5 = Question(
            5,
            "Zu welchem Land gehört diese Flagge?",
            R.drawable.ic_flag_of_fiji,
            "Fidschi",
            "Australien",
            "Kuwait",
            "Brasilien",
            1
        )
        questionList.add(question5)

        val question6 = Question(
            6,
            "Zu welchem Land gehört diese Flagge?",
            R.drawable.ic_flag_of_australia,
            "Neuseeland",
            "Australien",
            "Fidschi",
            "Dänemark",
            2
        )
        questionList.add(question6)

        val question7 = Question(
            7,
            "Zu welchem Land gehört diese Flagge?",
            R.drawable.ic_flag_of_kuwait,
            "Indien",
            "Argentinien",
            "Kuwait",
            "Belgien",
            3
        )
        questionList.add(question7)

        val question8 = Question(
            8,
            "Zu welchem Land gehört diese Flagge?",
            R.drawable.ic_flag_of_argentina,
            "Brasilien",
            "Argentinien",
            "Deutschland",
            "Neuseeland",
            2
        )
        questionList.add(question8)

        val question9 = Question(
            9,
            "Zu welchem Land gehört diese Flagge?",
            R.drawable.ic_flag_of_belgium,
            "Belgien",
            "Deutschland",
            "Brasilien",
            "Indien",
            1
        )
        questionList.add(question9)

        val question10 = Question(
            10,
            "Zu welchem Land gehört diese Flagge?",
            R.drawable.ic_flag_of_new_zealand,
            "Australien",
            "Fidschi",
            "Neuseeland",
            "Dänemark",
            3
        )
        questionList.add(question10)

        return questionList
    }
}