package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;
    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public StudentAccount(String name, double balance, String  institutionName) {
        super(name, balance);
        //minimum balance is 0 by default
        this.institutionName=institutionName;
    }

}
