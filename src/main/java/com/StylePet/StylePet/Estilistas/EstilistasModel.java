package com.StylePet.StylePet.Estilistas;

public class EstilistasModel {
    private Long cedula;
    private String name;

    public EstilistasModel(Long cedula, String name) {
        this.cedula = cedula;
        this.name = name;
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
