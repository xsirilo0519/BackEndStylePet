package com.StylePet.StylePet.Usuarios;

import com.StylePet.StylePet.Rol.RolEntity;
import com.StylePet.StylePet.Rol.RolModel;

public class UsuariosModel {

    private Long cedula;
    private String name;
    private String email;
    private String celular;
    private String contrasena;
    private RolModel rol;

    public UsuariosModel(Long cedula, String name, String email, String celular, String contrasena,RolModel rol) {
        this.cedula = cedula;
        this.name = name;
        this.email = email;
        this.celular = celular;
        this.contrasena = contrasena;
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

    public RolModel getRol() {
        return rol;
    }

    public void setRol(RolModel rol) {
        this.rol = rol;
    }
}
