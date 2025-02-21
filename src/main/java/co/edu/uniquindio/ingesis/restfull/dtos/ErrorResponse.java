package co.edu.uniquindio.ingesis.restfull.dtos;

import jakarta.validation.constraints.NotBlank;

public record ErrorResponse(@NotBlank String tipo, @NotBlank String descripcion) {
}
