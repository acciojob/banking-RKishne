package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance) {
        this.name=name;
        this.balance=balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if (digits <= 0 || digits > sum || sum > digits * 9) {
            throw new IllegalArgumentException("Account Number can not be generated");
        }

        return  generateAccountNumberHelper(digits, sum, "");
    }

    private String generateAccountNumberHelper(int digits, int sum, String s) {
        if(digits==0){
            if(sum == 0){
                return s;
            }
            else{
                return null;
            }
        }
        for(int i=0;i<=9;i++){
            if(s.isEmpty() && i==0 && digits>1){
                continue;
            }
            String result=generateAccountNumberHelper(digits-1,sum-i,s+i);
            if(result!=null){
                return result;
            }
        }
        return null;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        try {
            if (balance - amount > minBalance) {
                balance = balance - amount;
            }
        }
        catch (Exception e){
            System.out.println("Insufficient Balance");
        }
    }
}