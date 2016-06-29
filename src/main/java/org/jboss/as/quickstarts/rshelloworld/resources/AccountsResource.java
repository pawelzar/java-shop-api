package org.jboss.as.quickstarts.rshelloworld.resources;

import org.jboss.as.quickstarts.rshelloworld.model.Account;
import org.jboss.as.quickstarts.rshelloworld.model.Card;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.Objects;


@Path("/")
public class AccountsResource {

    private static ArrayList<Account> accountsList = new ArrayList<Account>() {{
        add(new Account("account 1", "50.0", new Card("1", "1234")));
        add(new Account("account 2", "0.0", new Card("2", "1234")));
        add(new Account("account 3", "1290.80", new Card("3", "1234")));
    }};

    @Path("/accounts")
    @GET
    @Produces("application/json")
    public ArrayList<Account> getAccounts() {
        return accountsList;
    }

    @Path("/authorize")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Account getAccount(Card card) {
        for (Account account : accountsList) {
            if (Objects.equals(account.getCard().getNumber(), card.getNumber()) &&
                    Objects.equals(account.getCard().getPin(), card.getPin())) {
                return account;
            }
        }
        return null;
    }
}
