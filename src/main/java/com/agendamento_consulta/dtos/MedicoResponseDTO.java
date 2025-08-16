package com.agendamento_consulta.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
