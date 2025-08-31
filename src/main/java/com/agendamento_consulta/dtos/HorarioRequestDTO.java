package com.agendamento_consulta.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HorarioRequestDTO {

    @NotNull
    private LocalDateTime data;
    @NotNull
    private LocalDateTime horaInicio;
    @NotNull
    private LocalDateTime horaFim;
}
