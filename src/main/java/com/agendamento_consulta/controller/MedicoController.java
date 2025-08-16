package com.agendamento_consulta.controller;

import com.agendamento_consulta.dtos.MedicoRequestDTO;
import com.agendamento_consulta.dtos.MedicoResponseDTO;
import com.agendamento_consulta.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<MedicoResponseDTO> criar(@RequestBody MedicoRequestDTO medico){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(medicoService.salvarMedico(medico));
    }
    @GetMapping
    public ResponseEntity<List<MedicoResponseDTO>> listar(){
        return ResponseEntity.ok(medicoService.listarMedicos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> procurarPorId(@PathVariable Long id){
        return medicoService.procurarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping
    public ResponseEntity<Void> deletarMedico(@PathVariable Long id){
        if (medicoService.deletar(id)){
            return ResponseEntity.noContent().build();
        }else return ResponseEntity.notFound().build();
    }
}
