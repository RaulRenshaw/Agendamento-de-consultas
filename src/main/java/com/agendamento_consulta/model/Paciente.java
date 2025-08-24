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
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Pattern(regexp = "\\d{11}", message = "o cpf deve conter exatamente 11 digitos")
    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false)
    @Email(message = "E-mail inválido")
    private String email;

    @Pattern(regexp = "\\+?\\d{10,15}", message = "Telefone invalido")
    @Column(nullable = false, length = 15)
    private String telefone;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;
}
