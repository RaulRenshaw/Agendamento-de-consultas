package com.agendamento_consulta.mapper;

import com.agendamento_consulta.dtos.ConsultaRequestDTO;
import com.agendamento_consulta.dtos.ConsultaResponseDTO;
import com.agendamento_consulta.model.Consulta;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

    //Converte DTO requerimento para uma entidade consulta
    Consulta toEntity(ConsultaRequestDTO dto);

    //Converte uma entidade consulta em um DTO de resposta
    ConsultaResponseDTO toResponseDto(Consulta consulta);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void atualizarConsultaDto(ConsultaRequestDTO dto, @MappingTarget Consulta entity);
}
