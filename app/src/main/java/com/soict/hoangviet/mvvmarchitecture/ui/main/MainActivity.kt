package com.soict.hoangviet.mvvmarchitecture.ui.main

import com.beetech.productmanagement.di.annotation.LayoutId
import com.soict.hoangviet.mvvmarchitecture.R
import com.soict.hoangviet.mvvmarchitecture.base.ui.BaseActivity
import com.soict.hoangviet.mvvmarchitecture.databinding.ActivityMainBinding
import com.soict.hoangviet.mvvmarchitecture.extension.injectViewModel
import com.soict.hoangviet.mvvmarchitecture.ui.validation.ValidationFragment

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
        viewController.addFragment(ValidationFragment::class.java, null)
    }

    override fun initData() {

    }

    override fun initListener() {
    }
}
