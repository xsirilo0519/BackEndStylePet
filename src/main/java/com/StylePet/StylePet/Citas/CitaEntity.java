package com.StylePet.StylePet.Citas;

import javax.persistence.*;

@Entity
@Table(name = "cita")
public class CitaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private Long codigomascota;
    private Integer id_corte;
    private Long estilista;
    private String hora;

    public CitaEntity(){
        super();
    }

    public CitaEntity(Long codigo, Long id_mascota, Integer corte, Long estilista,String hora) {
        this.codigo=codigo;
        this.codigomascota=id_mascota;
        this.estilista=estilista;
        this.id_corte=corte;
        this.hora=hora;
    }

    public CitaEntity( Long id_mascota, Integer corte, Long estilista,String hora) {
        this.codigomascota=id_mascota;
        this.estilista=estilista;
        this.id_corte=corte;
        this.hora=hora;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }


    public Long getCodigomascota() {
        return codigomascota;
    }

    public void setCodigomascota(Long codigomascota) {
        this.codigomascota = codigomascota;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }


    public Integer getId_corte() {
        return id_corte;
    }

    public void setId_corte(Integer id_corte) {
        this.id_corte = id_corte;
    }

    public Long getEstilista() {
        return estilista;
    }

    public void setEstilista(Long estilista) {
        this.estilista = estilista;
    }
}
