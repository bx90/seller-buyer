package sellerbuyer.util.exception;

import sellerbuyer.model.bean.ExceptionMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Boxiong
 * @date 3/31/18
 **/
@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {
    @Override
    public Response toResponse(ValidationException e) {
        ExceptionMessage message = new ExceptionMessage(e.toString());
        return Response.status(Status.NOT_FOUND).entity(message).build();
//        return Response.status(Status.NOT_FOUND).entity(e.toString()).build();
    }
}
