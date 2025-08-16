package com.agendamento_consulta.services;

import com.agendamento_consulta.dtos.MedicoRequestDTO;
import com.agendamento_consulta.dtos.MedicoResponseDTO;
import com.agendamento_consulta.mapper.MedicoMapper;
import com.agendamento_consulta.model.Medico;
import com.agendamento_consulta.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private MedicoMapper medicoMapper;

    public MedicoResponseDTO salvarMedico(MedicoRequestDTO dto){
        Medico medico = medicoMapper.toEntity(dto);
        Medico salvo = medicoRepository.save(medico);

        return medicoMapper.toResponseDto(salvo);
    }
    public List<MedicoResponseDTO> listarMedicos(){
        return medicoMapper.toDtoList(medicoRepository.findAll());
    }
    public Optional<MedicoResponseDTO> procurarPorId(Long id){
        return medicoRepository.findById(id)
                .map(medicoMapper::toResponseDto);
    }
    public MedicoResponseDTO atualizarMedico(Long id, MedicoRequestDTO dto){
        Medico atualizado = medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medico não encontrado"));

        medicoMapper.atualizarMedicoDto(dto, atualizado);

        Medico salvo = medicoRepository.save(atualizado);

        return medicoMapper.toResponseDto(salvo);
    }
    public boolean deletar(Long id){
        return medicoRepository.findById(id)
                .map(paciente -> {
                    medicoRepository.delete(paciente);
                    return true;
                })
                .orElse(false);
    }
}
