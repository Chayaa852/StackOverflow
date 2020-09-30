package com.example.stackoverflow.ui.fragment.answer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.stackoverflow.R
import com.example.stackoverflow.adapter.AnswerRecyclerViewAdapter
import com.example.stackoverflow.databinding.FragmentAnswerBinding
import com.example.stackoverflow.model.QuestionResponseItem

class AnswerFragment : Fragment() {

    private lateinit var fragmentAnswerBinding: FragmentAnswerBinding
    private lateinit var answerViewModel: AnswerViewModel
    private lateinit var questionResponseItem: QuestionResponseItem
    private lateinit var answerRecyclerViewAdapter: AnswerRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentAnswerBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_answer, container, false)
        arguments?.getParcelable<QuestionResponseItem>(PARAM_QUESTION_RESPONSE_ITEM)?.let {
            questionResponseItem = it
            answerViewModel = ViewModelProvider(
                this,
                AnswerViewModelFactory(questionResponseItem)
            ).get(AnswerViewModel::class.java)
            fragmentAnswerBinding.answerViewModel = answerViewModel
            fragmentAnswerBinding.lifecycleOwner = this
        }
        return fragmentAnswerBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        answerRecyclerViewAdapter = AnswerRecyclerViewAdapter()
        fragmentAnswerBinding.rvAnswers.adapter = answerRecyclerViewAdapter
        answerRecyclerViewAdapter.setData(questionResponseItem.answers)
        fragmentAnswerBinding.rvAnswers.isNestedScrollingEnabled = false
    }

    companion object {
        const val PARAM_QUESTION_RESPONSE_ITEM = "questionResponseItem"
        fun newInstance(questionResponseItem: QuestionResponseItem): AnswerFragment {
            return AnswerFragment().apply {
                val bundle = Bundle()
                bundle.putParcelable(PARAM_QUESTION_RESPONSE_ITEM, questionResponseItem)
                this.arguments = bundle
            }
        }
    }
}