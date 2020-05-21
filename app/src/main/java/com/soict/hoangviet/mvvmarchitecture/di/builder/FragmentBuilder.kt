package com.soict.hoangviet.baseproject.di.builder

import com.soict.hoangviet.mvvmarchitecture.ui.main.MainActivity
import com.soict.hoangviet.mvvmarchitecture.ui.notification.NotificationFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {
    @ContributesAndroidInjector()
    abstract fun bindNotificationFragment(): NotificationFragment
}