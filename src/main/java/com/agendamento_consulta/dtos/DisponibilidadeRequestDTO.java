package com.agendamento_consulta.dtos;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DisponibilidadeRequestDTO {
    private List<String> diasSemana;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private int duracao;

    private LocalDate dataInicio;
    private LocalDate dataFim;
}
