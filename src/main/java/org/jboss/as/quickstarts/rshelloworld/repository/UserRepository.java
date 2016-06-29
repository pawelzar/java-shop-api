package org.jboss.as.quickstarts.rshelloworld.repository;

import org.jboss.as.quickstarts.rshelloworld.model.User;

import java.util.ArrayList;
import java.util.List;


//@Component
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public List<User> getUsers(){
        return users;
    }
    
    public User save(User user){
        User dbUser = findByLogin(user.getLogin());
        if (dbUser != null){
            dbUser.setName(user.getName());
        } else {
            users.add(user);
        }
        return user;
    }
    
    public User findByLogin(String login) {
        for(User user : users){
            if (login.equalsIgnoreCase(user.getLogin())){
                return user;
            }
        }
        return null;
    }
    
    public void remove(String login){
        User user = findByLogin(login);
        if (user != null){
            users.remove(user);
        }
    }
    
}
