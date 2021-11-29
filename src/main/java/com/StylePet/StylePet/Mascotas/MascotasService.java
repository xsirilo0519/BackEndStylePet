package com.StylePet.StylePet.Mascotas;

import com.StylePet.StylePet.Rol.RolModel;
import com.StylePet.StylePet.Rol.RolService;
import com.StylePet.StylePet.TipoMascota.TipoModel;
import com.StylePet.StylePet.TipoMascota.TipoService;
import com.StylePet.StylePet.Usuarios.UsuarioEntity;
import com.StylePet.StylePet.Usuarios.UsuariosModel;
import com.StylePet.StylePet.Usuarios.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MascotasService {

    private MascotasRepository mascotasRepository;
    private UsuariosService usuariosService;
    private TipoService tipoService;

    @Autowired
    public MascotasService(MascotasRepository mascotasRepository, UsuariosService usuariosService, TipoService tipoService){
    this.tipoService=tipoService;
    this.mascotasRepository=mascotasRepository;
    this.usuariosService=usuariosService;
    }

    public List<MascotasModel> findAll(){
        List<MascotasModel> mascotasModels = new ArrayList<MascotasModel>();
        try {
            mascotasRepository.findAll()
                    .forEach(mascota -> {
                                TipoModel tipoModel = tipoService.buscarById(mascota.getTipo());
                                Optional<UsuarioEntity> usuarioModel=usuariosService.findByCedula(mascota.getPropietario());
                                if (usuarioModel.isPresent()){
                                    usuarioModel.get().setRol(null);
                                }
                                UsuariosModel usuariosModel=usuariosService.converEntityToModel(usuarioModel.get());
                        mascotasModels.add(new MascotasModel(mascota.getCodigo(), mascota.getName(), tipoModel,usuariosModel));
                            }
                    );
            return mascotasModels;
        }catch (Exception e){
            return null;
        }
    }
    public MascotasModel guardar(MascotasModel mascota) {
        try{
            MascotaEntity= convertModelToEntity(mascota);
            if(!findByCedula(usuarioEntity.getCedula()).isPresent()){
                usuariosRepository.save(usuarioEntity);
                return user;
            }
        }catch (Exception e){
        }
        return null;
    }

    public MascotaEntity convertModelToEntity(MascotasModel user){
        if (user.getRol()==null){
            return new MascotaEntity(user.getCedula(), user.getName(), user.getEmail(), user.getCelular(), user.getContrasena(),1);}
        return new MascotaEntity(user.getCedula(), user.getName(), user.getEmail(), user.getCelular(), user.getContrasena(),user.getRol().getId());
    }

    public mas converEntityToModel(MascotaEntity mascota) {
        if (user.getRol()==null){
            return new UsuariosModel(user.getCedula(), user.getName(), user.getEmail(), user.getCelular(), user.getContrasena(),null);
        }
        RolModel rolModel = rolService.buscarById(user.getRol());
        return new UsuariosModel(user.getCedula(), user.getName(), user.getEmail(), user.getCelular(), user.getContrasena(),rolModel);
    }

}
