package com.StylePet.StylePet.Usuarios;

import com.StylePet.StylePet.Mascotas.MascotaEntity;
import com.StylePet.StylePet.Rol.RolEntity;
import com.StylePet.StylePet.Rol.RolModel;

import javax.persistence.*;
import java.util.List;

@Entity
public class UsuarioEntity {
    @Id
    private Long cedula;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String celular;
    @Column(nullable = false)
    private String contrasena;
    private Integer rol;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "propietario")
    private List<MascotaEntity> misMascotas;

    public UsuarioEntity(){
        super();
    }

    public UsuarioEntity(Long cedula, String name, String email, String celular, String contrasena, Integer rol) {
        this.cedula=cedula;
        this.name=name;
        this.email=email;
        this.celular=celular;
        this.contrasena=contrasena;
        this.rol=rol;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }
}
