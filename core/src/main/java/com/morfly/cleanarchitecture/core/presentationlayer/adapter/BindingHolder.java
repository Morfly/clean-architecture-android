package com.morfly.cleanarchitecture.core.presentationlayer.adapter;


import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * ViewHolder with dataBinding for {@link RecyclerView.Adapter}
 */
public class BindingHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {

    /**
     * Item view dataBinding
     */
    public final B binding;

    public BindingHolder(B binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
