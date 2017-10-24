package com.morfly.cleanarchitecture.core.presentationlayer.databinding;


import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.morfly.cleanarchitecture.core.presentationlayer.adapter.BaseBindingItem;
import com.squareup.picasso.Transformation;

import java.io.File;
import java.util.Collection;
import java.util.List;

/**
 * DataBinding instance adapters for layouts
 */
public interface DataBindingAdapters {

    /**
     * Sets items to {@link RecyclerView} {@link com.morfly.cleanarchitecture.core.presentationlayer.adapter.BindingAdapter}
     *
     * @param items list of items to display
     * @param <I>   item type
     */
    @BindingAdapter("bind:items")
    <I extends BaseBindingItem> void setItems(RecyclerView recyclerView, Collection<I> items);

}
