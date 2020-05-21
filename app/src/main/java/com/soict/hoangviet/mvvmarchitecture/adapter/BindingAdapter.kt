package com.soict.hoangviet.mvvmarchitecture.adapter

import android.os.Build
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.soict.hoangviet.mvvmarchitecture.R
import com.soict.hoangviet.mvvmarchitecture.module.GlideApp

class BindingAdapter {
    companion object {
        @BindingAdapter("android:src")
        @JvmStatic
        fun ImageView.bindImageView(
            url: String?
        ) {
            GlideApp.with(this.context)
                .load(url)
                .error(R.drawable.img_image_default)
                .placeholder(R.drawable.img_image_default)
                .into(this)
        }

        @BindingAdapter("notification")
        @JvmStatic
        fun TextView.bindNotificationTitle(
            content: String?
        ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                text = (Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT))
            } else {
                text = (Html.fromHtml(content));
            }
        }
    }
}