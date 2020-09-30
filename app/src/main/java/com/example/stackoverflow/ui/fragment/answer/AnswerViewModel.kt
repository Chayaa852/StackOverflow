package com.example.stackoverflow.ui.fragment.answer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stackoverflow.model.QuestionResponseItem
import com.example.stackoverflow.utils.toHtml

class AnswerViewModelFactory constructor(private val questionResponseItem: QuestionResponseItem) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(AnswerViewModel::class.java)) {
            AnswerViewModel(this.questionResponseItem) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}


class AnswerViewModel(private val questionResponseItem: QuestionResponseItem) : ViewModel() {

    val questionTitle: MutableLiveData<String>
        get() = MutableLiveData(questionResponseItem.title.toHtml())

    val questionBody: MutableLiveData<String>
        get() = MutableLiveData(questionResponseItem.body.toHtml())

}