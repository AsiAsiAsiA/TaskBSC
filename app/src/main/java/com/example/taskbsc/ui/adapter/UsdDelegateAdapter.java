package com.example.taskbsc.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taskbsc.R;
import com.example.taskbsc.domain.Account;

import java.util.List;

import androidx.annotation.NonNull;

public class UsdDelegateAdapter extends
        BaseDelegateAdapter<UsdDelegateAdapter.UsdViewHolder, Account> {

    @Override
    protected void onBindViewHolder(@NonNull View view,
                                    @NonNull Account account,
                                    @NonNull UsdViewHolder viewHolder) {
        viewHolder.tvName.setText(account.getName());
        viewHolder.imageView.setImageResource(R.drawable.usd);
        viewHolder.tvSum.setText(String.valueOf(account.getSum()));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.usd_adapter_item;
    }

    @Override
    protected UsdViewHolder createViewHolder(View parent) {
        return new UsdViewHolder(parent);
    }

    //Проверка подходит ли item для ViewType
    @Override
    public boolean isForViewType(@NonNull List<?> items, int position) {
        return items.get(position) instanceof Account;
    }

    final static class UsdViewHolder extends BaseViewHolder {

        TextView tvName;
        ImageView imageView;
        TextView tvSum;

        private UsdViewHolder(View parent) {
            super(parent);
            tvName = itemView.findViewById(R.id.tv_account_name);
            imageView = itemView.findViewById(R.id.iv_account_image);
            tvSum = itemView.findViewById(R.id.tv_account_sum);
        }
    }
}