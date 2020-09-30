package com.example.stackoverflow.ui.fragment.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stackoverflow.model.QuestionResponse
import com.example.stackoverflow.model.QuestionResponseItem
import com.example.stackoverflow.network.RetrofitSingleton
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel : ViewModel() {

    private val _questionsMutableLiveData: MutableLiveData<List<QuestionResponseItem>> =
        MutableLiveData()
    val questionsMutableLiveData: MutableLiveData<List<QuestionResponseItem>> =
        _questionsMutableLiveData

    private val _error: MutableLiveData<Throwable> = MutableLiveData()
    val error: MutableLiveData<Throwable> = _error

    val isLoadingMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()

    val questionMutableLiveData: MutableLiveData<QuestionResponseItem> = MutableLiveData()

    var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    fun fetchQuestions() {
        isLoadingMutableLiveData.postValue(true)
        mCompositeDisposable.add(
            RetrofitSingleton.requestInterface.getAllQuestions()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ response -> handleResponse(response) }, { t -> handleError(t) })
        )
    }

    private fun handleResponse(questions: QuestionResponse) {
        isLoadingMutableLiveData.postValue(false)
        _questionsMutableLiveData.postValue(questions.items)
    }

    private fun handleError(error: Throwable) {
        isLoadingMutableLiveData.postValue(false)
        _error.postValue(error)
    }

}