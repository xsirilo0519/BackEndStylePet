package com.StylePet.StylePet.Usuarios;

import com.StylePet.StylePet.Mascotas.MascotasModel;
import com.StylePet.StylePet.Rol.RolModel;
import com.StylePet.StylePet.Rol.RolService;
import com.StylePet.StylePet.Turnos.TurnosModel;
import com.StylePet.StylePet.Turnos.TurnosService;
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

    public List<UsuariosModel> findAll(){
        List<UsuariosModel> userModel = new ArrayList<UsuariosModel>();
        try {
            usuariosRepository.findAll()
                    .forEach(user -> {
                        userModel.add(converEntityToModel(user));
                    }
            );
            return userModel;
        }catch (Exception e){
            return null;
        }

    }
    public UsuariosModel guardar(UsuariosModel user) {
            try{
                usuarioEntity= convertModelToEntity(user);
                if(!findByCedula(usuarioEntity.getCedula()).isPresent()){
                    usuariosRepository.save(usuarioEntity);
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
                user.setRol(rolService.buscarById(usuarioEntity.getRol()));
                 usuarioEntity.getMisMascotas();
                usuariosRepository.save(usuarioEntity);
                return user;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean eliminar(Long cedula){
        Optional<UsuarioEntity> userEntity=findByCedula(cedula);
        if(userEntity.isPresent()) {
            usuariosRepository.delete(userEntity.get());
            return true;
        }
        return false;
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
       List<MascotasModel>mascotasModels=new ArrayList<>();
       if(user.getMisMascotas()!=null){
                user.getMisMascotas().forEach(x->{

                    mascotasModels.add(new MascotasModel(x.getCodigo(),x.getName(),tipoService.buscarById(x.getTipo()),null));
                });
       }
        if (user.getRol()==null){
            return new UsuariosModel(user.getCedula(), user.getName(), user.getEmail(), user.getCelular(), user.getContrasena(),null,null);
        }
        RolModel rolModel = rolService.buscarById(user.getRol());
        return new UsuariosModel(user.getCedula(), user.getName(), user.getEmail(), user.getCelular(), user.getContrasena(),rolModel,mascotasModels);
    }
}
