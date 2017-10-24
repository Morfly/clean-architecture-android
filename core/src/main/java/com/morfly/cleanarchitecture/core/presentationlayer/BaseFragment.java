package com.morfly.cleanarchitecture.core.presentationlayer;


import android.app.ProgressDialog;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.morfly.cleanarchitecture.core.presentationlayer.util.UiUtils;

import javax.inject.Inject;

public abstract class BaseFragment<P extends BasePresenter, B extends ViewDataBinding> extends Fragment implements BaseView {

    @Inject
    protected P presenter;
    protected B binding;

    @LayoutRes
    protected abstract int getLayoutId();

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.inject();
    }

    @SuppressWarnings("unchecked")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = DataBindingUtil.inflate(inflater, this.getLayoutId(), container, false);
        this.presenter.attachView(this);
        this.onCreateView(savedInstanceState);
        return this.binding.getRoot();
    }

    public abstract void onCreateView(Bundle savedInstanceState);

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.onViewAttached(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

    @Override
    public void setViewModel(int viewModelBindingResId, Object viewModel) {
        binding.setVariable(viewModelBindingResId, viewModel);
    }

    public abstract void inject();

    @Override
    public void showProgress() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).showProgress();
        }
    }

    @Override
    public void hideProgress() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).hideProgress();
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(int resId, Object... args) {
        Resources res = getResources();
        if (res != null) {
            String message = String.format(res.getString(resId), args);
            showMessage(message);
        }
    }

    @Override
    public void showError(Throwable throwable) {
        // TODO implement error handler
        showMessage(throwable.getMessage());
    }

    @Override
    public void hideSoftKeyboard() {
        UiUtils.hideSoftKeyboard(this.getActivity());
    }

    @Override
    public void performBackAction() {
        getActivity().onBackPressed();
    }

}
