package com.soict.hoangviet.mvvmarchitecture.ui.main

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.soict.hoangviet.mvvmarchitecture.R
import com.soict.hoangviet.mvvmarchitecture.data.network.response.TestResponse
import com.soict.hoangviet.mvvmarchitecture.databinding.ActivityMainBinding
import com.soict.hoangviet.mvvmarchitecture.ui.base.BaseActivity
import com.soict.hoangviet.mvvmarchitecture.ui.notification.NotificationFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private lateinit var mMainViewModel: MainViewModel
    override fun getLayoutId() = R.layout.activity_main

    override fun getFragmentContainerId(): Int {
        return R.id.fl_container
    }

    override fun initViewModel() {
        mMainViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun initView() {
        viewController.addFragment(NotificationFragment::class.java, null)
    }

    override fun initData() {

    }

    override fun initListener() {
    }
}
