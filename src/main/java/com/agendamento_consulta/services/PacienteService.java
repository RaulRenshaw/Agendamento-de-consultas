package com.agendamento_consulta.services;

import com.agendamento_consulta.dtos.PacienteRequestDTO;
import com.agendamento_consulta.dtos.PacienteResponseDTO;
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

    public PacienteResponseDTO salvarPaciente(PacienteRequestDTO dto) {

        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setEmail(dto.getEmail());
        paciente.setTelefone(dto.getTelefone());

        return PacienteResponseDTO.fromEntity(pacienteRepository.save(paciente));

    }
    public List<PacienteResponseDTO> listarPacientes(){
        return PacienteResponseDTO.fromEntityList(pacienteRepository.findAll());
    }
    public Optional<PacienteResponseDTO> procurarPorId(Long id){
        return pacienteRepository.findById(id)
                .map(PacienteResponseDTO::fromEntity);
    }
    public PacienteResponseDTO atualizarPaciente(Long id, PacienteRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        if (dto.getNome() != null) paciente.setNome(dto.getNome());
        if (dto.getCpf() != null) paciente.setCpf(dto.getCpf());
        if (dto.getEmail() != null) paciente.setEmail(dto.getEmail());
        if (dto.getTelefone() != null) paciente.setTelefone(dto.getTelefone());

        Paciente atualizado = pacienteRepository.save(paciente);
        return PacienteResponseDTO.fromEntity(atualizado);
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
