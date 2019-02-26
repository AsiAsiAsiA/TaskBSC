package com.example.taskbsc.ui.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.taskbsc.data.AccountsManager;
import com.example.taskbsc.domain.Account;
import com.example.taskbsc.ui.view.CurrencyListView;

import java.util.Collections;
import java.util.List;

import androidx.annotation.Nullable;

@InjectViewState
public class Presenter extends MvpPresenter<CurrencyListView> {
    public void getAccountsList() {
        List<Account> list = AccountsManager.fetchAccounts();

        Collections.sort(list, (a1, a2) ->
                a1.getCurrency().ordinal() - a2.getCurrency().ordinal());

        showAccounts(list);
    }

    private void showAccounts(@Nullable List<Account> accounts) {
        getViewState().showAccounts(accounts);
    }
}
