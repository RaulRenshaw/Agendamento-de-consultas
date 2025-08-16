package com.agendamento_consulta.mapper;

import com.agendamento_consulta.dtos.MedicoRequestDTO;
import com.agendamento_consulta.dtos.MedicoResponseDTO;
import com.agendamento_consulta.model.Medico;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface MedicoMapper {

    //Converte DTO de requerimento para uma entidade paciente
    Medico toEntity(MedicoRequestDTO dto);

    //Converte uma entidade paciente em um DTO de resposta
    MedicoResponseDTO toResponseDto(Medico medico);

    //Atualiza apenas campos não nulos
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void atualizarMedicoDto(MedicoRequestDTO dto, @MappingTarget Medico entity);
}
