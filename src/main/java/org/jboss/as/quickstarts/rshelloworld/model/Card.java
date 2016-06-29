package org.jboss.as.quickstarts.rshelloworld.model;

public class Card {


    private String number;
    private String pin;

    public Card() {
    }

    public Card(String number, String pin) {
        this.number = number;
        this.pin = pin;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(float amount) {
        this.pin = pin;
    }
}
