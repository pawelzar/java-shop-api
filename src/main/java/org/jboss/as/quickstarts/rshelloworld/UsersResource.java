package org.jboss.as.quickstarts.rshelloworld;

import javax.ws.rs.*;
import java.util.ArrayList;


@Path("/users")
public class UsersResource {

    public static ArrayList<User> usersList = new ArrayList<User>() {{
        add(new User("1", "Jan", "Kowalski", "jk@email.com"));
        add(new User("2", "Andrzej", "Nowak", "an@email.com"));
    }};

    @GET
    @Produces("application/json")
    public ArrayList<User> getUsers(@DefaultValue("") @QueryParam("lastname") String lastname) {
        if (!lastname.equals("")) {
            ArrayList<User> expectedUser = new ArrayList<User>();
            for (User user: usersList) {
                if (lastname.equals(user.lastname)) {
                    expectedUser.add(user);
                }
            }
            return expectedUser;
        }
        else return usersList;
    }

    @Path("/{id}")
    @GET
    @Produces("application/json")
    public User getUserById(@PathParam("id") String userId) {
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).id.equals(userId)) {
                return usersList.get(i);
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
            if (usersList.get(i).id.equals(userId)) {
                usersList.remove(i);
                return "User succesfully deleted.";
            }
        }
        return "User not found.";
    }
}
