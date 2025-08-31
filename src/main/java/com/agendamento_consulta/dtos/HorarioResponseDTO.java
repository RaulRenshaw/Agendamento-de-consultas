package com.agendamento_consulta.dtos;

import com.agendamento_consulta.model.Horario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
    public static List<HorarioResponseDTO> fromEntityList(List<Horario> horario){
        return horario.stream()
                .map(HorarioResponseDTO::fromEntity)
                .toList();
    }
}
