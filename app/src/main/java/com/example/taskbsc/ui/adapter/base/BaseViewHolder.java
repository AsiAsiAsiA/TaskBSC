package com.example.taskbsc.ui.adapter.base;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private ItemInflateListener listener;

    public BaseViewHolder(View parent) {
        super(parent);
    }

    final void setListener(ItemInflateListener listener) {
        this.listener = listener;
    }

    final void bind(Object item) {
        listener.inflated(item, itemView);
    }

    interface ItemInflateListener {
        void inflated(Object viewType, View view);
    }
}