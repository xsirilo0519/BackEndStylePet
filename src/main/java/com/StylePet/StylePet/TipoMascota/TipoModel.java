package com.StylePet.StylePet.TipoMascota;

public class TipoModel {
    private Integer id;
    private String name;

    public TipoModel(int id, String name) {
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
