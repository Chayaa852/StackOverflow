package com.example.stackoverflow.ui.fragment.home

import androidx.lifecycle.ViewModel
import com.example.stackoverflow.model.QuestionResponseItem
import com.example.stackoverflow.utils.toHtml

class QuestionResponseItemViewModel(private val questionResponseItem: QuestionResponseItem) :
    ViewModel() {

    val questionTitle: String
        get() = questionResponseItem.title.toHtml()

    val viewCount: String
        get() = questionResponseItem.viewCount.toString()

    val answerCount: String
        get() = questionResponseItem.answerCount.toString()

    val voteCount: String
        get() = questionResponseItem.score.toString()

}