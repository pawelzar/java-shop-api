package org.jboss.as.quickstarts.rshelloworld.model;

public class Account {

    private String number;
    private double amount;
    private Card card;

    public Account() {
    }

    public Account(String number, double amount) {
        this.number = number;
        this.amount = amount;
    }

    public Account(String number, double amount, Card card) {
        this.number = number;
        this.amount = amount;
        this.card = card;
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
