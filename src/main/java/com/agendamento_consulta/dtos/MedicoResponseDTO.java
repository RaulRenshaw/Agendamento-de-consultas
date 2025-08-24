package com.agendamento_consulta.dtos;

import com.agendamento_consulta.model.Medico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicoResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String specialty;
    private String telefone;
    public static MedicoResponseDTO fromEntity(Medico medico){
        return new MedicoResponseDTO(
                medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getSpecialty(),
                medico.getTelefone()
        );
    }
    public static List<MedicoResponseDTO> fromEntityList(List<Medico> medicos){
        return medicos.stream()
                .map(MedicoResponseDTO::fromEntity)
                .toList();
    }
}
