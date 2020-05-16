package com.soict.hoangviet.mvvmarchitecture.ui.base;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.soict.hoangviet.baseproject.data.network.ApiConstant;
import com.soict.hoangviet.baseproject.data.network.ApiError;
import com.soict.hoangviet.baseproject.data.network.api.NetworkConnectionInterceptor;
import com.soict.hoangviet.mvvmarchitecture.custom.ViewController;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.inject.Inject;
import dagger.android.support.DaggerAppCompatActivity;
import retrofit2.HttpException;

public abstract class BaseActivity<T extends ViewDataBinding> extends DaggerAppCompatActivity {

    protected T binding;

    @Inject
    protected ViewModelProvider.Factory viewModelFactory;
    protected ViewController mViewController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        mViewController = new ViewController(getSupportFragmentManager(), getFragmentContainerId());
        initViewModel();
        initView();
        initData();
        initListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public abstract int getLayoutId();

    public abstract int getFragmentContainerId();

    @Override
    public void onBackPressed() {
        if (mViewController != null && mViewController.getCurrentFragment() != null) {
            if (mViewController.getCurrentFragment().backPressed()) {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }

    public ViewController getViewController() {
        if (mViewController == null) {
            mViewController = new ViewController(getSupportFragmentManager(), getFragmentContainerId());
        }
        return mViewController;
    }

    @Nullable
    public void handleNetworkError(Throwable throwable, boolean isShowDialog) {
        ApiError apiError;

        if (throwable instanceof NetworkConnectionInterceptor.NoConnectivityException) {
            apiError = new ApiError(throwable.getMessage());
        } else if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            try {
                apiError = gsonFromJson(
                        httpException.response().errorBody().toString(),
                        ApiError.class
                );
            } catch (JsonParseException jfe) {
                apiError = new ApiError(ApiConstant.HttpMessage.TIME_OUT);
            } catch (IOException ioe) {
                apiError = new ApiError(ApiConstant.HttpMessage.TIME_OUT);
            } catch (IllegalStateException ile) {
                apiError = new ApiError(ApiConstant.HttpMessage.TIME_OUT);
            } catch (Exception e) {
                apiError = new ApiError(ApiConstant.HttpMessage.TIME_OUT);
            }
        } else if (throwable instanceof ConnectException
                || throwable instanceof SocketTimeoutException
                || throwable instanceof UnknownHostException
                || throwable instanceof IOException) {
            apiError = new ApiError(ApiConstant.HttpMessage.TIME_OUT);
        } else {
            apiError = new ApiError(ApiConstant.HttpMessage.TIME_OUT);
        }
        if (isShowDialog && apiError != null) {
            Toast.makeText(this, apiError.getApiException().getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private <T> T gsonFromJson(String json, Class<T> classOfT) throws Exception {
        try {
            return new Gson().fromJson(json, classOfT);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    protected abstract void initViewModel();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();
}
