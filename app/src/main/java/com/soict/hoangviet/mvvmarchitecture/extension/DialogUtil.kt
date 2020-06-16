package com.soict.hoangviet.mvvmarchitecture.extension

import android.app.Activity
import com.soict.hoangviet.mvvmarchitecture.custom.view.NetworkDialog

fun Activity.showNetworkDialog(func: NetworkDialog.() -> Unit) =
    NetworkDialog(this).apply { func() }.create().show()