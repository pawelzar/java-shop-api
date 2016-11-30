package org.jboss.shop.exceptions;


import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class CardException extends WebApplicationException {
    public CardException(String message, String info) {
        //super(Responses.notFound().type(MediaType.APPLICATION_JSON).entity(message).build());
        super(Response.status(Response.Status.NOT_FOUND).
                entity(createExceptionMessage(message, info))
                .type(MediaType.APPLICATION_JSON)
                .build());
    }

    private static ExceptionMessage createExceptionMessage(String message, String info) {
        return new ExceptionMessage(message, info);
    }
}
