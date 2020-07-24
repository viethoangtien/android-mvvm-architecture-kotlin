package com.soict.hoangviet.mvvmarchitecture.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.soict.hoangviet.mvvmarchitecture.ui.loadmore.LoadMoreViewModel
import com.soict.hoangviet.mvvmarchitecture.ui.main.MainViewModel
import com.soict.hoangviet.mvvmarchitecture.ui.notification.NotificationViewModel
import com.soict.hoangviet.mvvmarchitecture.ui.validation.ValidationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NotificationViewModel::class)
    internal abstract fun bindNotificationViewModel(viewModel: NotificationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ValidationViewModel::class)
    internal abstract fun bindValidationViewModel(viewModel: ValidationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoadMoreViewModel::class)
    internal abstract fun bindLoadMoreViewModel(viewModel: LoadMoreViewModel): ViewModel
}