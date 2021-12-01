package com.StylePet.StylePet.Cortes;

import com.StylePet.StylePet.Estilistas.EstilistasEntity;
import com.StylePet.StylePet.Estilistas.EstilistasModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public List<CortesModel> buscar (){
        List<CortesModel> listCortes=new ArrayList<>();
        cortesRepository.findAll().forEach(cortes->{
            listCortes.add(convertEntityToModel(cortes));
        });
        return listCortes;
    }

    private CortesModel convertEntityToModel(CortesEntity cortesEntity){
        return new CortesModel(cortesEntity.getId(),cortesEntity.getName(),cortesEntity.getPrecio());
    }

}
