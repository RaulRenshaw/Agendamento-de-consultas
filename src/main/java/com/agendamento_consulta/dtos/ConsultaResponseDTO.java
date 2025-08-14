package com.agendamento_consulta.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ConsultaResponseDTO {

        private Long id;
        private LocalDateTime dataHora;
        private Long pacienteId;
        private String pacienteNome;
        private Long medicoId;
        private String medicoNome;
        private String medicoEspecialidade;

}
