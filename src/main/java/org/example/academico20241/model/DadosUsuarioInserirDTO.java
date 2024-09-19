package org.example.academico20241.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record DadosUsuarioInserirDTO(@NotEmpty String nome,
                                     Integer idade,
                                     @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "A senha deve ter no mínimo 8 caracteres e incluir letras e números.")
                                     String senha) {
}
