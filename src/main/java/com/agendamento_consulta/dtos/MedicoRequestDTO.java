package com.agendamento_consulta.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MedicoRequestDTO {

    @Column(nullable = false)
    @Getter
    @Setter
    @NotNull
    private String name;

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
