package co.edu.uniquindio.ingesis.restfull.resources;

import co.edu.uniquindio.ingesis.restfull.dtos.UserRegisterRequest;
import co.edu.uniquindio.ingesis.restfull.dtos.UserResponse;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResources {

    @POST
    public Response create(@Valid UserRegisterRequest request){
        // Logica de registro
        var response = new UserResponse(UUID.randomUUID().toString(), request.username(), request.password(), request.email(), request.roles());
        //TODO cambiar por Response.create
        return Response.status(Response.Status.CREATED).entity(response).build();
    }
}
