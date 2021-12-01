package com.StylePet.StylePet.Estilistas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstilistasService {
    @Autowired
    EstilistasRepository cortesRepository;

    public EstilistasModel buscarById(Long id){
        Optional<EstilistasEntity> estilistasEntity =cortesRepository.findById(id);
        if(estilistasEntity.isPresent()){
            EstilistasModel estilistasModel= new EstilistasModel(estilistasEntity.get().getCedula(),estilistasEntity.get().getName());
            return estilistasModel;
        }
         return null;
    }

}
