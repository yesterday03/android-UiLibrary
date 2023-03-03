package com.killua.ui.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemPaddingDecoration extends RecyclerView.ItemDecoration {

    private int top;
    private int bottom;
    private int left;
    private int right;

    public ItemPaddingDecoration(int padding) {
        this.top = padding;
        this.bottom = padding;
        this.left = padding;
        this.right = padding;
    }

    public ItemPaddingDecoration(int top, int bottom, int left, int right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.top = top;
        outRect.bottom = bottom;
        outRect.left = left;
        outRect.right = right;
    }
}
