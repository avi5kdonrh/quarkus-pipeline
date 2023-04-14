package org.example.tekton;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;

@Path("/hello")
public class GreetingResource {

    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return em.createQuery("from MyEntity", MyEntity.class).getResultList().get(0).getField();
        //return "Hello RESTEasy";
    }
}