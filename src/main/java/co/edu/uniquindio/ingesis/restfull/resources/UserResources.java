package co.edu.uniquindio.ingesis.restfull.resources;

import co.edu.uniquindio.ingesis.restfull.dtos.UserRegistrationRequest;
import co.edu.uniquindio.ingesis.restfull.dtos.UserResponse;
import co.edu.uniquindio.ingesis.restfull.services.UserService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class UserResources {
    final UserService userService;

    @POST
    public Response create(@Valid UserRegistrationRequest request){
        // Logica de registro
//        var response = new UserResponse(UUID.randomUUID().toString(), request.username(), request.password(), request.email(), request.roles());
        var response = userService.createUser(request);
        //TODO cambiar por Response.create
        return Response.status(Response.Status.CREATED).entity(response).build();
    }
}
