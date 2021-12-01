package com.StylePet.StylePet.TipoMascota;

import com.StylePet.StylePet.Mascotas.MascotaEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipo_mascota")
public class TipoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true,nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "tipo")
    private List<MascotaEntity> mascotaEntities;

    public List<MascotaEntity> getMascotaEntities() {
        return mascotaEntities;
    }

    public void setMascotaEntities(List<MascotaEntity> mascotaEntities) {
        this.mascotaEntities = mascotaEntities;
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
