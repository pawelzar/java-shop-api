package org.jboss.shop.exceptions;

public class ExceptionMessage {
    private String message;
    private String info;

    public ExceptionMessage(String message, String info) {
        this.message = message;
        this.info = info;
    }

    public String getMessage() {
        return message;
    }

    public String getInfo() {
        return info;
    }
}
