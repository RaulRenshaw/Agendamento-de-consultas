package com.agendamento_consulta.dtos;

import com.agendamento_consulta.model.Paciente;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;

    public static PacienteResponseDTO fromEntity(Paciente paciente){
        return new PacienteResponseDTO(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getCpf(),
                paciente.getTelefone()
        );
    }
    public static List<PacienteResponseDTO> fromEntityList(List<Paciente> pacientes){
        return pacientes.stream()
                .map(PacienteResponseDTO::fromEntity)
                .toList();
    }
}
