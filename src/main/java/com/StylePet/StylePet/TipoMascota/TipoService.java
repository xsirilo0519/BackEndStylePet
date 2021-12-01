package com.StylePet.StylePet.TipoMascota;

import com.StylePet.StylePet.Estilistas.EstilistasEntity;
import com.StylePet.StylePet.Estilistas.EstilistasModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<TipoModel> buscar (){
        List<TipoModel> listTipo=new ArrayList<>();
        tipoRepository.findAll().forEach(tipo->{
            listTipo.add(convertEntityToModel(tipo));
        });
        return listTipo;
    }

    private TipoModel convertEntityToModel(TipoEntity tipoEntity){
        return new TipoModel(tipoEntity.getId(),tipoEntity.getName());
    }

}
