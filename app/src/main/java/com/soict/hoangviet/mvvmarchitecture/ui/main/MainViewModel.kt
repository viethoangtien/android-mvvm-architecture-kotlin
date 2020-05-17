package com.soict.hoangviet.mvvmarchitecture.ui.main

import android.content.Context
import com.soict.hoangviet.baseproject.data.network.api.Repository
import com.soict.hoangviet.baseproject.data.sharepreference.SharePreference
import com.soict.hoangviet.mvvmarchitecture.ui.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    repository: Repository,
    sharePreference: SharePreference,
    val context: Context
) : BaseViewModel(repository = repository, sharePreference = sharePreference) {

}