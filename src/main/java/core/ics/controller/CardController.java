package core.ics.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Date;

@Path(value = "/api")
public class CardController {



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
