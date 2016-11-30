package org.jboss.shop.welcome;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class Hello {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
        return"<html> " + "<title>" + "BAWSJ API" + "</title>" + "</html> ";
    }
}
