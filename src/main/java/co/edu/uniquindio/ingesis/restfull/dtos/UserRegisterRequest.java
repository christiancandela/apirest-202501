package co.edu.uniquindio.ingesis.restfull.dtos;

import co.edu.uniquindio.ingesis.restfull.domain.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public record UserRegisterRequest(
        @Size(min=4,max = 20,message = "El username debe tener mínimo 4 caracteres y máximo 20")
        @NotBlank(message = "El username es obligatorio")
        String username,
        @NotBlank
        @Pattern(regexp = "^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$")
        String password,
        @NotBlank
        @Email
        String email,
        Collection<Rol> roles
        ) {

    public UserRegisterRequest {
        roles = Objects.requireNonNullElse(roles, List.of(Rol.USER));
    }
}
