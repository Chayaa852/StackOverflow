package com.example.stackoverflow.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OwnerResponseItem(
    @SerializedName("reputation")
    val reputation: Long,
    @SerializedName("user_id")
    val userId: Long,
    @SerializedName("user_type")
    val userType: String,
    @SerializedName("accept_rate")
    val acceptRate: Long,
    @SerializedName("profile_image")
    val profileImage: String,
    @SerializedName("display_name")
    val displayName: String,
    @SerializedName("link")
    val link: String
) : Parcelable