package com.StylePet.StylePet.Cortes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CortesService {
    @Autowired
    CortesRepository cortesRepository;

    public CortesModel buscarById(Integer id){
        Optional<CortesEntity> cortesEntity =cortesRepository.findById(id);
        if(cortesEntity.isPresent()){
            CortesModel cortesModel= new CortesModel(cortesEntity.get().getId(),cortesEntity.get().getName(),cortesEntity.get().getPrecio());
            return cortesModel;
        }
         return null;
    }

}
