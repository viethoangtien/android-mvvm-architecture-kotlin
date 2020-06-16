package com.soict.hoangviet.mvvmarchitecture.custom.view

import android.content.Context
import com.soict.hoangviet.baseproject.extension.onAvoidDoubleClick
import com.soict.hoangviet.mvvmarchitecture.R
import com.soict.hoangviet.mvvmarchitecture.base.view.alert.BaseDialog
import kotlinx.android.synthetic.main.layout_dialog_network.*

class NetworkDialog constructor(context: Context) : BaseDialog(context) {
    override val dialogView: Int
        get() = R.layout.layout_dialog_network
    private var onCloseClickListener: (() -> Unit)? = null

    override fun initListener() {
        super.initListener()
        with(dialog.imv_close) {
            onAvoidDoubleClick {
                dialog.dismiss()
                onCloseClickListener?.invoke()
            }
        }
    }

    fun setOnCloseClickListener(func: () -> Unit) {
        onCloseClickListener = func
    }

}