package com.agendamento_consulta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    @Enumerated(EnumType.STRING)
    private StatusHorario status = StatusHorario.LIVRE;
    @ManyToOne
    private Medico medico;
    @OneToOne
    private Consulta consulta;


    public enum StatusHorario{
        LIVRE,OCUPADO
    }
}
