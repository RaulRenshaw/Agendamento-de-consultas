package com.agendamento_consulta.services;

import com.agendamento_consulta.dtos.ConsultaRequestDTO;
import com.agendamento_consulta.dtos.ConsultaResponseDTO;
import com.agendamento_consulta.model.Consulta;
import com.agendamento_consulta.model.Medico;
import com.agendamento_consulta.model.Paciente;
import com.agendamento_consulta.repository.ConsultaRepository;
import com.agendamento_consulta.repository.MedicoRepository;
import com.agendamento_consulta.repository.PacienteRepository;
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
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    public ConsultaResponseDTO salvarConsulta(ConsultaRequestDTO dto){
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        Medico medico = medicoRepository.findById(dto.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Medico não encontrado"));

        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setDataHora(dto.getDataHora());

        return ConsultaResponseDTO.fromEntity(consultaRepository.save(consulta));
    }
    public List<ConsultaResponseDTO> listarConsultas(){
        return ConsultaResponseDTO.fromEntityList(consultaRepository.findAll());
    }
    public Optional<ConsultaResponseDTO> procurarPorId(Long id){
        return consultaRepository.findById(id)
                .map(ConsultaResponseDTO::fromEntity);
    }
    public ConsultaResponseDTO atualizarConsulta(Long id, ConsultaRequestDTO dto){
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

      if (dto.getPacienteId() != null){
          Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                  .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
          consulta.setPaciente(paciente);
      }
      if (dto.getMedicoId() != null){
          Medico medico = medicoRepository.findById(dto.getMedicoId())
                  .orElseThrow(() -> new RuntimeException("Medico não encontrado"));
          consulta.setMedico(medico);
      }
      if (dto.getDataHora() != null){
          consulta.setDataHora(dto.getDataHora());
      }

      Consulta salva = consultaRepository.save(consulta);
      return ConsultaResponseDTO.fromEntity(salva);
    }
    public boolean deletar(Long id){
        return consultaRepository.findById(id)
                .map(consulta -> {
                    consultaRepository.delete(consulta);
                    return true;
                }).orElse(false);
    }
}
