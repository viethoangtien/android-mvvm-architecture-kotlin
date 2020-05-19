package com.soict.hoangviet.mvvmarchitecture.ui.main

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.soict.hoangviet.mvvmarchitecture.R
import com.soict.hoangviet.mvvmarchitecture.data.network.response.TestResponse
import com.soict.hoangviet.mvvmarchitecture.databinding.ActivityMainBinding
import com.soict.hoangviet.mvvmarchitecture.ui.base.BaseActivity

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
        mMainViewModel.bannerLiveData.observe(this, Observer {
            handleListResponse(it)
        })
    }

    override fun getListResponse(data: MutableList<*>?) {
        val item = data?.get(0) as TestResponse
        binding.testResponse = item
    }

    private fun fetchBanner() {
        mMainViewModel.fetchBanner()
    }

    override fun initData() {
        fetchBanner()
    }

    override fun initListener() {
    }
}
