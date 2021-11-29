package com.StylePet.StylePet.Usuarios;

import com.StylePet.StylePet.Rol.RolEntity;
import com.StylePet.StylePet.Rol.RolModel;
import com.StylePet.StylePet.Rol.RolRepository;
import com.StylePet.StylePet.Rol.RolService;
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

    @Autowired
    public UsuariosService (UsuariosRepository usuariosRepository, RolService rolService){
        this.rolService=rolService;
        this.usuariosRepository=usuariosRepository;
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
                usuariosRepository.save(usuarioEntity);
                return user;
            }
        }catch (Exception e){
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


    public Optional<UsuarioEntity> findByCedula(Long cedula){
        Optional<UsuarioEntity> userEntity=usuariosRepository.findById(cedula);
        return  userEntity;
    }

    public UsuarioEntity convertModelToEntity(UsuariosModel user){
        if (user.getRol()==null){
            return new UsuarioEntity(user.getCedula(), user.getName(), user.getEmail(), user.getCelular(), user.getContrasena(),1);}
        return new UsuarioEntity(user.getCedula(), user.getName(), user.getEmail(), user.getCelular(), user.getContrasena(),user.getRol().getId());
    }

    public UsuariosModel converEntityToModel(UsuarioEntity user) {
        if (user.getRol()==null){
            return new UsuariosModel(user.getCedula(), user.getName(), user.getEmail(), user.getCelular(), user.getContrasena(),null);
        }
        RolModel rolModel = rolService.buscarById(user.getRol());
        return new UsuariosModel(user.getCedula(), user.getName(), user.getEmail(), user.getCelular(), user.getContrasena(),rolModel);
    }
}
