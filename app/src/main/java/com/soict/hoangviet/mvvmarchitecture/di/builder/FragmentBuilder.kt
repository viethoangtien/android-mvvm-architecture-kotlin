package com.soict.hoangviet.mvvmarchitecture.di.builder

import com.soict.hoangviet.mvvmarchitecture.ui.notification.NotificationFragment
import com.soict.hoangviet.mvvmarchitecture.ui.validation.ValidationFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {
    @ContributesAndroidInjector()
    abstract fun bindNotificationFragment(): NotificationFragment

    @ContributesAndroidInjector()
    abstract fun bindValidationFragment(): ValidationFragment
}