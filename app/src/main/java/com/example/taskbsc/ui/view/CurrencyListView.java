package com.example.taskbsc.ui.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.taskbsc.domain.Account;

import java.util.List;

public interface CurrencyListView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void loadList(List<Account> accounts);
}
