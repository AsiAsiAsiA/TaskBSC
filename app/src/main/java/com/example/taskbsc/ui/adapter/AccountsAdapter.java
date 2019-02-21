package com.example.taskbsc.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taskbsc.R;
import com.example.taskbsc.domain.Account;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AccountsAdapter extends RecyclerView.Adapter<AccountsAdapter.AccountsViewHolder> {
    private static final String TAG = AccountsAdapter.class.getSimpleName();

    private List<Account> accounts;

    public AccountsAdapter(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void updateAccounts(List<Account> accounts) {
        this.accounts = accounts;
        Log.d(TAG, accounts.toString());
    }

    @NonNull
    @Override
    public AccountsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.accounts_adapter_item, parent, false);
        return new AccountsViewHolder(view);
    }

    //TODO: реализовать RecyclerView для одного ViewType
    //TODO: реализовать RecyclerView для разных ViewType
    @Override
    public void onBindViewHolder(@NonNull AccountsViewHolder holder, int position) {
        holder.bind(accounts.get(position));
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }


    class AccountsViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView imageView;
        TextView tvSum;

        AccountsViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_account_name);
            imageView = itemView.findViewById(R.id.iv_account_image);
            tvSum = itemView.findViewById(R.id.tv_account_sum);
        }

        void bind(final Account account) {
            tvName.setText(account.getName());
            imageView.setImageResource(R.drawable.rur);
            tvSum.setText(String.valueOf(account.getSum()));
        }
    }
}
