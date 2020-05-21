package com.soict.hoangviet.mvvmarchitecture.ui.notification

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.soict.hoangviet.mvvmarchitecture.R
import com.soict.hoangviet.mvvmarchitecture.adapter.NotificationAdapter
import com.soict.hoangviet.mvvmarchitecture.data.network.response.DataItemNotification
import com.soict.hoangviet.mvvmarchitecture.data.network.response.NotificationResponse
import com.soict.hoangviet.mvvmarchitecture.databinding.FragmentNotificationBinding
import com.soict.hoangviet.mvvmarchitecture.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_notification.*

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    private lateinit var notificationViewModel: NotificationViewModel
    private lateinit var mNotificationAdapter: NotificationAdapter
    override fun getLayoutId(): Int {
        return R.layout.fragment_notification
    }

    override fun backFromAddFragment() {

    }

    override fun backPressed(): Boolean = true

    override fun initViewModel() {
        notificationViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(NotificationViewModel::class.java)
    }

    override fun initView() {
        initNotificationAdapter()
    }

    private fun initNotificationAdapter() {
        mNotificationAdapter = NotificationAdapter(requireContext(), false)
        brv_notification.setAdapter(mNotificationAdapter)
        brv_notification.setListLayoutManager(LinearLayoutManager.VERTICAL)
    }

    override fun initData() {
        notificationViewModel.getNotification(false)
    }

    override fun initListener() {
        notificationViewModel.notificationLiveData.observe(this, Observer {
            handleLoadMoreResponse(it)
        })
    }

    override fun <U : Any?> getObjectResponse(data: U, isRefresh: Boolean, isLoadingMore: Boolean) {
        data as NotificationResponse
        brv_notification.addItem(data.data as MutableList<DataItemNotification>)
    }

}