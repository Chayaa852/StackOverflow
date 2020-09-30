package com.example.stackoverflow.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class QuestionResponse(
    @SerializedName("items")
    val items: List<QuestionResponseItem>
)

@Parcelize
data class QuestionResponseItem(
    @SerializedName("tags")
    val tags: ArrayList<String>,
    @SerializedName("owner")
    val owner: OwnerResponseItem,
    @SerializedName("is_answered")
    val isAnswered: Boolean,
    @SerializedName("view_count")
    val viewCount: Long,
    @SerializedName("closed_date")
    val closedDate: Long,
    @SerializedName("answer_count")
    val answerCount: Long,
    @SerializedName("score")
    val score: Long,
    @SerializedName("last_activity_date")
    val lastActivityDate: Long,
    @SerializedName("creation_date")
    val creationDate: Long,
    @SerializedName("last_edit_date")
    val lastEditDate: Long,
    @SerializedName("question_id")
    val questionId: Long,
    @SerializedName("link")
    val link: String,
    @SerializedName("closed_reason")
    val closedReason: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String,
    @SerializedName("answers")
    val answers: ArrayList<AnswerItem> = ArrayList()
) : Parcelable