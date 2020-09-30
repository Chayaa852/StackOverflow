package com.example.stackoverflow.adapter.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:leftDrawable", "app:isAccepted")
fun isAccepted(
    textView: TextView,
    leftDrawable: Int,
    isAccepted: Boolean = false
) {
    textView.setCompoundDrawablesWithIntrinsicBounds(if (isAccepted) leftDrawable else 0, 0, 0, 0)
}