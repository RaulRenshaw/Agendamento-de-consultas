package com.agendamento_consulta.dtos;

import com.agendamento_consulta.model.Horario;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorarioResponseDTO {

    private Long id;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
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
    public static List<HorarioResponseDTO> fromEntityList(List<Horario> horario){
        return horario.stream()
                .map(HorarioResponseDTO::fromEntity)
                .toList();
    }
}
