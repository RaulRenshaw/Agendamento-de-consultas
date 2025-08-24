package com.agendamento_consulta.controller;

import com.agendamento_consulta.dtos.ConsultaRequestDTO;
import com.agendamento_consulta.dtos.ConsultaResponseDTO;
import com.agendamento_consulta.services.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;
    @PostMapping
    public ResponseEntity<ConsultaResponseDTO> criar(@Valid @RequestBody ConsultaRequestDTO consulta){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(consultaService.salvarConsulta(consulta));
    }
    @GetMapping
    public ResponseEntity<List<ConsultaResponseDTO>>listar(){
        return ResponseEntity.ok(consultaService.listarConsultas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> procurarPorId(@PathVariable Long id){
        return consultaService.procurarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> atualizar(@Valid @PathVariable Long id, @RequestBody ConsultaRequestDTO dto){
        ConsultaResponseDTO atualizado = consultaService.atualizarConsulta(id, dto);
        return ResponseEntity.ok(atualizado);
    }
    @DeleteMapping("/{ìd}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        if (consultaService.deletar(id)){
            return ResponseEntity.noContent().build();
        }else return ResponseEntity.notFound().build();
    }
}
