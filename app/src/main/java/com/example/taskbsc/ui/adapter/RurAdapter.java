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

public class RurAdapter extends
        BaseDelegateAdapter<RurAdapter.RurViewHolder, Account> {

    @Override
    protected void onBindViewHolder(@NonNull View view, @NonNull Account account, @NonNull RurViewHolder viewHolder) {
        viewHolder.bind(account);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.rur_adapter_item;
    }

    @Override
    protected RurViewHolder createViewHolder(View parent) {
        return new RurViewHolder(parent);
    }

    @Override
    public boolean isForViewType(@NonNull List<?> items, int position) {
        Object object = items.get(position);
        if (!(items.get(position) instanceof Account)) {
            return false;
        }
        return ((Account) object).getCurrency() == Currency.RUR;
    }

    final static class RurViewHolder extends BaseViewHolder {

        ImageView imageView;
        TextView tvName;
        TextView tvSum;

        private RurViewHolder(View parent) {
            super(parent);
            imageView = itemView.findViewById(R.id.iv_account_image);
            tvName = itemView.findViewById(R.id.tv_account_name);
            tvSum = itemView.findViewById(R.id.tv_account_sum);
        }

        void bind(final Account account) {
            imageView.setImageResource(R.drawable.rur);
            tvName.setText(account.getName());
            tvSum.setText(String.valueOf(account.getSum()));
        }
    }
}
