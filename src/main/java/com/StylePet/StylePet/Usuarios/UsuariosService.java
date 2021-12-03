package com.StylePet.StylePet.Usuarios;

import com.StylePet.StylePet.Mascotas.MascotaEntity;
import com.StylePet.StylePet.Mascotas.MascotasModel;
import com.StylePet.StylePet.Rol.RolModel;
import com.StylePet.StylePet.Rol.RolService;
import com.StylePet.StylePet.TipoMascota.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UsuariosService {

    private UsuariosRepository usuariosRepository;
    private RolService rolService;
    private UsuarioEntity usuarioEntity;
    private TipoService tipoService;

    @Autowired
    public UsuariosService (UsuariosRepository usuariosRepository, RolService rolService, TipoService tipoService){
        this.rolService=rolService;
        this.usuariosRepository=usuariosRepository;
        this.tipoService=tipoService;
    }

    public UsuariosModel guardar(UsuariosModel user) {
            try{
                usuarioEntity= convertModelToEntity(user);
                if(!findByCedula(usuarioEntity.getCedula()).isPresent()){
                    user=converEntityToModel(usuariosRepository.save(usuarioEntity));
                    return user;
                }
            }catch (Exception e){
            }
        return null;
    }

    public UsuariosModel editar(UsuariosModel user){
        try{
            usuarioEntity= convertModelToEntity(user);
            if(findByCedula(usuarioEntity.getCedula()).isPresent()){
                user=converEntityToModel(usuariosRepository.save(usuarioEntity));
                return user;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public UsuariosModel login(LoginModel loginModel){
       Optional<UsuarioEntity> usuarioEntity=  usuariosRepository.findByEmailAndContrasena(loginModel.getEmail(),loginModel.getContrasena());
        if(usuarioEntity.isPresent()){
            return converEntityToModel(usuarioEntity.get());
        }
        return null;
    }

    public Optional<UsuarioEntity> findByCedula(Long cedula){
        return (Optional<UsuarioEntity>) usuariosRepository.findById(cedula);
    }


    public UsuarioEntity convertModelToEntity(UsuariosModel user){
        if (user.getRol()==null){
            return new UsuarioEntity(user.getCedula(), user.getName(), user.getEmail(), user.getCelular(), user.getContrasena(),1);}
        return new UsuarioEntity(user.getCedula(), user.getName(), user.getEmail(), user.getCelular(), user.getContrasena(),user.getRol().getId());
    }

    public UsuariosModel converEntityToModel(UsuarioEntity user) {

        if (user.getRol()==null){
            return new UsuariosModel(user.getCedula(), user.getName(), user.getEmail(), user.getCelular(), user.getContrasena(),null,ListEntityToModel(user.getMisMascotas()));
        }
        RolModel rolModel = rolService.buscarById(user.getRol());
        return new UsuariosModel(user.getCedula(), user.getName(), user.getEmail(), user.getCelular(), user.getContrasena(),rolModel,ListEntityToModel(user.getMisMascotas()));
    }

    private List<MascotasModel> ListEntityToModel(List<MascotaEntity> list){
        List<MascotasModel>mascotasModels=new ArrayList<>();
        if(list!=null){
            list.forEach(x->{
                mascotasModels.add(new MascotasModel(x.getCodigo(),x.getName(),tipoService.buscarById(x.getTipo()),null));
            });
        }
        return mascotasModels;
    }
}
