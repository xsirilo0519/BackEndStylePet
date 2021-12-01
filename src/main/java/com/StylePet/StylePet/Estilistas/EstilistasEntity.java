package com.StylePet.StylePet.Estilistas;

import com.StylePet.StylePet.Citas.CitaEntity;
import com.StylePet.StylePet.Usuarios.UsuarioEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estilista")
public class EstilistasEntity {
    @Id
    private Long cedula;
    @Column(unique = true,nullable = false)
    private String name;

    public EstilistasEntity() {
    }

    @OneToMany(cascade = CascadeType.REMOVE,orphanRemoval = true)
    @JoinColumn(name = "estilista")
    private List<CitaEntity> citaEntities;

    public List<CitaEntity> getCitaEntities() {
        return citaEntities;
    }

    public void setCitaEntities(List<CitaEntity> citaEntities) {
        this.citaEntities = citaEntities;
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
