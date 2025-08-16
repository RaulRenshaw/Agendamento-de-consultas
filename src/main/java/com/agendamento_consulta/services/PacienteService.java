package com.agendamento_consulta.services;

import com.agendamento_consulta.dtos.PacienteRequestDTO;
import com.agendamento_consulta.dtos.PacienteResponseDTO;
import com.agendamento_consulta.mapper.PacienteMapper;
import com.agendamento_consulta.model.Paciente;
import com.agendamento_consulta.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;

    public PacienteResponseDTO salvarPaciente(PacienteRequestDTO dto){
        Paciente paciente = pacienteMapper.toEntity(dto);
        Paciente salvo = pacienteRepository.save(paciente);

        return pacienteMapper.toResponseDto(salvo);
    }

    public List<PacienteResponseDTO> listarPacientes(){
        return pacienteMapper.toDtoList(pacienteRepository.findAll());
    }

    public Optional<Paciente> porcurarPorId(Long id){
        return pacienteRepository.findById(id);
    }

    public PacienteResponseDTO atualizarPaciente(Long id, PacienteRequestDTO dto) {
        Paciente atualizado = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        pacienteMapper.atualizarPacienteDto(dto, atualizado);

        Paciente salvo = pacienteRepository.save(atualizado);

        return pacienteMapper.toResponseDto(salvo);
    }

    public void deletarPaciente(Long id){
        pacienteRepository.deleteById(id);
    }
}
