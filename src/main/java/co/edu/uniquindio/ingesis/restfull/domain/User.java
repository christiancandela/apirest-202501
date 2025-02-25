package co.edu.uniquindio.ingesis.restfull.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class User extends PanacheEntity {
    @Size(min=4,max = 20,message = "El username debe tener mínimo 4 caracteres y máximo 20")
    @NotBlank(message = "El username es obligatorio")
    private String username;
    @NotBlank
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$")
    private String password;
    @NotBlank
    @Email
    private String email;
    private Collection<Rol> roles;

}