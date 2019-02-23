package com.example.taskbsc.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseDelegateAdapter<VH extends BaseViewHolder, T> implements IDelegateAdapter<VH, T> {

    abstract protected void onBindViewHolder(
            @NonNull View view, @NonNull T item, @NonNull VH viewHolder);

    @LayoutRes
    abstract protected int getLayoutId();

    abstract protected VH createViewHolder(View parent);

    @NonNull
    @Override
    public final RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        final View inflatedView = LayoutInflater
                .from(parent.getContext())
                .inflate(getLayoutId(), parent, false);
        final VH holder = createViewHolder(inflatedView);

        //Устанавливаем ItemInflateListener для ViewHolder
        holder.setListener((viewType1, view) -> onBindViewHolder(view, (T) viewType1, holder));
        return holder;
    }

    @Override
    public final void onBindViewHolder(
            @NonNull VH holder,
            @NonNull List<T> items,
            int position) {

        holder.bind(items.get(position));
    }
}