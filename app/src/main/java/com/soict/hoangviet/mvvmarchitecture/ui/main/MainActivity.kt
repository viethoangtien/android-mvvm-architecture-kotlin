package com.soict.hoangviet.mvvmarchitecture.ui.main

import android.app.Dialog
import com.beetech.productmanagement.di.annotation.LayoutId
import com.soict.hoangviet.baseproject.extension.onAvoidDoubleClick
import com.soict.hoangviet.baseproject.extension.toast
import com.soict.hoangviet.mvvmarchitecture.R
import com.soict.hoangviet.mvvmarchitecture.base.ui.BaseActivity
import com.soict.hoangviet.mvvmarchitecture.databinding.ActivityMainBinding
import com.soict.hoangviet.mvvmarchitecture.extension.injectViewModel
import com.soict.hoangviet.mvvmarchitecture.extension.showNetworkDialog
import com.soict.hoangviet.mvvmarchitecture.ui.validation.ValidationFragment
import kotlinx.android.synthetic.main.activity_main.*

@LayoutId(R.layout.activity_main)
class MainActivity : BaseActivity<ActivityMainBinding>() {
    private lateinit var mMainViewModel: MainViewModel

    override fun getFragmentContainerId(): Int {
        return R.id.fl_container
    }

    override fun initViewModel() {
        mMainViewModel = injectViewModel(viewModelFactory)
    }

    override fun initView() {
//        viewController.addFragment(ValidationFragment::class.java, null)
    }

    override fun initData() {

    }

    override fun initListener() {
        btn.onAvoidDoubleClick {
            showNetworkDialog {
                isCancelable = true
                isBackgroundTransparent = false
                setOnCloseClickListener {
                    toast("close")
                }
                setOnCancelListener {
                    toast("cancel")
                }
            }
        }
    }
}
