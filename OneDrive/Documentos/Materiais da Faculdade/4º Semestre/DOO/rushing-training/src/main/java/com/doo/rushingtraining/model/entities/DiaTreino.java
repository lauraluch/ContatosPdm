package com.doo.rushingtraining.model.entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class DiaTreino {
    private GrupoTreino grupoTreino;
    private LocalDate dataTreino;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    DiaTreino(GrupoTreino grupoTreino, LocalDate dataTreino, LocalTime horaInicio, LocalTime horaFim) {
        this.grupoTreino = grupoTreino;
        this.dataTreino = dataTreino;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    @Override
    public String toString(){
        return "DiaTreino: " +
                " grupoTreino=" + grupoTreino +
                " dataTreino=" + dataTreino +
                " horaInicio=" + horaInicio +
                " horaFim=" + horaFim;
    }

    public GrupoTreino getGrupoTreino() {
        return grupoTreino;
    }

    public void setGrupoTreino(GrupoTreino grupoTreino) {
        this.grupoTreino = grupoTreino;
    }

    public LocalDate getDataTreino() {
        return dataTreino;
    }

    public void setDataTreino(LocalDate dataTreino) {
        this.dataTreino = dataTreino;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }
}
