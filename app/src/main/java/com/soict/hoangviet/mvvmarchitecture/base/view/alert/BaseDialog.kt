package com.soict.hoangviet.mvvmarchitecture.base.view.alert

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.soict.hoangviet.mvvmarchitecture.R

abstract class
BaseDialog(val context: Context) {
    abstract val dialogView: Int
    lateinit var dialog: Dialog
    var isCancelable: Boolean = true
    var isBackgroundTransparent: Boolean = false
    private var onCancelListener: (() -> Unit)? = null

    open fun create(): Dialog {
        dialog = Dialog(context)
        dialog.apply {
            setContentView(dialogView)
            setCancelable(isCancelable)
            setCanceledOnTouchOutside(isCancelable)
            if (isBackgroundTransparent) {
                window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            } else {
                window?.setBackgroundDrawableResource(R.drawable.bg_dialog)
            }
        }
        dialog.setOnCancelListener {
            onCancelListener?.invoke()
        }
        initListener()
        dialog.show()
        return dialog
    }

    fun setOnCancelListener(func: () -> Unit) {
        onCancelListener = func
    }

    open fun initListener() {

    }

}