package com.StylePet.StylePet.Mascotas;

import com.StylePet.StylePet.Rol.RolModel;
import com.StylePet.StylePet.TipoMascota.TipoModel;
import com.StylePet.StylePet.Usuarios.UsuarioEntity;
import com.StylePet.StylePet.Usuarios.UsuariosModel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class MascotasModel {

    private Long codigo;
    private String name;
    private UsuariosModel propietario;
    private TipoModel tipo;

    public MascotasModel(Long codigo, String name, TipoModel tipoModel, UsuariosModel usuario) {
        this.codigo=codigo;
        this.name=name;
        this.tipo=tipoModel;
        this.propietario=usuario;
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

    public UsuariosModel getPropietario() {
        return propietario;
    }

    public void setPropietario(UsuariosModel propietario) {
        this.propietario = propietario;
    }

    public TipoModel getTipo() {
        return tipo;
    }

    public void setTipo(TipoModel tipo) {
        this.tipo = tipo;
    }
}
