package com.example.taskbsc.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taskbsc.R;
import com.example.taskbsc.domain.Account;
import com.example.taskbsc.domain.Currency;
import com.example.taskbsc.ui.adapter.base.BaseDelegateAdapter;
import com.example.taskbsc.ui.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.NonNull;

public class UsdAdapter extends
        BaseDelegateAdapter<UsdAdapter.UsdViewHolder, Account> {

    //Связываем данные с ViewHolder
    @Override
    protected void onBindViewHolder(@NonNull View view,
                                    @NonNull Account account,
                                    @NonNull UsdViewHolder viewHolder) {
        viewHolder.bind(account);
    }

    //Получаем id необходимого layout
    @Override
    protected int getLayoutId() {
        return R.layout.usd_adapter_item;
    }

    //Создаем необходимый ViewHolder
    @Override
    protected UsdViewHolder createViewHolder(View parent) {
        return new UsdViewHolder(parent);
    }

    //Проверка подходит ли item для ViewType
    @Override
    public boolean isForViewType(@NonNull List<?> items, int position) {
        Object object = items.get(position);
        if (!(items.get(position) instanceof Account)) {
            return false;
        }
        return ((Account) object).getCurrency() == Currency.USD;
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

        void bind(final Account account) {
            tvName.setText(account.getName());
            imageView.setImageResource(R.drawable.usd);
            tvSum.setText(String.valueOf(account.getSum()));
        }
    }
}