package com.agendamento_consulta.controller;

import com.agendamento_consulta.dtos.*;
import com.agendamento_consulta.services.HorarioService;
import com.agendamento_consulta.services.MedicoService;
import jakarta.validation.Valid;
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
    @Autowired
    private HorarioService horarioService;
    @PostMapping
    public ResponseEntity<MedicoResponseDTO> criar(@Valid @RequestBody MedicoRequestDTO medico){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(medicoService.salvarMedico(medico));
    }
    @PostMapping("/{id}/disponibilidade")
    public ResponseEntity<DisponibilidadeResponseDTO> gerarHorarios(
            @PathVariable Long id,
            @RequestBody DisponibilidadeRequestDTO dto){
        List<HorarioResponseDTO> horariosGerados = horarioService.gerarHorarios(dto, dto.getDataInicio(), dto.getDataFim(), id);

        DisponibilidadeResponseDTO responseDTO = new DisponibilidadeResponseDTO("Horarios gerados com sucesso", horariosGerados);
        return ResponseEntity.ok(responseDTO);
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
    @PatchMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> atualizar(@Valid @PathVariable Long id, @RequestBody MedicoRequestDTO dto){
        MedicoResponseDTO atualizado = medicoService.atualizarMedico(id, dto);

        return ResponseEntity.ok(atualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMedico(@PathVariable Long id){
        if (medicoService.deletar(id)){
            return ResponseEntity.noContent().build();
        }else return ResponseEntity.notFound().build();
    }
}
