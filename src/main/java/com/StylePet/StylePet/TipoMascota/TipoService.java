package com.StylePet.StylePet.TipoMascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoService {
    @Autowired
    TipoRepository tipoRepository;

    public TipoModel buscarById(Integer id){
        Optional<TipoEntity> tipoEntity=tipoRepository.findById(id);
        if(tipoEntity.isPresent()){
            TipoModel tipoModel= new TipoModel(tipoEntity.get().getId(),tipoEntity.get().getName());
            return tipoModel;
        }
         return null;
    }

}
