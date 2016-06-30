package org.jboss.as.quickstarts.rshelloworld.resources;

import org.jboss.as.quickstarts.rshelloworld.model.Product;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/products")
public class ProductsResource {

    private static ArrayList<Product> productsList = new ArrayList<Product>() {{
    }};

    @GET
    @Produces({"application/json"})
    public ArrayList<Product> getProducts() {
        return productsList;
    }

    @POST
    @Consumes({"application/json"})
    public void addProduct(Product product) {
        productsList.add(product);
    }

    @Path("/many")
    @POST
    @Consumes({"application/json"})
    public void addProducts(List<Product> products) {
        for (Product product : products) {
            productsList.add(product);
        }
    }
}
