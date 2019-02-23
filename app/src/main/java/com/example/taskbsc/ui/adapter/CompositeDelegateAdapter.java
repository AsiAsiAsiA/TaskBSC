package com.example.taskbsc.ui.adapter;

import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CompositeDelegateAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int FIRST_VIEW_TYPE = 0;

    private final SparseArray<IDelegateAdapter> typeToAdapterMap;
    @NonNull
    private final List<T> data = new ArrayList<>();

    private CompositeDelegateAdapter(@NonNull SparseArray<IDelegateAdapter> typeToAdapterMap) {
        this.typeToAdapterMap = typeToAdapterMap;
    }

    //Возвращает ViewType по position
    @Override
    public int getItemViewType(int position) {
        //Достаем все IDelegateAdapter из SparseArray
        for (int i = FIRST_VIEW_TYPE; i < typeToAdapterMap.size(); i++) {
            final IDelegateAdapter delegate = typeToAdapterMap.valueAt(i);

            //noinspection unchecked
            //Если ViewType соответствует данным, то возвращаем его
            if (delegate.isForViewType(data, position)) {
                return typeToAdapterMap.keyAt(i);
            }
        }
        throw new NullPointerException(
                "Can not get viewType for position " + position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Создание ViewHolder по viewType
        return typeToAdapterMap.get(viewType).onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final IDelegateAdapter delegateAdapter = typeToAdapterMap.get(getItemViewType(position));
        if (delegateAdapter != null) {
            //noinspection unchecked
            delegateAdapter.onBindViewHolder(holder, data, position);
        } else {
            throw new NullPointerException("can not find adapter for position " + position);
        }
        //TODO: проброс ошибок
    }

    @Override
    public final int getItemCount() {
        return data.size();
    }

    public void updateAccounts(@NonNull List<T> data) {
        //TODO: diffutil
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    //Pattern Builder
    public static class Builder<T> {

        private final SparseArray<IDelegateAdapter> typeToAdapterMap;
        private int count;

        public Builder() {
            typeToAdapterMap = new SparseArray<>();
        }

        public Builder<T> add(@NonNull IDelegateAdapter<?, ? extends T> delegateAdapter) {
            //Кладем в SparseArray класс реализующий IDelegateAdapter
            typeToAdapterMap.put(count++, delegateAdapter);
            return this;
        }

        public CompositeDelegateAdapter<T> build() {
            if (count == 0) throw new IllegalArgumentException("Register at least one adapter");
            return new CompositeDelegateAdapter<>(typeToAdapterMap);
        }
    }
}
