package com.StylePet.StylePet.TipoMascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoService {
    @Autowired
    TipoRepository rolRepository;

    public TipoModel buscarById(Integer id){
        Optional<TipoEntity> mascotaEntity=rolRepository.findById(id);
        if(mascotaEntity.isPresent()){
            TipoModel tipoModel= new TipoModel(mascotaEntity.get().getId(),mascotaEntity.get().getName());
            return tipoModel;
        }
         return null;
    }

}
