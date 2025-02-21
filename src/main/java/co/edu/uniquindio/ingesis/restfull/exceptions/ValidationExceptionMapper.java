package co.edu.uniquindio.ingesis.restfull.exceptions;

import co.edu.uniquindio.ingesis.restfull.dtos.ErrorResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        var reponse = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).map(m->new ErrorResponse("Error",m)).toList();
        return Response.status(Response.Status.BAD_REQUEST).entity(reponse).build();
    }
}
