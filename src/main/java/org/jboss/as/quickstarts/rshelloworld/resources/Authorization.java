package org.jboss.as.quickstarts.rshelloworld.resources;

import org.jboss.as.quickstarts.rshelloworld.model.Account;
import org.jboss.as.quickstarts.rshelloworld.model.Card;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Objects;

@Path("/authorize")
public class Authorization {

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public Account getAccount(Card card) {
        for (Account account : AccountsResource.accountsList) {
            if (Objects.equals(account.getCard().getNumber(), card.getNumber()) &&
                    Objects.equals(account.getCard().getPin(), card.getPin())) {
                return account;
            }
        }
        return null;
    }
}
