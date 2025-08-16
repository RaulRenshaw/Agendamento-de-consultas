package com.agendamento_consulta.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteRequestDTO {

    @NotBlank(message = "O nome não pode estar em branco")
    private String nome;

    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos")
    private String cpf;

    @NotBlank(message = "O e-mail não pode estar em branco")
    private String email;

    @Pattern(regexp = "\\+?\\d{10,15}", message = "Telefone inválido")
    private String telefone;
}
