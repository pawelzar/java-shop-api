package org.jboss.as.quickstarts.rshelloworld.model;

public class Account {

    public String number;
    public String amount;

    public Account() {
    }

    public Account(String number, String amount) {
        this.number = number;
        this.amount = amount;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
