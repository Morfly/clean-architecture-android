package com.morfly.cleanarchitecture.core.presentationlayer.databinding;


import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;

import com.morfly.cleanarchitecture.core.presentationlayer.adapter.BaseBindingItem;
import com.morfly.cleanarchitecture.core.presentationlayer.adapter.BindingAdapter;
import com.morfly.cleanarchitecture.core.presentationlayer.util.CircleTransformation;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;

import java.io.File;
import java.util.Collection;
import java.util.List;

public class DataBindingAdaptersDefault implements DataBindingAdapters {

    @SuppressWarnings("ConstantConditions")
    @Override
    public void loadImage(ImageView view,
                          String srcUrl, Uri srcUri, File srcFile, Integer srcResId,
                          Drawable placeholder, Drawable error,
                          Boolean cache,
                          boolean centerCrop, boolean centerInside, Integer resizeWidth, Integer resizeHeight, boolean onlyScaleDown,
                          boolean circle, Transformation transformation, List<Transformation> transformations) {
        RequestCreator builder = null;
        Picasso picasso = Picasso.with(view.getContext());
        if ((srcUrl != null && !srcUrl.isEmpty()) || srcUri != null || srcFile != null || srcResId != null) {
            if (srcUrl != null && !srcUrl.isEmpty())
                builder = picasso.load(srcUrl);
            else if (srcUri != null)
                builder = picasso.load(srcUri);
            else if (srcFile != null)
                builder = picasso.load(srcFile);
            else if (srcResId != null)
                builder = picasso.load(srcResId);

            loadImage(view, builder, placeholder, error, cache, centerCrop, centerInside, resizeWidth, resizeHeight, onlyScaleDown, circle, transformation, transformations);
        } else if (placeholder != null) {
            view.setImageDrawable(placeholder);
        } else view.setImageResource(android.R.color.transparent);
    }

    private void loadImage(ImageView view, RequestCreator builder, Drawable placeholder, Drawable error,
                           Boolean cache,
                           boolean centerCrop, boolean centerInside, Integer resizeWidth, Integer resizeHeight, boolean onlyScaleDown,
                           boolean circle, Transformation transformation, List<Transformation> transformations) {

        if (placeholder != null) builder.placeholder(placeholder);
        if (error != null) builder.error(error);

        if (circle) builder.transform(new CircleTransformation());
        if (transformation != null) builder.transform(transformation);
        if (transformations != null) builder.transform(transformations);

        if (onlyScaleDown) builder.onlyScaleDown();

        if (resizeWidth != null && resizeHeight != null) {
            builder.resize(resizeWidth, resizeHeight);
        }
        if (centerCrop || centerInside) {
            if (resizeWidth == null || resizeHeight == null) builder.fit();

            if (centerCrop) builder.centerCrop();
            else builder.centerInside();

        }
        if (cache != null) {
            if (!cache) {
                builder.memoryPolicy(MemoryPolicy.NO_CACHE);
                builder.networkPolicy(NetworkPolicy.NO_CACHE);
            }
        }
        builder.into(view);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <I extends BaseBindingItem> void setItems(RecyclerView recyclerView, Collection<I> items) {
        BindingAdapter<I> adapter = (BindingAdapter<I>) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setItems(items);
        }
    }

}
