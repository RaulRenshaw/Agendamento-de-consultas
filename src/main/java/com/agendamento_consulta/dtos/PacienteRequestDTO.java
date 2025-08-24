package com.agendamento_consulta.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteRequestDTO {

    @NotNull
    private String nome;

    @NotNull
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos")
    private String cpf;

    @NotNull
    private String email;

    @NotNull
    @Pattern(regexp = "\\+?\\d{10,15}", message = "Telefone inválido")
    private String telefone;
}
