package com.example.taskbsc.domain;

import java.util.Objects;

public class Account {
    private String name;
    private Currency currency;
    private double sum;

//TODO: maybe delete in future
    //    public Account(String name, Currency currency) {
//        this.name = name;
//        this.currency = currency;
//    }

    public Account(String name, Currency currency, double sum) {
        this.name = name;
        this.currency = currency;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getSum() {
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Double.compare(account.sum, sum) == 0 &&
                Objects.equals(name, account.name) &&
                currency == account.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, currency, sum);
    }
}
