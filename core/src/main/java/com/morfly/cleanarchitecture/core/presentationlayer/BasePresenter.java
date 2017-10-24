package com.morfly.cleanarchitecture.core.presentationlayer;


import android.os.Bundle;
import android.support.annotation.Nullable;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public abstract class BasePresenter<V extends BaseView, VM extends ViewModel> {

    private CompositeDisposable subscriptions;
    protected volatile V view;
    private VM viewModel;

    /**
     * Applies view model to the view
     */
    private void applyViewModel() {
        if (view != null) {
            view.setViewModel(view.getViewModelBindingId(), this.viewModel);
        }
    }

    public VM getViewModel() {
        return viewModel;
    }

    public void setViewModel(VM viewModel) {
        this.viewModel = viewModel;
        applyViewModel();
    }

    public void attachView(V view) {
        this.view = view;
        this.subscriptions = new CompositeDisposable();
        applyViewModel();
    }

    public void detachView() {
        view = null;
        if (subscriptions != null && !subscriptions.isDisposed()) {
            subscriptions.dispose();
        }
    }

    public void onViewAttached(@Nullable Bundle savedInstanceState) {

    }

    public void subscribe(Disposable disposable) {
        this.subscriptions.add(disposable);
    }


    // If method is protected - rxJava doesn't want to handle errors. wtf???
    public void onError(Throwable throwable) {
        if (view != null) {
            view.showError(throwable);
        }
    }

}
