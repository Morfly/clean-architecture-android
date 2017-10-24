package com.morfly.cleanarchitecture.core.presentationlayer.adapter;


import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collection;

/**
 * Base adapter with dataBinding for {@link RecyclerView}. May be inherited by custom adapter or
 * used as simple adapter
 *
 * @param <I> item type extending from {@link BaseBindingItem}
 */
public class BindingAdapter<I extends BaseBindingItem> extends RecyclerView.Adapter<BindingHolder> implements View.OnClickListener {

    private static final int ITEM_MODEL = -110;
    private final WeakOnListChangedCallback onListChangedCallback;
    private ObservableList<I> items;
    private LayoutInflater inflater;
    private OnItemClickListener<I> onItemClickListener;

    public BindingAdapter() {
        this.onListChangedCallback = new WeakOnListChangedCallback<>(this);
    }

    public BindingAdapter(@Nullable Collection<I> items) {
        this();
        setItems(items);
    }

    public ObservableList<I> getItems() {
        return items;
    }

    public void setItems(@Nullable Collection<I> items) {
        if (this.items == items) {
            return;
        }

        if (this.items != null) {
            this.items.removeOnListChangedCallback(onListChangedCallback);
            notifyItemRangeRemoved(0, this.items.size());
        }

        if (items instanceof ObservableList) {
            this.items = (ObservableList<I>) items;
            notifyItemRangeInserted(0, this.items.size());
            this.items.addOnListChangedCallback(onListChangedCallback);
        } else if (items != null) {
            this.items = new ObservableArrayList<>();
            this.items.addOnListChangedCallback(onListChangedCallback);
            this.items.addAll(items);
        } else {
            this.items = null;
        }
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        if (items != null) {
            items.removeOnListChangedCallback(onListChangedCallback);
        }
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup viewGroup, int layoutId) {
        if (inflater == null) {
            inflater = LayoutInflater.from(viewGroup.getContext());
        }

        ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutId, viewGroup, false);
        return new BindingHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(BindingHolder viewHolder, int position) {
        final I item = items.get(position);
        viewHolder.binding.setVariable(item.getViewModelBindingId(), item.getViewModel());
        viewHolder.binding.getRoot().setTag(ITEM_MODEL, item);
        viewHolder.binding.getRoot().setOnClickListener(this);
        viewHolder.binding.executePendingBindings();
    }

    /**
     * Returns item layout id (see {@link BaseBindingItem})
     *
     * @return item layout id
     */
    @Override
    public int getItemViewType(int position) {
        return items.get(position).getLayoutId();
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }


    @SuppressWarnings("unchecked")
    @Override
    public void onClick(View v) {
        if (onItemClickListener != null) {
            I item = (I) v.getTag(ITEM_MODEL);
            onItemClickListener.onClick(item);
        }
    }


    public void setOnItemClickListener(OnItemClickListener<I> clickListener) {
        this.onItemClickListener = clickListener;
    }

    public interface OnItemClickListener<I extends BaseBindingItem> {
        void onClick(I item);
    }

}
