package org.jboss.shop.resources;

import org.jboss.shop.exceptions.CardException;
import org.jboss.shop.model.Account;
import org.jboss.shop.model.Card;
import org.jboss.shop.model.SimpleAccount;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.Objects;


@Path("/")
public class AccountsResource {

    private static ArrayList<Account> accountsList = new ArrayList<Account>() {{
        add(new Account("11111", 50.0, new Card("1234567896574356", "6539")));
        add(new Account("22222", 0.0, new Card("2657896543275974", "4753")));
        add(new Account("33333", 1290.80, new Card("3786535690865407", "9737")));
    }};

    @Path("/accounts")
    @GET
    @Produces("application/json")
    public ArrayList<Account> getAccounts() {
        return accountsList;
    }

    @Path("/accounts")
    @POST
    @Consumes("application/json")
    public void addAccount(Account account) {
        accountsList.add(account);
    }

    @Path("/accounts")
    @PUT
    @Consumes("application/json")
    public void updateAccount(Account newAccount) {
        for (Account account : accountsList) {
            if (Objects.equals(account.getNumber(), newAccount.getNumber())) {
                account.setAmount(newAccount.getAmount());
            }
        }
    }

    @Path("/authorize")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public SimpleAccount getAccount(Card card) {
        SimpleAccount simpleAccount = null;
        for (Account account : accountsList) {
            if (Objects.equals(account.getCard().getNumber(), card.getNumber()) &&
                    Objects.equals(account.getCard().getPin(), card.getPin())) {
                simpleAccount = new SimpleAccount(account.getNumber(), account.getAmount());
            }
        }
        if (simpleAccount == null) {
            throw new CardException("Card not found", "Authorization failed");
        }
        return simpleAccount;
    }

    @Path("/authorize")
    @GET
    @Produces("application/json")
    public SimpleAccount getAccount(@QueryParam("number") String number, @QueryParam("pin") String pin) {
        for (Account account : accountsList) {
            if (Objects.equals(account.getCard().getNumber(), number) &&
                    Objects.equals(account.getCard().getPin(), pin)) {
                return new SimpleAccount(account.getNumber(), account.getAmount());
            }
        }
        return null;
    }

    @Path("/cards")
    @PUT
    @Consumes("application/json")
    public void changePin(Card newCard) {
        for (Account account : accountsList) {
            if (Objects.equals(account.getCard().getNumber(), newCard.getNumber())) {
                account.getCard().setPin(newCard.getPin());
            }
        }
    }

}
