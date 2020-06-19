package com.soict.hoangviet.mvvmarchitecture.extension

import android.app.Activity
import com.soict.hoangviet.mvvmarchitecture.base.view.alert.BaseAlertDialog
import com.soict.hoangviet.mvvmarchitecture.custom.view.NetworkDialog

fun Activity.showNetworkDialog(func: NetworkDialog.() -> Unit) =
    NetworkDialog(this).apply { func() }.create().show()

fun Activity.showLocationAlertDialog(func: BaseAlertDialog.() -> Unit) =
    BaseAlertDialog(this).apply { func() }.create().show()