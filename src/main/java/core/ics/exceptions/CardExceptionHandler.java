package core.ics.exceptions;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Date;
import java.util.UUID;

@Provider
public class CardExceptionHandler implements ExceptionMapper<RuntimeException> {


    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(RuntimeException exception) {

        CardError cardError = new CardError();

        if (exception instanceof BusinessException){
            cardError.setError(exception.getMessage());
            cardError.setTimestamp(new Date().toString());
            cardError.setHashError(UUID.randomUUID().toString());

            return Response.status(Response.Status.NOT_FOUND).entity(cardError).build();
        }

        cardError.setError(exception.getMessage());
        cardError.setTimestamp(new Date().toString());
        cardError.setHashError(UUID.randomUUID().toString());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(cardError).build();
    }
}
