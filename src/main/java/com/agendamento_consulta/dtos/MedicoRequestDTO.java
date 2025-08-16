package com.agendamento_consulta.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoRequestDTO {

    @Column(nullable = false)
    @Getter
    @Setter
    @NotNull
    private String nome;

    @Column(unique = true, nullable = false)
    @Getter
    @Setter
    @NotNull
    private String crm;

    @Column(nullable = false)
    @Getter
    @Setter
    @NotNull
    private String specialty;

    @Pattern(regexp = "\\d{11}", message = "O número deve conter exatamente 11 números")
    @Getter
    @Setter
    @NotNull
    private String telefone;

    @Getter
    @Setter
    @NotNull
    private String email;
}
