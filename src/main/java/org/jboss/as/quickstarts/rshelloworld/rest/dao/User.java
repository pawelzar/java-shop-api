package org.jboss.as.quickstarts.rshelloworld.rest.dao;

import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import java.util.List;

public class User{

    @NotNull
    @FormParam("login")
    private String login;

    @NotNull
    @FormParam("name")
    private String name;

    private String email;
    private List<String> tags;

    public User() {
        //
    }

    public User(String login, String name, String email, List<String> tags) {
        this.name = name;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!login.equals(user.login)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return login.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", login=" + login +
                '}';
    }
}
