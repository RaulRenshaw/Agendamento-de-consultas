package com.agendamento_consulta.services;

import com.agendamento_consulta.dtos.MedicoRequestDTO;
import com.agendamento_consulta.dtos.MedicoResponseDTO;
import com.agendamento_consulta.mapper.MedicoMapper;
import com.agendamento_consulta.model.Medico;
import com.agendamento_consulta.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper;

    public MedicoResponseDTO salvarMedico(MedicoRequestDTO dto){

        Medico medico = medicoMapper.toEntity(dto);
        Medico salvo = medicoRepository.save(medico);

        return medicoMapper.toResponseDto(salvo);
    }

    public List<Medico> listarMedicos(){
        return medicoRepository.findAll();
    }

    public Optional<Medico> procurarPorId(Long id){
        return medicoRepository.findById(id);
    }

    public MedicoResponseDTO atualizarMedico(Long id, MedicoRequestDTO dto){
        Medico atualizado = medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medico não encontrado"));

        medicoMapper.atualizarMedicoDoDto(dto, atualizado);

        Medico salvo = medicoRepository.save(atualizado);

        return medicoMapper.toResponseDto(atualizado);
    }

    public void deletar(Long id){
        medicoRepository.deleteById(id);
    }
}
