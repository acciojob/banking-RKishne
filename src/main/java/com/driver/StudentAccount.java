package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public StudentAccount(String name, double balance, String  institutionName) {
        super(name, balance);
        //minimum balance is 0 by default
        this.institutionName=institutionName;
    }

}
