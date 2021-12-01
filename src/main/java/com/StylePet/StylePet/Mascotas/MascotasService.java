package com.StylePet.StylePet.Mascotas;

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
                                usuarioModel.get().setRol(null);
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
             mascotaEntitys= convertModelToEntity(mascota);
            if(validar(mascotaEntitys)){
                mascota=convertEntityToModel(mascotasRepository.save(mascotaEntitys));
                mascota.setPropietario(null);
                return mascota;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public MascotasModel editar(MascotasModel mascota){
        try{
            mascotaEntitys= convertModelToEntity(mascota);
            if(findByCode(mascotaEntitys.getCodigo()).isPresent()){
                mascota=convertEntityToModel(mascotasRepository.save(mascotaEntitys));
                return mascota;
            }
        }catch (Exception e){
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
            if(mascota.getPropietario()!=null){
            UsuarioEntity usuarioEntity= usuariosService.findByCedula(mascota.getPropietario()).get();
            usuarioEntity.setMisMascotas(null);
            UsuariosModel usuariosModel=usuariosService.converEntityToModel(usuarioEntity);
            return new MascotasModel(mascota.getCodigo(), mascota.getName(),tipoModel, usuariosModel);
            }
        return new MascotasModel(mascota.getCodigo(), mascota.getName(),tipoModel, null);
    }

    private boolean validar(MascotaEntity mascotaEntity){
        return (usuariosService.findByCedula(mascotaEntitys.getPropietario()).isPresent() && (tipoService.buscarById(mascotaEntitys.getTipo())!=null));

    }

}
