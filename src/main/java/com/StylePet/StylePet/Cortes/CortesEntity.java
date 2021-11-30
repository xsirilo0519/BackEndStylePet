package com.StylePet.StylePet.Cortes;

import com.StylePet.StylePet.Usuarios.UsuarioEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class CortesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true,nullable = false)
    private String name;
    @Column(unique=true,nullable = false)
    private Double precio;

    @OneToMany(cascade = CascadeType.REMOVE,orphanRemoval = true)
    @JoinColumn(name = "rol")
    private List<UsuarioEntity> usuarioEntities;

    public List<UsuarioEntity> getUsuarioEntities() {
        return usuarioEntities;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setUsuarioEntities(List<UsuarioEntity> usuarioEntities) {
        this.usuarioEntities = usuarioEntities;
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
}
