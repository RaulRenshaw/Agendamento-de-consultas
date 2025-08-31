package com.agendamento_consulta.dtos;

import com.agendamento_consulta.model.Horario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorarioResponseDTO {

    private Long id;
    private LocalDateTime data;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFim;
    private Horario.StatusHorario status;
    public static HorarioResponseDTO fromEntity(Horario horario){
        return new HorarioResponseDTO(
                horario.getId(),
                horario.getData(),
                horario.getHoraInicio(),
                horario.getHoraFim(),
                horario.getStatus()
        );
    }
}
