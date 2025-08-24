package com.agendamento_consulta.services;

import com.agendamento_consulta.dtos.MedicoRequestDTO;
import com.agendamento_consulta.dtos.MedicoResponseDTO;
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
    public MedicoResponseDTO salvarMedico(MedicoRequestDTO dto){
        Medico medico = new Medico();
        medico.setNome(dto.getNome());
        medico.setCrm(dto.getCrm());
        medico.setSpecialty(dto.getSpecialty());
        medico.setEmail(dto.getEmail());
        medico.setTelefone(dto.getTelefone());

        return MedicoResponseDTO.fromEntity(medicoRepository.save(medico));
    }
    public List<MedicoResponseDTO> listarMedicos(){
        return MedicoResponseDTO.fromEntityList(medicoRepository.findAll());
    }
    public Optional<MedicoResponseDTO> procurarPorId(Long id){
        return medicoRepository.findById(id)
                .map(MedicoResponseDTO::fromEntity);
    }
    public MedicoResponseDTO atualizarMedico(Long id, MedicoRequestDTO dto){
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medico não encontrado"));

        if (dto.getNome() != null) medico.setNome(dto.getNome());
        if (dto.getCrm() != null) medico.setCrm(dto.getCrm());
        if (dto.getSpecialty() != null) medico.setSpecialty(dto.getSpecialty());
        if (dto.getEmail() != null) medico.setEmail(dto.getEmail());
        if (dto.getTelefone() != null) medico.setTelefone(dto.getTelefone());

        Medico atualizado = medicoRepository.save(medico);
        return MedicoResponseDTO.fromEntity(atualizado);
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
