package com.example.stackoverflow.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AnswerItem(
    @SerializedName("tags")
    val tags: ArrayList<String>,
    @SerializedName("owner")
    val owner: OwnerResponseItem,
    @SerializedName("is_accepted")
    val isAccepted: Boolean,
    @SerializedName("score")
    val score: Long,
    @SerializedName("last_activity_date")
    val lastActivityDate: Long,
    @SerializedName("creation_date")
    val creationDate: Long,
    @SerializedName("last_edit_date")
    val lastEditDate: Long,
    @SerializedName("answer_id")
    val answerId: Long,
    @SerializedName("question_id")
    val questionId: Long,
    @SerializedName("link")
    val link: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
) : Parcelable