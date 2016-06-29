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

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPin(float amount) {
        this.pin = pin;
    }
}
