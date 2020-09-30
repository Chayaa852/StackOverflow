package com.example.stackoverflow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.stackoverflow.R
import com.example.stackoverflow.databinding.AnswersRecyclerViewItemLayoutBinding
import com.example.stackoverflow.model.AnswerItem
import com.example.stackoverflow.ui.fragment.answer.AnswerItemViewModel

class AnswerRecyclerViewAdapter :
    RecyclerView.Adapter<AnswerRecyclerViewAdapter.MyViewHolder>() {

    private val answers: MutableList<AnswerItem> = ArrayList()

    inner class MyViewHolder(private val answersRecyclerViewItemLayoutBinding: AnswersRecyclerViewItemLayoutBinding) :
        RecyclerView.ViewHolder(answersRecyclerViewItemLayoutBinding.root) {
        fun bindItemView(answerItemViewModel: AnswerItemViewModel) {
            answersRecyclerViewItemLayoutBinding.answerItemViewModel =
                answerItemViewModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val answersRecyclerViewItemLayoutBinding: AnswersRecyclerViewItemLayoutBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.answers_recycler_view_item_layout,
                parent,
                false
            )
        return MyViewHolder(answersRecyclerViewItemLayoutBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItemView(AnswerItemViewModel(answers[position]))
    }

    override fun getItemCount() = answers.size

    fun setData(answers: List<AnswerItem>) {
        this.answers.clear()
        this.answers.addAll(answers)
        notifyDataSetChanged()
    }

}