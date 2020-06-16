package com.soict.hoangviet.mvvmarchitecture.base.view.alert

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.soict.hoangviet.mvvmarchitecture.R

abstract class BaseDialog(val context: Context) {
    abstract val dialogView: Int
    protected lateinit var dialog: Dialog
    open var isCancelable: Boolean = true
    open var isBackgroundTransparent: Boolean = false
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

    open fun setOnCancelListener(func: () -> Unit) {
        onCancelListener = func
    }

    open fun initListener() {

    }

}