package org.jboss.shop.model;

public class SimpleAccount {

    private String number;
    private double amount;

    public SimpleAccount() {
    }

    public SimpleAccount(String number, double amount) {
        this.number = number;
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
