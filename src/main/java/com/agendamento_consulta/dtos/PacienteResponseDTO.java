package com.agendamento_consulta.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PacienteResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String telefone;
}
