package com.example.taskbsc.data;

import com.example.taskbsc.domain.Account;
import com.example.taskbsc.domain.Currency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountsManager {

    public static List<Account> fetchAccounts() {
        List<Account> accounts = new ArrayList<>();

        //RUR
        accounts.add(new Account("One", Currency.RUR, 100.00));
        accounts.add(new Account("Two", Currency.RUR, 10));
        accounts.add(new Account("Three", Currency.RUR, 30));
        accounts.add(new Account("Four", Currency.RUR, 98));
        accounts.add(new Account("Five", Currency.RUR, 73.73));
        accounts.add(new Account("Six", Currency.RUR, 999.99));
        accounts.add(new Account("Seven", Currency.RUR, 100.01));
        accounts.add(new Account("Eight", Currency.RUR, 100.02));
        accounts.add(new Account("Nine", Currency.RUR, 180.00));

        //USD
        accounts.add(new Account("Ten", Currency.USD, 100.00));
        accounts.add(new Account("Eleven", Currency.USD, 1.00));
        accounts.add(new Account("Twelve", Currency.USD, 0.65));
        accounts.add(new Account("Thirteen", Currency.USD, 25.00));
        accounts.add(new Account("Fourteen", Currency.USD, 1000.00));
        accounts.add(new Account("Fifteen", Currency.USD, 100.17));
        accounts.add(new Account("Sixteen", Currency.USD, 100.18));

        //EUR
        accounts.add(new Account("Seventeen", Currency.EUR, 100.00));
        accounts.add(new Account("Eighteen", Currency.EUR, 14.00));
        accounts.add(new Account("Nineteen", Currency.EUR, 25.00));
        accounts.add(new Account("Twenty", Currency.EUR, 77.00));
        accounts.add(new Account("Twenty one", Currency.EUR, 68.68));

        Collections.shuffle(accounts);
        return accounts;
    }
}
