package com.soict.hoangviet.mvvmarchitecture.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.beetech.tienichmuasam.base.adapter.EndlessLoadingRecyclerViewAdapter
import com.soict.hoangviet.mvvmarchitecture.R
import com.soict.hoangviet.mvvmarchitecture.data.network.response.DataItemNotification
import com.soict.hoangviet.mvvmarchitecture.databinding.ItemNotificationBinding

class NotificationAdapter(context: Context, enableSelectedMode: Boolean) :
    EndlessLoadingRecyclerViewAdapter<ItemNotificationBinding>(context, enableSelectedMode) {
    override val itemLayoutRes: Int
        get() = R.layout.item_notification

    override fun initNormalViewHolder(binding: ItemNotificationBinding): RecyclerView.ViewHolder? {
        return NotificationViewHolder(binding)
    }

    override fun bindNormalViewHolder(holder: NormalViewHolder<*, Any>, position: Int) {
        holder.bind(getItem(position, DataItemNotification::class.java)!!)
    }

    class NotificationViewHolder(binding: ItemNotificationBinding) :
        NormalViewHolder<ItemNotificationBinding, DataItemNotification>(binding) {
        override fun bind(data: DataItemNotification) {
            binding.dataItemNotification = data
        }
    }
}