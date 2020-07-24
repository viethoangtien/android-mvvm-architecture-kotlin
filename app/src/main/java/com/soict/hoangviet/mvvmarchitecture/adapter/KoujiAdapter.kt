package com.soict.hoangviet.mvvmarchitecture.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.beetech.tienichmuasam.base.adapter.EndlessLoadingRecyclerViewAdapter
import com.soict.hoangviet.mvvmarchitecture.R
import com.soict.hoangviet.mvvmarchitecture.data.network.response.ConstructionResponse
import com.soict.hoangviet.mvvmarchitecture.data.network.response.DataItemNotification
import com.soict.hoangviet.mvvmarchitecture.databinding.ItemKoujiBinding
import com.soict.hoangviet.mvvmarchitecture.databinding.ItemNotificationBinding

class KoujiAdapter (context: Context, enableSelectedMode: Boolean) :
    EndlessLoadingRecyclerViewAdapter<ItemKoujiBinding>(context, enableSelectedMode) {
    override val itemLayoutRes: Int
        get() = R.layout.item_kouji

    override fun initNormalViewHolder(binding: ItemKoujiBinding): RecyclerView.ViewHolder? {
        return NotificationViewHolder(binding)
    }

    override fun bindNormalViewHolder(holder: NormalViewHolder<*, Any>, position: Int) {
        holder.bind(getItem(position, ConstructionResponse::class.java)!!)
    }

    class NotificationViewHolder(binding: ItemKoujiBinding) :
        NormalViewHolder<ItemKoujiBinding, ConstructionResponse>(binding) {
        override fun bind(data: ConstructionResponse) {
            binding.constructionResponse = data
        }
    }
}