package com.agendamento_consulta.dtos;

import com.agendamento_consulta.model.Consulta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaResponseDTO {

        private Long id;
        private LocalDateTime dataHora;
        private Long pacienteId;
        private String pacienteNome;
        private Long medicoId;
        private String medicoNome;
        private String medicoEspecialidade;
        public static ConsultaResponseDTO fromEntity(Consulta consulta){
                return new ConsultaResponseDTO(
                        consulta.getId(),
                        consulta.getDataHora(),
                        consulta.getPaciente().getId(),
                        consulta.getPaciente().getNome(),
                        consulta.getMedico().getId(),
                        consulta.getMedico().getNome(),
                        consulta.getMedico().getSpecialty()
                );
        }
        public static List<ConsultaResponseDTO> fromEntityList(List<Consulta> consultas){
                return consultas.stream()
                        .map(ConsultaResponseDTO::fromEntity)
                        .toList();
        }

}
