package com.agendamento_consulta.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HorarioRequestDTO {

    @NotNull
    private LocalDate data;
    @NotNull
    private LocalTime horaInicio;
    @NotNull
    private LocalTime horaFim;
}
