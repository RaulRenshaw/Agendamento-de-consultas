package com.agendamento_consulta.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisponibilidadeResponseDTO {
    private String mensagem;
    private List<HorarioResponseDTO> horariosGerados;

}
