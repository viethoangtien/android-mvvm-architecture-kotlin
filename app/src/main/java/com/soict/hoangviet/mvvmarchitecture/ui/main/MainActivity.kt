package com.soict.hoangviet.mvvmarchitecture.ui.main

import com.beetech.productmanagement.di.annotation.LayoutId
import com.soict.hoangviet.baseproject.extension.onAvoidDoubleClick
import com.soict.hoangviet.baseproject.extension.toast
import com.soict.hoangviet.mvvmarchitecture.R
import com.soict.hoangviet.mvvmarchitecture.base.ui.BaseActivity
import com.soict.hoangviet.mvvmarchitecture.databinding.ActivityMainBinding
import com.soict.hoangviet.mvvmarchitecture.extension.injectViewModel
import com.soict.hoangviet.mvvmarchitecture.extension.showNetworkDialog
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
//        btn.onAvoidDoubleClick {
//            showLocationAlertDialog {
//                title = getString(R.string.alert_title)
//                message = getString(R.string.alert_message)
//                positiveTitle = getString(R.string.alert_positive_title)
//                negativeTitle = getString(R.string.alert_negative_title)
//                setOnPositiveListener {
//                    toast("Positive")
//                }
//                setOnNegativeListener {
//                    toast("Negative")
//                }
//            }
//        }
    }
}
