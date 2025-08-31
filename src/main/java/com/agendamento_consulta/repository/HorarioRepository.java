package com.agendamento_consulta.repository;

import com.agendamento_consulta.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {
    Optional<Horario> findByDataAndHoraInicioAndHoraFim(LocalDate data, LocalTime horaInicio, LocalTime horaFim);
}
