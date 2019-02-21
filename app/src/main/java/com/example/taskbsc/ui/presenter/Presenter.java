package com.example.taskbsc.ui.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.taskbsc.data.AccountsManager;
import com.example.taskbsc.domain.Account;
import com.example.taskbsc.ui.view.CurrencyListView;

import java.util.List;

import androidx.annotation.Nullable;

@InjectViewState
public class Presenter extends MvpPresenter<CurrencyListView> {
    public void getAccountsList() {
        loadList(AccountsManager.fetchAccounts());
    }

    private void loadList(@Nullable List<Account> accounts) {
        getViewState().loadList(accounts);
    }
}
