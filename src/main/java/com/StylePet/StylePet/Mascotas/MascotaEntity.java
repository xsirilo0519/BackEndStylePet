package com.StylePet.StylePet.Mascotas;

import javax.persistence.*;

@Entity
public class MascotaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long propietario;
    @Column(nullable = false)
    private Integer tipo;

    public MascotaEntity(){
        super();
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
