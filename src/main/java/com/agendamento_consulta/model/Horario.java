package com.agendamento_consulta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime data;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFim;
    @Enumerated(EnumType.STRING)
    private StatusHorario status;
    @ManyToOne
    private Medico medico;

    public enum StatusHorario{
        LIVRE,OCUPADO
    }
}
