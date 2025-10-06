package de.msjones.quizapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import de.msjones.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : ComponentActivity() {
    private lateinit var binding: ActivityQuizQuestionsBinding

    private var userName:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        userName = intent.getStringExtra(Constants.USER_NAME)

        val questionList = Constants.getQuestions()
        Log.i("Fragen", "${questionList.size}")
    }
}