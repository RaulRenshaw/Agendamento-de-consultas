package com.agendamento_consulta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false, length = 10)
    private String crm;

    @Column(nullable = false)
    private String specialty;

    @Column(nullable = false, length = 11)
    @Pattern(regexp = "\\d{11}", message = "O número deve conter exatamente 11 números")
    private String telefone;

    @Column(nullable = false)
    @Email(message = "E-mail inválido")
    private String email;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;
}
