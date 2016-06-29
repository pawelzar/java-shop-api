package org.jboss.as.quickstarts.rshelloworld.model;

public class Account {

    private String number;
    private String amount;
    private Card card;

    public Account() {
    }

    public Account(String number, String amount) {
        this.number = number;
        this.amount = amount;
    }

    public Account(String number, String amount, Card card) {
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
