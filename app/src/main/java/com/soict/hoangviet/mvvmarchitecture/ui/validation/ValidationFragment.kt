package com.soict.hoangviet.mvvmarchitecture.ui.validation

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.soict.hoangviet.baseproject.extension.toast
import com.soict.hoangviet.mvvmarchitecture.R
import com.soict.hoangviet.mvvmarchitecture.base.ui.BaseFragment
import com.soict.hoangviet.mvvmarchitecture.databinding.FragmentValidationBinding
import com.soict.hoangviet.mvvmarchitecture.extension.addTextChangeListener
import kotlinx.android.synthetic.main.fragment_validation.*

class ValidationFragment : BaseFragment<FragmentValidationBinding>() {
    private lateinit var validationViewModel: ValidationViewModel

    override fun getLayoutId(): Int {
        return R.layout.fragment_validation
    }

    override fun backFromAddFragment() {

    }

    override fun backPressed(): Boolean {
        return true
    }

    override fun initView() {

    }

    override fun initViewModel() {
        validationViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(ValidationViewModel::class.java)
        binding.validationViewModel = validationViewModel
    }

    override fun initData() {

    }

    override fun initListener() {
        validationViewModel.successfulLogin.observe(this, Observer {
            handleObjectResponse(it, false)
        })
        Pair(til_email, edt_email).addTextChangeListener()
        Pair(til_password, edt_password).addTextChangeListener()
    }

    override fun <U : Any?> getObjectResponse(data: U) {
        toast(data as String)
    }

    override fun getError(error: String?, code: Int) {
        when (code) {
            1 -> {
                til_email.requestFocus()
                til_email.error = error
            }
            2 -> {
                til_password.requestFocus()
                til_password.error = error
            }
        }
    }
}