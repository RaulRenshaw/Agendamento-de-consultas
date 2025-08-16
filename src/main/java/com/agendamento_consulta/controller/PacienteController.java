package com.agendamento_consulta.controller;

import com.agendamento_consulta.dtos.PacienteRequestDTO;
import com.agendamento_consulta.dtos.PacienteResponseDTO;
import com.agendamento_consulta.model.Paciente;
import com.agendamento_consulta.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> criar(@RequestBody PacienteRequestDTO paciente){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pacienteService.salvarPaciente(paciente));
    }
    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> listar(){
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> procurarPorId(@PathVariable Long id){
        return pacienteService.porcurarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id){
        if (pacienteService.deletarPaciente(id)){
            return ResponseEntity.noContent().build();
        }else return ResponseEntity.notFound().build();
    }
}
