package com.example.taskbsc.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.taskbsc.R;
import com.example.taskbsc.domain.Account;
import com.example.taskbsc.moxyandroidx.MvpAppCompatFragment;
import com.example.taskbsc.ui.adapter.CompositeDelegateAdapter;
import com.example.taskbsc.ui.adapter.UsdDelegateAdapter;
import com.example.taskbsc.ui.presenter.Presenter;
import com.example.taskbsc.ui.view.CurrencyListView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrencyListFragment extends MvpAppCompatFragment implements CurrencyListView {

    private static final String TAG = CurrencyListFragment.class.getSimpleName();
    @InjectPresenter
    Presenter presenter;
    private CompositeDelegateAdapter adapter;

    static Fragment newInstance() {
        return new CurrencyListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_currency_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.accounts_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);

        List<Account> accounts = new ArrayList<>();
//        adapter = new AccountsAdapter(accounts);

        adapter = new CompositeDelegateAdapter
                .Builder<>()
                .add(new UsdDelegateAdapter())
                .build();

        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(requireContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        presenter.getAccountsList();
    }

    @Override
    public void loadList(List<Account> accounts) {
        if (accounts != null) {
            adapter.updateAccounts(accounts);
        }
    }
}
