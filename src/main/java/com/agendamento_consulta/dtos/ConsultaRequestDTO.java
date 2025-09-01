package com.agendamento_consulta.dtos;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    @OneToOne
    private Long horarioId;

}
