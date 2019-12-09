package com.example.ewallet;

public class Model
{
    String Type, Account, Amount;

    public Model(String Type, String Account, String Amount)
    {
        this.Type = Type;
        this.Account = Account;
        this.Amount = Amount;
    }


    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}