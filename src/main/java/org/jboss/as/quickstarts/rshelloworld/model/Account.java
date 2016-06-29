package org.jboss.as.quickstarts.rshelloworld.model;

public class Account {

    private String number;
    private double amount;

    public Account() {
    }

    public Account(String number, double amount) {
        this.number = number;
        this.amount = amount;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
