package com.agendamento_consulta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private String name;

    @Column(unique = true, nullable = false)
    @Getter
    @Setter
    private String crm;


    @Column(nullable = false)
    @Getter
    @Setter
    private String specialty;

    @Pattern(regexp = "\\d{11}", message = "O número deve conter exatamente 11 números")
    @Getter
    @Setter
    private String telefone;

    @Getter
    @Setter
    private String email;
}
