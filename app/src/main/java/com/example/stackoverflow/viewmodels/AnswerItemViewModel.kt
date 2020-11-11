package com.example.stackoverflow.viewmodels

import androidx.lifecycle.ViewModel
import com.example.stackoverflow.R
import com.example.stackoverflow.model.AnswerItem
import com.example.stackoverflow.utils.toHtml

class AnswerItemViewModel(private val answerItem: AnswerItem) :
    ViewModel() {

    val answerBody: String
        get() = answerItem.body.toHtml()

    val voteCount: String
        get() = answerItem.score.toString()

    val ownerProfileImage: String
        get() = answerItem.owner.profileImage

    val ownerDisplayName: String
        get() = answerItem.owner.displayName

    val ownerReputation: String
        get() = answerItem.owner.reputation.toString()

    val isAccepted: Boolean
        get() = answerItem.isAccepted

    val leftDrawable: Int
        get() = R.drawable.ic_check

}