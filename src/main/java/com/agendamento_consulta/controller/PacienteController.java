package com.agendamento_consulta.controller;

import com.agendamento_consulta.dtos.PacienteRequestDTO;
import com.agendamento_consulta.dtos.PacienteResponseDTO;
import com.agendamento_consulta.model.Paciente;
import com.agendamento_consulta.services.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> criar(@RequestBody PacienteRequestDTO paciente){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pacienteService.salvarPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> listar(){
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }

}
