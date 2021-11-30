package com.StylePet.StylePet.Cortes;

public class CortesModel {
    private Integer id;
    private String name;
    private double precio;

    public CortesModel(int id, String name,double precio) {
        this.id=id;
        this.name=name;
        this.precio=precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
