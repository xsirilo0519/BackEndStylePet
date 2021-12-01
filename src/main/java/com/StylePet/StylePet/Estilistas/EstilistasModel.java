package com.StylePet.StylePet.Estilistas;

import com.StylePet.StylePet.Turnos.TurnosModel;

import java.util.List;

public class EstilistasModel {
    private Long cedula;
    private String name;
    private List<TurnosModel> turnos;

    public EstilistasModel(Long cedula, String name) {
        this.cedula = cedula;
        this.name = name;
    }

    public EstilistasModel(Long cedula, String name, List<TurnosModel> turnos) {
        this.cedula = cedula;
        this.name = name;
        this.turnos = turnos;
    }

    public List<TurnosModel> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<TurnosModel> turnos) {
        this.turnos = turnos;
    }

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
