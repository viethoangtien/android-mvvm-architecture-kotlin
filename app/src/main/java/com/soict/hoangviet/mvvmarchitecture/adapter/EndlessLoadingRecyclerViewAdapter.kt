package com.beetech.tienichmuasam.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.soict.hoangviet.mvvmarchitecture.R

abstract class EndlessLoadingRecyclerViewAdapter<T : ViewDataBinding>(
    context: Context,
    enableSelectedMode: Boolean
) :
    RecyclerViewAdapter<T>(context, enableSelectedMode) {

    private var loadingMoreListener: OnLoadingMoreListener? = null
    private var disableLoadMore = false
    protected var isLoading = false

    fun setLoadingMoreListener(loadingMoreListener: OnLoadingMoreListener?) {
        this.loadingMoreListener = loadingMoreListener
        enableLoadingMore(loadingMoreListener != null)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                when (newState) {
                    RecyclerView.SCROLL_STATE_IDLE -> {
                        var firstVisibleItemPosition = 0
                        var lastVisibleItemPosition = 0

                        if (disableLoadMore || isLoading) {
                            return
                        }
                        val layoutManager = recyclerView.layoutManager
                        if (layoutManager is LinearLayoutManager) {
                            firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
                            lastVisibleItemPosition =
                                layoutManager.findLastCompletelyVisibleItemPosition()
                        } else if (layoutManager is GridLayoutManager) {
                            firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                            lastVisibleItemPosition =
                                layoutManager.findLastCompletelyVisibleItemPosition()
                        }
                        if (firstVisibleItemPosition > 0 && lastVisibleItemPosition == itemCount - 1) {
                            isLoading = true
                            if (loadingMoreListener != null) {
                                loadingMoreListener!!.onLoadMore()
                            }
                        }
                    }
                    else -> {
                    }
                }
            }
        })
    }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading = isLoading
    }

    fun enableLoadingMore(enable: Boolean) {
        this.disableLoadMore = !enable
    }

    fun showLoadingItem(isScroll: Boolean) {
        addModel(null, VIEW_TYPE_LOADING, isScroll)
    }

    fun hideLoadingItem() {
        if (isLoading) {
            removeModel(itemCount - 1)
            isLoading = false
        }
    }

    override fun solvedOnCreateViewHolder(
        binding: T,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val result: RecyclerView.ViewHolder
        when (viewType) {
            VIEW_TYPE_LOADING -> {
                result = LoadingViewHolder(binding.root)
            }
            else -> {
                result = initNormalViewHolder(binding)!!
            }
        }
        return result
    }

    override fun solvedOnBindViewHolder(
        viewHolder: RecyclerView.ViewHolder,
        viewType: Int,
        position: Int
    ) {
        when (viewType) {
            VIEW_TYPE_LOADING -> {
//                bindLoadingViewHolder(viewHolder as LoadingViewHolder, position)
            }

            else -> {
                bindNormalViewHolder(viewHolder as NormalViewHolder<*, Any>, position)
            }
        }
    }

    interface OnLoadingMoreListener {
        fun onLoadMore()
    }

    class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    companion object {
        const val VIEW_TYPE_LOADING = -1
    }
}
