package com.morfly.cleanarchitecture.core.presentationlayer.databinding;


import android.support.v7.widget.RecyclerView;

import com.morfly.cleanarchitecture.core.presentationlayer.adapter.BaseBindingItem;
import com.morfly.cleanarchitecture.core.presentationlayer.adapter.BindingAdapter;

import java.util.Collection;

public class DataBindingAdaptersDefault implements DataBindingAdapters {

    @SuppressWarnings("unchecked")
    @Override
    public <I extends BaseBindingItem> void setItems(RecyclerView recyclerView, Collection<I> items) {
        BindingAdapter<I> adapter = (BindingAdapter<I>) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setItems(items);
        }
    }

}
