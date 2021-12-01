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
import java.util.stream.Collectors;


@Service
public class MascotasService {

    private MascotasRepository mascotasRepository;
    private UsuariosService usuariosService;
    private TipoService tipoService;
    private MascotaEntity mascotaEntitys;

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
            MascotaEntity mascotaEntity= convertModelToEntity(mascota);
            if(usuariosService.findByCedula(mascotaEntity.getPropietario()).isPresent() && (tipoService.buscarById(mascotaEntity.getTipo())!=null)){
                mascotasRepository.save(mascotaEntity);
                return mascota;
            }
        }catch (Exception e){
            System.out.println("\n -------------------------------------------------");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public MascotasModel editar(MascotasModel mascota){
        try{
            mascotaEntitys= convertModelToEntity(mascota);
            if(findByCode(mascotaEntitys.getCodigo()).isPresent()){
                mascota.setTipo(tipoService.buscarById(mascotaEntitys.getTipo()));
                UsuarioEntity usuarioEntity=usuariosService.findByCedula(mascotaEntitys.getPropietario()).get();
                mascota.setPropietario(usuariosService.converEntityToModel(usuarioEntity));
                mascotasRepository.save(mascotaEntitys);
                return mascota;
            }
        }catch (Exception e){
            System.out.println("\n -------------------------------------------------");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean eliminar(Long codigo){
        Optional<MascotaEntity> mascotaEntity=findByCode(codigo);
        if(mascotaEntity.isPresent()) {
            mascotasRepository.delete(mascotaEntity.get());
            return true;
        }
        return false;
    }

    public Optional<MascotaEntity> findByCode(Long codigo){
       return (Optional<MascotaEntity>) mascotasRepository.findById(codigo);
    }


    public MascotaEntity convertModelToEntity(MascotasModel mascota){
        return new MascotaEntity(mascota.getCodigo(), mascota.getName(), mascota.getTipo().getId(), mascota.getPropietario().getCedula());
    }

    public MascotasModel convertEntityToModel(MascotaEntity mascota){
            TipoModel tipoModel=tipoService.buscarById(mascota.getTipo());
            UsuariosModel usuariosModel=usuariosService.converEntityToModel(usuariosService.findByCedula(mascota.getPropietario()).get());
        return new MascotasModel(mascota.getCodigo(), mascota.getName(),tipoModel, usuariosModel);
    }


}
