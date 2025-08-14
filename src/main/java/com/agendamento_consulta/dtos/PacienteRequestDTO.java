package com.agendamento_consulta.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PacienteRequestDTO {

    @NotBlank
    @Getter
    @Setter
    private String name;

    @Pattern(regexp = "\\d{11}", message = "o cpf deve conter exatamente 11 digitos")
    @Column(unique = true, nullable = false, length = 11)
    @Getter
    @Setter
    @NotNull
    private String cpf;


    @Getter
    @Setter
    @NotNull
    private String email;

    @Pattern(regexp = "\\+?\\d{10,15}", message = "Telefone invalido")
    @Column(nullable = false, length = 15)
    @Getter
    @Setter
    @NotNull
    private String telefone;
}
