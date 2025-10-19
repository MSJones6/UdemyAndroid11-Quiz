package de.msjones.quizapp

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import de.msjones.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : ComponentActivity(), View.OnClickListener {
    private lateinit var binding: ActivityQuizQuestionsBinding

    private var userName: String? = null
    private var currentPosition = 1
    private var questionList: List<Question>? = null
    private var selectedOption = 0
    private var correctAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        userName = intent.getStringExtra(Constants.USER_NAME)

        setQuestion()

        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)
    }

    private fun setQuestion() {
        defaultOptionView()

        questionList = Constants.getQuestions()
        var question = questionList!![currentPosition - 1]

        binding.progressBar.progress = currentPosition
        binding.tvProgress.text = "$currentPosition/" + binding.progressBar.max

        binding.tvQuestion.text = question!!.question
        binding.ivFlag.setImageResource(question.image)
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour
        binding.btnSubmit.text = "BESTÄTIGEN"
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOptionOne)
        options.add(1, binding.tvOptionTwo)
        options.add(2, binding.tvOptionThree)
        options.add(3, binding.tvOptionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border
            )
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvOptionOne -> {
                selectedOptionView(binding.tvOptionOne, 1)
            }
            R.id.tvOptionTwo -> {
                selectedOptionView(binding.tvOptionTwo, 2)
            }
            R.id.tvOptionThree -> {
                selectedOptionView(binding.tvOptionThree, 3)
            }
            R.id.tvOptionFour -> {
                selectedOptionView(binding.tvOptionFour, 4)
            }
            R.id.btnSubmit -> {
                if (selectedOption == 0) {
                    ++currentPosition

                    when {
                        currentPosition <= questionList!!.size -> {
                            setQuestion()
                        } else -> {
                        Toast.makeText(this, "Quiz erfolgreich beendet", Toast.LENGTH_LONG).show()
                        }
                    }
                } else {
                    val question = questionList?.get(currentPosition-1)
                    if (question!!.correctAnswer != selectedOption) {
                        answerView(selectedOption, R.drawable.wrong_option_border)
                    } else {
                        ++correctAnswers
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border)

                    if (currentPosition == questionList!!.size) {
                        binding.btnSubmit.text = "BEENDEN"
                    } else {
                        binding.btnSubmit.text = "NÄCHSTE FRAGE"
                    }
                    selectedOption = 0;
                 }

            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                binding.tvOptionOne.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                binding.tvOptionTwo.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                binding.tvOptionThree.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                binding.tvOptionFour.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        selectedOption = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border
        )
    }
}