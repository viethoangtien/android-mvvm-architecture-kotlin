package com.soict.hoangviet.mvvmarchitecture.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.soict.hoangviet.mvvmarchitecture.R
import com.soict.hoangviet.mvvmarchitecture.module.GlideApp

class BindingAdapter {
    companion object {
        @BindingAdapter("android:src")
        @JvmStatic
        fun ImageView.setImageViewResource(
            url: String?
        ) {
            GlideApp.with(this.context)
                .load(url)
                .error(R.drawable.img_image_default)
                .placeholder(R.drawable.img_image_default)
                .into(this)
        }
    }
}