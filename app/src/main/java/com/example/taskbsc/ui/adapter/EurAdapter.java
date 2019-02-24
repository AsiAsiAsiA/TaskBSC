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

public class EurAdapter extends BaseDelegateAdapter<EurAdapter.EurViewHolder, Account> {

    @Override
    protected void onBindViewHolder(@NonNull View view, @NonNull Account account, @NonNull EurViewHolder viewHolder) {
        viewHolder.bind(account);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.eur_adapter_item;
    }

    @Override
    protected EurViewHolder createViewHolder(View parent) {
        return new EurViewHolder(parent);
    }

    @Override
    public boolean isForViewType(@NonNull List<?> items, int position) {
        Object object = items.get(position);
        if (!(items.get(position) instanceof Account)) {
            return false;
        }
        return ((Account) object).getCurrency() == Currency.EUR;
    }

    final static class EurViewHolder extends BaseViewHolder {

        TextView tvName;
        ImageView imageView;

        private EurViewHolder(View parent) {
            super(parent);
            tvName = itemView.findViewById(R.id.tv_account_name);
            imageView = itemView.findViewById(R.id.iv_account_image);
        }

        void bind(final Account account) {
            tvName.setText(account.getName());
            imageView.setImageResource(R.drawable.rur);
        }
    }
}
