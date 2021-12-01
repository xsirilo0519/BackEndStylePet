package com.StylePet.StylePet.Citas;

import javax.persistence.*;

@Entity
@Table(name = "cita")
public class CitaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private Long codigo_mascota;
    private Integer id_corte;
    private Long estilista;
    private String hora;

    public CitaEntity(){
        super();
    }

    public CitaEntity(Long codigo, Long id_mascota, Integer corte, Long estilista,String hora) {
        this.codigo=codigo;
        this.codigo_mascota=id_mascota;
        this.estilista=estilista;
        this.id_corte=corte;
        this.hora=hora;
    }

    public CitaEntity( Long id_mascota, Integer corte, Long estilista,String hora) {
        this.codigo_mascota=id_mascota;
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

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigo_mascota() {
        return codigo_mascota;
    }

    public void setCodigo_mascota(Long codigo_mascota) {
        this.codigo_mascota = codigo_mascota;
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
