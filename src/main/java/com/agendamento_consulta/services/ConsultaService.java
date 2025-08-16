package com.agendamento_consulta.services;

import com.agendamento_consulta.dtos.ConsultaRequestDTO;
import com.agendamento_consulta.dtos.ConsultaResponseDTO;
import com.agendamento_consulta.mapper.ConsultaMapper;
import com.agendamento_consulta.model.Consulta;
import com.agendamento_consulta.repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private ConsultaMapper consultaMapper;

    public ConsultaResponseDTO salvarConsulta(ConsultaRequestDTO dto){
        Consulta consulta = consultaMapper.toEntity(dto);
        Consulta salvo = consultaRepository.save(consulta);

        return  consultaMapper.toResponseDto(salvo);
    }

    public List<Consulta> listarConsultas(){
        return consultaRepository.findAll();
    }

    public Optional<Consulta> procurarPorId(Long id){
        return consultaRepository.findById(id);
    }

    public ConsultaResponseDTO atualizarConsulta(Long id, ConsultaRequestDTO dto){
        Consulta atualizado = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        consultaMapper.atualizarConsultaDto(dto, atualizado);

        Consulta salva = consultaRepository.save(atualizado);

        return consultaMapper.toResponseDto(salva);
    }

    public void deletar(Long id){
        consultaRepository.deleteById(id);
    }
}
