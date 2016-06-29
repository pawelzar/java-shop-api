package org.jboss.as.quickstarts.rshelloworld.rest;

import org.jboss.as.quickstarts.rshelloworld.repository.UserRepository;
import org.jboss.as.quickstarts.rshelloworld.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Autowired
    private UserRepository userRepository;
    
    @GET
    public List<User> getUsers(){
        return userRepository.getUsers();
    }

    @POST
    public Response registerUser(@Valid User user){
        if (userRepository.findByLogin(user.getLogin()) == null) {
            return Response.status(200).build();
        }
        return Response.status(404).build();
    }

    @PUT
    public User updateUser(User user){
        User dbUser = userRepository.save(user);
        return dbUser;
    }
    
    @GET
    @Path("/{login}")
    public Response getUser(@PathParam("login") final String login){
        if (userRepository.findByLogin(login) != null) {
            User user = userRepository.findByLogin(login);
            return Response.status(200).entity(user).build();
        }
        return Response.status(400).build();
   }

    @DELETE
    @Path("/{login}")
    public void deleteUser(@PathParam("login") final String login){
        userRepository.remove(login);
    }

}
