package com.agendamento_consulta.services;

import com.agendamento_consulta.dtos.PacienteRequestDTO;
import com.agendamento_consulta.dtos.PacienteResponseDTO;
import com.agendamento_consulta.mapper.PacienteMapper;
import com.agendamento_consulta.model.Paciente;
import com.agendamento_consulta.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private PacienteMapper pacienteMapper;

    public PacienteResponseDTO salvarPaciente(PacienteRequestDTO dto){
        Paciente paciente = pacienteMapper.toEntity(dto);
        Paciente salvo = pacienteRepository.save(paciente);

        return pacienteMapper.toResponseDto(salvo);
    }
    public List<PacienteResponseDTO> listarPacientes(){
        return pacienteMapper.toDtoList(pacienteRepository.findAll());
    }
    public Optional<PacienteResponseDTO> porcurarPorId(Long id){
        return pacienteRepository.findById(id)
                .map(pacienteMapper::toResponseDto);
    }
    public PacienteResponseDTO atualizarPaciente(Long id, PacienteRequestDTO dto) {
        Paciente atualizado = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        pacienteMapper.atualizarPacienteDto(dto, atualizado);

        Paciente salvo = pacienteRepository.save(atualizado);

        return pacienteMapper.toResponseDto(salvo);
    }
    public boolean deletarPaciente(Long id){
       return pacienteRepository.findById(id)
               .map(paciente -> {
                   pacienteRepository.delete(paciente);
                   return true;
               })
               .orElse(false);
    }
}
