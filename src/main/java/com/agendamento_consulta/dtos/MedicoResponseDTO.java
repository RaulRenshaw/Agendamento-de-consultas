package com.agendamento_consulta.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MedicoResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String crm;
    private String specialty;
    private String telefone;
}
