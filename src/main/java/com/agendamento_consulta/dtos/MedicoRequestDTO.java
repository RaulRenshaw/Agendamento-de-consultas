package com.agendamento_consulta.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoRequestDTO {

    @NotNull
    private String nome;

    @NotNull
    private String crm;

    @NotNull
    private String specialty;

    @NotNull
    @Pattern(regexp = "\\d{11}", message = "O número deve conter exatamente 11 números")
    private String telefone;

    @NotNull
    @Email(message = "E-mail inválido")
    private String email;
}
