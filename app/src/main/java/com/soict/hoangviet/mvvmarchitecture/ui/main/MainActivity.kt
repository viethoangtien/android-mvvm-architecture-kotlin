package com.soict.hoangviet.mvvmarchitecture.ui.main

import com.soict.hoangviet.mvvmarchitecture.R
import com.soict.hoangviet.mvvmarchitecture.base.ui.BaseActivity
import com.soict.hoangviet.mvvmarchitecture.databinding.ActivityMainBinding
import com.soict.hoangviet.mvvmarchitecture.extension.injectViewModel
import com.soict.hoangviet.mvvmarchitecture.ui.notification.NotificationFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private lateinit var mMainViewModel: MainViewModel
    override fun getLayoutId() = R.layout.activity_main

    override fun getFragmentContainerId(): Int {
        return R.id.fl_container
    }

    override fun initViewModel() {
        mMainViewModel = injectViewModel(viewModelFactory)
    }

    override fun initView() {
        viewController.addFragment(NotificationFragment::class.java, null)
    }

    override fun initData() {

    }

    override fun initListener() {
    }
}
