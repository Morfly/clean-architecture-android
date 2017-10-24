package com.morfly.cleanarchitecture.core.presentationlayer.databinding;


import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
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
     * Sets image from url into the {@link ImageView}
     *
     * @param onlyScaleDown the image will only be resized if it's bigger than <code>resizeWidth</code> x <code>resizeHeight</code> pixels
     */
    @BindingAdapter(value = {"srcUrl", "srcUri", "srcFile", "srcResId", "placeholder", "error", "cache",
            "centerCrop", "centerInside", "resizeWidth", "resizeHeight", "onlyScaleDown",
            "circle", "transformation", "transformations"}, requireAll = false)
    void loadImage(ImageView view,
                   String srcUrl, Uri srcUri, File srcFile, Integer srcResId,
                   Drawable placeholder, Drawable error,
                   Boolean cache,
                   boolean centerCrop, boolean centerInside, Integer resizeWidth, Integer resizeHeight, boolean onlyScaleDown,
                   boolean circle, Transformation transformation, List<Transformation> transformations);

    /**
     * Sets items to {@link RecyclerView} {@link com.morfly.cleanarchitecture.core.presentationlayer.adapter.BindingAdapter}
     *
     * @param items list of items to display
     * @param <I>   item type
     */
    @BindingAdapter("bind:items")
    <I extends BaseBindingItem> void setItems(RecyclerView recyclerView, Collection<I> items);

}
