package com.StylePet.StylePet.Turnos;

import javax.persistence.*;

@Entity
@Table(name = "turno")
public class TurnoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String turno;
    private Long ced_estilista;
    @Column( nullable = false)
    private boolean estado;

    public TurnoEntity() {
    }

    public TurnoEntity(Integer id, String turno, Boolean estado, Long cedula) {
        this.id=id;
        this.turno=turno;
        this.estado=estado;
        this.ced_estilista=cedula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Long getCed_estilista() {
        return ced_estilista;
    }

    public void setCed_estilista(Long ced_estilista) {
        this.ced_estilista = ced_estilista;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
