package com.driver;

import java.util.Arrays;
import java.util.LinkedList;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name,balance);
        this.tradeLicenseId=tradeLicenseId.toUpperCase();
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        if(balance<5000){
            throw new Exception("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if (tradeLicenseId == null ||tradeLicenseId.isEmpty()) {
            throw new IllegalArgumentException("Invalid input: License ID is empty");
        }

        char[] chars = tradeLicenseId.toCharArray();
        Arrays.sort(chars);

        LinkedList<Character> sortedChars = new LinkedList<>();
        for (char c : chars) {
            sortedChars.add(c);
        }

        LinkedList<Character> validChars = new LinkedList<>();
        validChars.add(sortedChars.removeFirst());

        while (!sortedChars.isEmpty()) {
            boolean found = false;
            for (int i = 0; i < sortedChars.size(); i++) {
                if (sortedChars.get(i) != validChars.getLast()) {
                    validChars.add(sortedChars.remove(i));
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new IllegalArgumentException("Valid License can not be generated");
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : validChars) {
            result.append(c);
        }
        this.tradeLicenseId=result.toString().toUpperCase();
    }
}
