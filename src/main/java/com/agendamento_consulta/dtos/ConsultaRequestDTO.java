package com.agendamento_consulta.dtos;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
