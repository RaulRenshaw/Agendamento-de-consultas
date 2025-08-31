package com.agendamento_consulta.exception;

public class HorarioIndisponivelException extends RuntimeException{
    public HorarioIndisponivelException(String mensagem){
        super(mensagem);
    }
}
