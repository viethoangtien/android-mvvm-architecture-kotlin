package com.soict.hoangviet.mvvmarchitecture.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

//    @Binds
//    @IntoMap
//    @ViewModelKey(PostListViewModel::class)
//    internal abstract fun postListViewModel(viewModel: PostListViewModel): ViewModel
}