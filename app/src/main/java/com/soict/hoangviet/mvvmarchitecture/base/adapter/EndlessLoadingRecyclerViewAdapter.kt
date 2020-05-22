package com.beetech.tienichmuasam.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.soict.hoangviet.baseproject.extension.inflate
import com.soict.hoangviet.mvvmarchitecture.R

abstract class EndlessLoadingRecyclerViewAdapter<T : ViewDataBinding>(
    context: Context,
    enableSelectedMode: Boolean
) :
    RecyclerViewAdapter<T>(context, enableSelectedMode) {

    private var loadingMoreListener: (() -> Unit)? = null
    private var disableLoadMore = false
    protected var isLoading = false

    fun setLoadingMoreListener(loadingMoreListener: () -> Unit) {
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
                            loadingMoreListener?.invoke()
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
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder? {
        return when (viewType) {
            VIEW_TYPE_LOADING -> {
                LoadingViewHolder(parent.inflate(R.layout.layout_load_more))
            }
            else -> {
                super.solvedOnCreateViewHolder(binding, parent, viewType)!!
            }
        }
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
