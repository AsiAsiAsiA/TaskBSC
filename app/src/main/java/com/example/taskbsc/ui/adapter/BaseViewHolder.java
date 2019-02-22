package com.example.taskbsc.ui.adapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

class BaseViewHolder extends RecyclerView.ViewHolder {
    private ItemInflateListener listener;

    BaseViewHolder(View parent) {
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