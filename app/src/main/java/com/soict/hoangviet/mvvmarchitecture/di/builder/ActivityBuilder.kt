package com.soict.hoangviet.mvvmarchitecture.di.builder

import com.soict.hoangviet.mvvmarchitecture.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector()
    abstract fun bindMainActivity(): MainActivity
}