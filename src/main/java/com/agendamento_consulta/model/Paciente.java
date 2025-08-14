package com.agendamento_consulta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @NotBlank
    @Getter
    @Setter
    private String name;

    @Pattern(regexp = "\\d{11}", message = "o cpf deve conter exatamente 11 digitos")
    @Column(unique = true, nullable = false, length = 11)

    @Getter
    @Setter
    private String cpf;


    @Getter
    @Setter
    private String email;

    @Pattern(regexp = "\\+?\\d{10,15}", message = "Telefone invalido")
    @Column(nullable = false, length = 15)
    @Getter
    @Setter
    private String telefone;



}
