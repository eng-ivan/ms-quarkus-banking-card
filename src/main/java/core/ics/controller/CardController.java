package core.ics.controller;

import core.ics.services.CardServices;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Date;

@ApplicationScoped
@Path(value = "/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CardController {

    @Inject
    CardServices cardServices;

    @POST
    @Path(value = "/card/save")
    @Transactional
    public Response save(){

        return Response
                .status(Response.Status.CREATED)
                .location(URI.create("/api/card/save"))
                .entity(cardServices.saveCard())
                .build();
    }

    @GET
    @Path(value = "/card/list")
    public Response list(){
        return Response
                .status(Response.Status.OK)
                .location(URI.create("/api/card/list"))
                .entity(cardServices.list())
                .build();
    }

    @GET
    @Path(value = "/card/{id}")
    public Response findCardByID(@PathParam(value = "id") String id){
        return Response
                .status(Response.Status.OK)
                .location(URI.create("/api/card/id"))
                .entity(cardServices.findCardByID(id))
                .build();
    }

    @GET
    @Path(value = "/test")
    public Response test() throws UnknownHostException {
        String response = "address: "+ InetAddress.getLocalHost() + "\ntimestamp: "+new Date().toString();

        return Response
                .status(Response.Status.OK)
                .location(URI.create("/api/test"))
                .entity(response)
                .build();
    }
}