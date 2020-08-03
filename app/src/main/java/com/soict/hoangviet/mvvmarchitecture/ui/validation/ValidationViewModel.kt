package com.soict.hoangviet.mvvmarchitecture.ui.validation

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.soict.hoangviet.baseproject.data.network.api.Repository
import com.soict.hoangviet.baseproject.data.network.response.ObjectResponse
import com.soict.hoangviet.baseproject.data.sharepreference.SharePreference
import com.soict.hoangviet.baseproject.extension.isValidateEmail
import com.soict.hoangviet.baseproject.extension.isValidatePassword
import com.soict.hoangviet.mvvmarchitecture.base.ui.BaseViewModel
import com.soict.hoangviet.mvvmarchitecture.data.network.response.BaseError
import javax.inject.Inject

class ValidationViewModel @Inject constructor(val context: Context) : BaseViewModel() {
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val successfulLogin = MutableLiveData<ObjectResponse<String>>()
    val mLiveDataAwareLifecycle = LiveDataAwareLifecycle<String>()

    fun onLoginClicked() {
        when {
            email.value.toString().isNullOrEmpty() -> {
                successfulLogin.value =
                    ObjectResponse.error(BaseError("Please enter email", 1, isShowToast = true))
            }
            !email.value.toString().isValidateEmail() -> {
                successfulLogin.value =
                    ObjectResponse.error(
                        BaseError(
                            "Please enter valid email",
                            1,
                            isShowToast = true
                        )
                    )
            }
            password.value.toString().isNullOrEmpty() -> {
                successfulLogin.value = ObjectResponse.error(BaseError("Please enter password", 2))
            }
            !password.value.toString().isValidatePassword() -> {
                successfulLogin.value =
                    ObjectResponse.error(BaseError("Please enter valid password", 2))
            }
            else -> {
                successfulLogin.value = ObjectResponse.success("Successful Login")
            }
        }
    }
}