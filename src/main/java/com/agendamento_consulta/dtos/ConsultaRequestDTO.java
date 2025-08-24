package com.agendamento_consulta.dtos;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConsultaRequestDTO {

    @ManyToOne
    @NotNull
    private Long medicoId;

    @ManyToOne
    @NotNull
    private Long pacienteId;

    @NotNull
    @Future(message = "A data e hora devem estar no futuro")
    private LocalDateTime dataHora;
}
