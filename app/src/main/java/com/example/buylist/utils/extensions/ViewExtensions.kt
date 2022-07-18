package com.example.buylist.utils.extensions

import android.view.View

fun View.gone() {
    this.visibility = View.GONE
}

fun View.show(show: Boolean) {
    if (show) visible() else gone()
}

fun View.visible() {
    this.visibility = View.VISIBLE
}