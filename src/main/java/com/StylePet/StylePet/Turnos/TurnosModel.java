package com.StylePet.StylePet.Turnos;

import com.StylePet.StylePet.Estilistas.EstilistasModel;

import javax.persistence.Column;

public class TurnosModel {
    private Integer id;
    private String turno;
    private EstilistasModel ced_estilista;
    private Boolean estado;

    public TurnosModel(Integer id, String turno, EstilistasModel ced_estilista, Boolean estado) {
        this.id = id;
        this.turno = turno;
        this.ced_estilista = ced_estilista;
        this.estado = estado;
    }

    public EstilistasModel getCed_estilista() {
        return ced_estilista;
    }

    public void setCed_estilista(EstilistasModel ced_estilista) {
        this.ced_estilista = ced_estilista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
