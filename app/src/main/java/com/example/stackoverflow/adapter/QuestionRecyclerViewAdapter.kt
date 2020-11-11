package com.example.stackoverflow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.stackoverflow.R
import com.example.stackoverflow.databinding.QuestionRecyclerViewItemLayoutBinding
import com.example.stackoverflow.interfaces.OnItemSelectedListener
import com.example.stackoverflow.model.QuestionResponseItem
import com.example.stackoverflow.viewmodels.QuestionResponseItemViewModel

class QuestionRecyclerViewAdapter(private val onItemSelectedListener: OnItemSelectedListener) :
    RecyclerView.Adapter<QuestionRecyclerViewAdapter.MyViewHolder>() {

    private val questions: MutableList<QuestionResponseItem> = ArrayList()

    inner class MyViewHolder(private val questionRecyclerViewItemLayoutBinding: QuestionRecyclerViewItemLayoutBinding) :
        RecyclerView.ViewHolder(questionRecyclerViewItemLayoutBinding.root) {
        fun bindItemView(questionResponseItemViewModel: QuestionResponseItemViewModel) {
            questionRecyclerViewItemLayoutBinding.questionResponseItemViewModel =
                questionResponseItemViewModel
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val questionRecyclerViewItemLayoutBinding: QuestionRecyclerViewItemLayoutBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.question_recycler_view_item_layout,
                parent,
                false
            )
        return MyViewHolder(questionRecyclerViewItemLayoutBinding).listen { pos, _ ->
            onItemSelectedListener.clickAction(questions[pos])
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItemView(QuestionResponseItemViewModel(questions[position]))
    }

    override fun getItemCount() = questions.size

    fun setData(questions: List<QuestionResponseItem>) {
        this.questions.clear()
        this.questions.addAll(questions)
        notifyDataSetChanged()
    }

}