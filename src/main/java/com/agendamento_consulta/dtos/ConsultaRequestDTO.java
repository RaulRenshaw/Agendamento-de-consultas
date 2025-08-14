package com.agendamento_consulta.dtos;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class ConsultaRequestDTO {

    @ManyToOne
    @NotNull
    @Getter
    @Setter
    private Long medicoId;

    @ManyToOne
    @NotNull
    @Getter
    @Setter
    private Long pacienteId;

    @Getter
    @NotNull
    @Future(message = "A data e hora devem estar no futuro")
    private LocalDateTime localDateTime;
}
