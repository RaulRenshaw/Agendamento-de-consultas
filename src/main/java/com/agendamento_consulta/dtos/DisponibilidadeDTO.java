package com.agendamento_consulta.dtos;

import lombok.*;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DisponibilidadeDTO {
    private String diasSemana;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private int duracao;
}
