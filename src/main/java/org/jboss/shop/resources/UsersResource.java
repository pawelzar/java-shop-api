package org.jboss.shop.resources;

import org.jboss.shop.model.User;

import javax.ws.rs.*;
import java.util.ArrayList;


@Path("/users")
public class UsersResource {

    private static ArrayList<User> usersList = new ArrayList<User>() {{
        add(new User("1", "Jan", "Kowalski", "jk@email.com"));
        add(new User("2", "Andrzej", "Nowak", "an@email.com"));
    }};

    @GET
    @Produces("application/json")
    public ArrayList<User> getUsers() {
        return usersList;
    }

    @Path("/{id}")
    @GET
    @Produces("application/json")
    public User getUserById(@PathParam("id") String userId) {
        for (User anUsersList : usersList) {
            if (anUsersList.getId().equals(userId)) {
                return anUsersList;
            }
        }
        return null;
    }

    @POST
    @Consumes("application/json")
    public void createUser(User user) {
        usersList.add(user);
    }

    @Path("/{id}")
    @DELETE
    public String deleteUser(@PathParam("id") String userId) {
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getId().equals(userId)) {
                usersList.remove(i);
                return "User succesfully deleted.";
            }
        }
        return "User not found.";
    }
}
