package com.StylePet.StylePet.Mascotas;

import com.StylePet.StylePet.Citas.CitaEntity;
import com.StylePet.StylePet.Usuarios.UsuarioEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mascota")
public class MascotaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(nullable = false)
    private String name;
    private Long propietario;
    @Column(nullable = false)
    private Integer tipo;

    public MascotaEntity(){
        super();
    }

    public MascotaEntity(Long codigo, String name, Integer tipo, Long propietario) {
        this.codigo=codigo;
        this.name=name;
        this.tipo=tipo;
        this.propietario=propietario;
    }
    public MascotaEntity(String name, Integer tipo, Long propietario) {
        this.name=name;
        this.tipo=tipo;
        this.propietario=propietario;
    }

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "codigo_mascota", updatable = false)
    private List<CitaEntity> citaEntities;

    public List<CitaEntity> getCitaEntities() {
        return citaEntities;
    }

    public void setCitaEntities(List<CitaEntity> citaEntities) {
        this.citaEntities = citaEntities;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPropietario() {
        return propietario;
    }

    public void setPropietario(Long propietario) {
        this.propietario = propietario;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
