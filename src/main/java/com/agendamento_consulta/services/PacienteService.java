package com.agendamento_consulta.services;

import com.agendamento_consulta.dtos.PacienteRequestDTO;
import com.agendamento_consulta.model.Paciente;
import com.agendamento_consulta.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final ModelMapper mapper;

    public Paciente salvar(PacienteRequestDTO dto){
        Paciente paciente = Mape
    }
}
