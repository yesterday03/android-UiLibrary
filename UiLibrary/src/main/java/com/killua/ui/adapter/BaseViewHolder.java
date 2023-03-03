package com.killua.ui.adapter;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private T t;

    public BaseViewHolder(T t) {
        super(t.getRoot());
        this.t = t;
    }

    public T getViewDataBinding() {
        return t;
    }
}
