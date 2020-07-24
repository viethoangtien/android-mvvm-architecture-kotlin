package com.soict.hoangviet.mvvmarchitecture.ui.loadmore

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.beetech.productmanagement.di.annotation.LayoutId
import com.soict.hoangviet.mvvmarchitecture.R
import com.soict.hoangviet.mvvmarchitecture.adapter.KoujiAdapter
import com.soict.hoangviet.mvvmarchitecture.base.ui.BaseFragment
import com.soict.hoangviet.mvvmarchitecture.data.local.LoadMoreData
import com.soict.hoangviet.mvvmarchitecture.databinding.FragmentEndLoadMoreBinding
import com.soict.hoangviet.mvvmarchitecture.extension.injectViewModel
import kotlinx.android.synthetic.main.fragment_end_load_more.*

@LayoutId(R.layout.fragment_end_load_more)
class LoadMoreFragment : BaseFragment<FragmentEndLoadMoreBinding>() {
    private lateinit var mKoujiAdapter: KoujiAdapter
    private lateinit var loadMoreViewModel: LoadMoreViewModel

    override fun initViewModel() {
        loadMoreViewModel = injectViewModel(viewModelFactory)
    }

    override fun backFromAddFragment() {

    }

    override fun backPressed(): Boolean {
        return true
    }

    override fun initView() {
        initAdapter()
    }

    private fun initAdapter() {
        mKoujiAdapter = KoujiAdapter(requireContext(), false)
        brv_data.setAdapter(mKoujiAdapter)
        brv_data.setListReserveLayoutManager(RecyclerView.VERTICAL)
        brv_data.setOnRefreshListener {
            loadMoreViewModel.getConstruction(isRefresh = true)
        }
        brv_data.setOnLoadingMoreListener {
            brv_data.showLoadingItem()
            loadMoreViewModel.getConstruction(isRefresh = false)
        }
        brv_data.setOnRetryLoadingMoreListener {
            loadMoreViewModel.getConstruction(isRefresh = false)
        }
        brv_data.setEnableRefresh(false)
    }

    override fun initData() {
        getConstruction()
    }

    private fun getConstruction() {
        loadMoreViewModel.getConstruction(isRefresh = false)
    }

    override fun initListener() {
        loadMoreViewModel.constructionLiveData.observe(this, Observer {
            handleListLoadMoreResponse(it)
        })
    }

    override fun getError(error: String?, code: Int) {
        if (mKoujiAdapter.getIsLoading()) {
            mKoujiAdapter.getItem(mKoujiAdapter.itemCount - 1, LoadMoreData::class.java)?.isRetry =
                true
            mKoujiAdapter.notifyItemChanged(mKoujiAdapter.itemCount - 1)
        }
    }

    override fun getListResponse(data: List<*>?, isRefresh: Boolean, isLoadingMore: Boolean) {
        brv_data.enableLoadMore(isLoadingMore)
        when {
            isRefresh -> {
                brv_data.refresh(data as List<Any>?)
            }
            else -> {
                brv_data.addItem(data as ArrayList<Any>)
            }
        }
    }
}