package com.example.buylist.utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String?, placeHolder: Int = -1) {
    if (url?.isEmpty() == true) return

    if (placeHolder != -1)
        Glide.with(this).load(url).placeholder(placeHolder).into(this)
    else Glide.with(this).load(url).into(this)
}