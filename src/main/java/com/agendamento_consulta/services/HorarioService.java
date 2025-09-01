package com.agendamento_consulta.services;

import com.agendamento_consulta.dtos.DisponibilidadeRequestDTO;
import com.agendamento_consulta.dtos.HorarioRequestDTO;
import com.agendamento_consulta.dtos.HorarioResponseDTO;
import com.agendamento_consulta.model.Horario;
import com.agendamento_consulta.model.Medico;
import com.agendamento_consulta.repository.HorarioRepository;
import com.agendamento_consulta.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {
    @Autowired
    private HorarioRepository horarioRepository;
    @Autowired
    private MedicoRepository medicoRepository;
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
    public List<HorarioResponseDTO> gerarHorarios(DisponibilidadeRequestDTO dto, LocalDate inicio, LocalDate fim, Long medicoId){

        Medico medico = medicoRepository.findById(medicoId)
                .orElseThrow(() -> new IllegalArgumentException("medico não encontrado"));
        List<HorarioResponseDTO> gerados = new ArrayList<>();

        LocalDate data = inicio;
        while (!data.isAfter(fim)){
            if (dto.getDiasSemana().contains(data.getDayOfWeek().toString())){
                LocalTime hora = dto.getHoraInicio();
                while (!hora.plusMinutes(dto.getDuracao()).isAfter(dto.getHoraFim())){
                    Horario horario = new Horario();
                    horario.setData(data);
                    horario.setHoraInicio(hora);
                    horario.setHoraFim(hora.plusMinutes(dto.getDuracao()));
                    horario.setMedico(medico);

                    Optional<Horario> existe = horarioRepository.findByDataAndHoraInicioAndHoraFim(
                            horario.getData(), horario.getHoraInicio(), horario.getHoraFim());
                    if (existe.isEmpty()){
                        horarioRepository.save(horario);
                        gerados.add(HorarioResponseDTO.fromEntity(horario));
                    }
                    hora = hora.plusMinutes(dto.getDuracao());
                }
            }
            data = data.plusDays(1);
        }
        return gerados;
    }
}
