package com.morfly.cleanarchitecture.core.presentationlayer.adapter;


import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;

import com.morfly.cleanarchitecture.core.presentationlayer.ViewModel;


/**
 * Item for {@link RecyclerView} {@link BindingAdapter}
 *
 * @param <VM> item viewModel type
 */
public abstract class BaseBindingItem<VM extends ViewModel> {

    private VM viewModel;

    /**
     * Item layout id
     *
     * @return
     */
    @LayoutRes
    public abstract int getLayoutId();

    /**
     * Item viewModel BR (binding resource)
     *
     * @return
     */
    public abstract int getViewModelBindingId();


    public BaseBindingItem(VM viewModel) {
        this.viewModel = viewModel;
    }


    // ViewModel
    public VM getViewModel() {
        return viewModel;
    }

    public void setViewModel(VM viewModel) {
        this.viewModel = viewModel;
    }


}
