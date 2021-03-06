package com.example.taskbsc.ui.adapter.base;

import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public interface IDelegateAdapter<VH extends RecyclerView.ViewHolder, T> {
    @NonNull
    RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    void onBindViewHolder(@NonNull VH holder, @NonNull List<T> items, int position);

    boolean isForViewType(@NonNull List<?> items, int position);
}
