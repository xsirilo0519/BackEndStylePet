package com.StylePet.StylePet.Citas;

import com.StylePet.StylePet.Cortes.CortesModel;
import com.StylePet.StylePet.Estilistas.EstilistasModel;
import com.StylePet.StylePet.Mascotas.MascotasModel;
import com.StylePet.StylePet.TipoMascota.TipoModel;
import com.StylePet.StylePet.Usuarios.UsuariosModel;

public class CitasModel {

    private Long codigo;
    private MascotasModel codigo_mascota;
    private CortesModel id_corte;
    private EstilistasModel estilista;
    private String hora;

    public CitasModel(Long codigo, MascotasModel codigo_mascota, CortesModel id_corte, EstilistasModel estilista,String hora) {
        this.codigo = codigo;
        this.codigo_mascota = codigo_mascota;
        this.id_corte = id_corte;
        this.estilista = estilista;
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

    public MascotasModel getCodigo_mascota() {
        return codigo_mascota;
    }

    public void setCodigo_mascota(MascotasModel codigo_mascota) {
        this.codigo_mascota = codigo_mascota;
    }

    public CortesModel getId_corte() {
        return id_corte;
    }

    public void setId_corte(CortesModel id_corte) {
        this.id_corte = id_corte;
    }

    public EstilistasModel getEstilista() {
        return estilista;
    }

    public void setEstilista(EstilistasModel estilista) {
        this.estilista = estilista;
    }
}
