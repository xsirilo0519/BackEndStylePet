package com.StylePet.StylePet.Cortes;

import com.StylePet.StylePet.Citas.CitaEntity;
import com.StylePet.StylePet.Usuarios.UsuarioEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cortes")
public class CortesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true,nullable = false)
    private String name;
    @Column(unique=true,nullable = false)
    private Double precio;

    @OneToMany(cascade = CascadeType.REMOVE,orphanRemoval = true)
    @JoinColumn(name = "id_corte")
    private List<CitaEntity> citaEntities;

    public CortesEntity() {
    }

    public CortesEntity(String name, Double precio) {
        this.name = name;
        this.precio = precio;
    }

    public List<CitaEntity> getCitaEntities() {
        return citaEntities;
    }

    public void setCitaEntities(List<CitaEntity> citaEntities) {
        this.citaEntities = citaEntities;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
