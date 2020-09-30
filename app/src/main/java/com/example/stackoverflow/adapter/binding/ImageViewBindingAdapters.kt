package com.example.stackoverflow.adapter.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:image_url")
fun loadImage(
    imageView: ImageView,
    imageUrl: String
) {
    try {
        Glide
            .with(imageView.context)
            .load(imageUrl)
            .centerCrop()
            .into(imageView)
    } catch (ignored: Exception) {

    }
}