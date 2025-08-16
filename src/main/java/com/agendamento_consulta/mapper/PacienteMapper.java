package com.agendamento_consulta.mapper;

import com.agendamento_consulta.dtos.PacienteRequestDTO;
import com.agendamento_consulta.dtos.PacienteResponseDTO;
import com.agendamento_consulta.model.Paciente;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface PacienteMapper {

    //Converte DTO de requerimento para uma entidade paciente
    Paciente toEntity(PacienteRequestDTO dto);

    //Converte uma entidade paciente em um DTO de resposta
    PacienteResponseDTO toResponseDto(Paciente paciente);

    List<PacienteResponseDTO> toDtoList (List<Paciente> pacientes);

    //Atualiza apenas campos não nulos
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void atualizarPacienteDto(PacienteRequestDTO dto, @MappingTarget Paciente entity);
}
