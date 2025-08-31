package com.agendamento_consulta.services;

import com.agendamento_consulta.dtos.HorarioRequestDTO;
import com.agendamento_consulta.dtos.HorarioResponseDTO;
import com.agendamento_consulta.model.Horario;
import com.agendamento_consulta.repository.HorarioRepository;
import org.apache.coyote.http2.HpackDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {
    @Autowired
    private HorarioRepository horarioRepository;
    public HorarioResponseDTO salvar(HorarioRequestDTO dto){
        Optional<Horario> existe = horarioRepository.findByDataAndHoraInicioAndHoraFim(
                dto.getData(), dto.getHoraInicio(), dto.getHoraFim());

        if (existe.isPresent()){
            throw new IllegalArgumentException("Já existe um horario igual");
        }

        Horario horario = new Horario();
        horario.setData(dto.getData());
        horario.setHoraInicio(dto.getHoraInicio());
        horario.setHoraFim(dto.getHoraFim());

        return HorarioResponseDTO.fromEntity(horario);
    }
    public List<HorarioResponseDTO> listarHorarios(){
        return HorarioResponseDTO.fromEntityList(horarioRepository.findAll());
    }
    public Optional<HorarioResponseDTO> procurarPorId(Long id){
        return horarioRepository.findById(id)
                .map(HorarioResponseDTO::fromEntity);
    }
    public boolean deletar(Long id){
        return horarioRepository.findById(id)
                .map(horario -> {
                    horarioRepository.delete(horario);
                    return true;
                })
                .orElse(false);
    }
}
